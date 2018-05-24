package controllers

import java.io.File

import com.google.inject.Inject
import com.typesafe.config.{Config, ConfigFactory}
import core.common.MLogger
import lib.WebpackBuildFile
import play.Environment
import play.api.mvc.Results.Redirect
import play.api.mvc._

class FrontController @Inject() (cc: ControllerComponents, env: Environment, authenticatedUserAction: AuthenticatedUserAction) extends AbstractController(cc){
  val config: Config = ConfigFactory.parseFile(new File("conf/frontend.conf")).resolve()
  val controllerLogger : MLogger= new MLogger("controller")

  def index = Action {
    Ok(views.html.index.render(env, config.getInt("webpack.port"), WebpackBuildFile.jsBundle, WebpackBuildFile.cssBundle))
  }

  def logout = authenticatedUserAction{ implicit request =>

    Redirect(routes.FrontController.index()).withSession("USERNAME" -> "" )
  }

  def showTableauDeBord = authenticatedUserAction{ implicit request =>
    controllerLogger.debug("show tableDeBord")
    Ok(views.html.tableauDeBord.render(env, config.getInt("webpack.port"), WebpackBuildFile.jsBundle, WebpackBuildFile.cssBundle))
  }

}
