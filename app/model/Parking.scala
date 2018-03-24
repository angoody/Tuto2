package model

import play.api.libs.json.Reads._
import play.api.libs.json._

object Parking {
  implicit val format = Json.format[Parking]

  def generateParking(nbEtage: Int): Parking = Parking(Etage.generateEtages(nbEtage))


  def toHtml(parking: Parking) = parking.etage.map{e => s"- L'${e.nomEtage} possède :  - un total de ${e.nbPlaceTotal} places, dont ${e.nbPlaceHandicap} places pour handicapé - ${e.nbPlacePriseTotal} places sont prises, dont ${e.nbPlacePriseHandicap} places pour handicapé"}.mkString(" ")
}

case class Parking(
                    etage: Seq[Etage]
                  )


// ce que tu as fais toi
//class Parking (){
//  var eta = Array[Etage]();
//
//  def addEtage (etage : Etage) = {
//    eta :+= etage
//  }
//
//
//  def generateParking (nbEtage : Integer, column : Integer, raw : Integer, nbHandycape : Integer) =
//  {
//      var i = 0;
//
//      for (i <- 1 to nbEtage)
//      {
//          addEtage(new Etage("Etage " + i) generateEtage(raw, column, nbHandycape))
//      }
//  }
//
//  def toHtml () : String =
//  {
//    var etageInHtml = "";
//
//    for (etage <- eta) {
//      etageInHtml = etageInHtml + "    "
//      etageInHtml = etageInHtml + etage.toHtml()
//      etageInHtml = etageInHtml + "    "
//    }
//
//    return etageInHtml;
//  }
//}