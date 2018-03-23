package controllers

import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._
import java.util
import javax.inject.{Inject, Singleton}
import model.{Etage,Parking}
import play.api.mvc.{AbstractController, ControllerComponents}


import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.json.Json.toJson
import play.api.libs.json._
import play.api.mvc._

import scala.concurrent.ExecutionContext

class BonjourController @Inject()(cc : ControllerComponents) extends AbstractController(cc){
//  def index = Action {
//    var parking = new Parking()
//    parking.generateParking (4,5,2,5)
//    Ok(views.html.Bonjour("Bienvenue", date, parking.toHtml ))
//  }

  def index = Action {
    // /!\ N.B : Il est préférable d'utiliser l'immutabilité; on évite par conséquent les var au profit des val :)


    // Si on découpe, on peut avoir ca :
    // -> Crea du random pour le nb d'etages
    // val random = scala.util.Random.nextInt(10)
    // -> Crea du parking
    // val parking = Parking.generateParking(random)
    // -> "Redirect" vers la route
    // Ok(toJson[Parking](parking)) // toJson pq on veut renvoyer un json, tout simplement :) Et grace à notre case class Parking dans model, c'est possible !

    // Pour faire appel à cette route en local, quand le serveur est lancé (sbt run dans la console) -> localhost:9000; Cela retournera un JSON
    // Ok(toJson[Parking](Parking.generateParking(scala.util.Random.nextInt(10))))

    // Pour faire un affichage comme ca que tu avais fait toi
    // Génération de mon parking avec un nb random d'étage (pas plus de 10 quand même ^^)
    val parking: Parking = Parking.generateParking(scala.util.Random.nextInt(10))
    // On affiche dans le navigateur :)
    Ok(views.html.Bonjour("Bienvenue", date, Parking.toHtml(parking) ))
  }

  def date : String = {
      getDateTimeInstance(LONG, SHORT, Locale.FRANCE) format new Date
  }

}
