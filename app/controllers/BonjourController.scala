package controllers

import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._
import java.util
import javax.inject.{Inject, Singleton}

import model.{Parking, Place, Voiture}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class BonjourController  @Inject()(cc: ControllerComponents) extends AbstractController(cc){
  def index = Action {
    var parking = new Parking()
    parking.generateParking (4,5,2,5)
    Ok(views.html.Bonjour("Bienvenue", date, parking.toHtml ))
  }

  def date : String = {
      getDateTimeInstance(LONG, SHORT, Locale.FRANCE) format new Date
  }

}
