package controllers

import core.common.MLogger
import javax.inject.Inject
import play.api.mvc._
import play.api.mvc.Results._

import scala.concurrent.{ExecutionContext, Future}

class AuthenticatedUserAction @Inject() (parser: BodyParsers.Default)(implicit ec: ExecutionContext)
  extends ActionBuilderImpl(parser) {

  private val logger = play.api.Logger(this.getClass)

  private val serviceLogger : MLogger= new MLogger("service")

  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    logger.debug("ENTERED AuthenticatedUserAction::invokeBlock")
    val maybeUsername = request.session.get("USERNAME")

    maybeUsername match {
      case None => {
        serviceLogger.debug("CAME INTO 'NONE'")
        //Future.successful(Forbidden("Dude, you’re not logged in."))
        Future.successful(Redirect(routes.FrontController.index()))
      }
      case Some("") =>{
        serviceLogger.debug("CAME INTO 'EMPTY'")
        //Future.successful(Forbidden("Dude, you’re not logged in."))
        Future.successful(Redirect(routes.FrontController.index()))
      }
      case Some(u) => {
        serviceLogger.debug("CAME INTO 'SOME'")
        val res: Future[Result] = block(request)
        res
      }
    }
  }
}
