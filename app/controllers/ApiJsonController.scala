package controllers

import com.google.inject.Inject
import play.Environment
import play.api.mvc._

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Place(quote: String, name: String)
case class AuthFields(login: String, password: String)

class ApiJsonController @Inject()  (cc: ControllerComponents, env: Environment) extends AbstractController(cc){

  implicit val placeWrites: Writes[Place] = (
    (JsPath \ "quote").write[String] and
      (JsPath \ "name").write[String]
    )(unlift(Place.unapply))

  def getRandomQuote() = Action {

    implicit request => {

      val r = scala.util.Random
      val randomInt = r.nextInt(100)
      val place = Place("random->" + randomInt, "n1")
      val json = Json.toJson(place)

      Ok(json)

    }

  }

  implicit val authFieldsRead: Reads[AuthFields] = {
    (
      (JsPath \ "login").read[String] and
      (JsPath \ "password").read[String]
    )(AuthFields.apply _)
  }

  def validerAuthentificate() = Action(parse.json[AuthFields]){ implicit request =>
    val authField = request.body
    println("login [%s], password [%s]".format(authField.login, authField.password))
    if (authField.login.equals("test@g.com") && authField.password.equals("azertyx1")){
      Ok
    }else{
      Unauthorized
    }
  }

}