package model

import play.api.libs.json.Reads._
import play.api.libs.json._
import java.util.UUID.randomUUID

object Etage {
  implicit val format = Json.format[Etage]

  // #laRécursion :)
  def generateEtages(nbEtage: Int): Seq[Etage] = {
    def generateEtages(nbEtage: Int, acc: Seq[Etage]): Seq[Etage] = {
      val random = scala.util.Random
      nbEtage match {
        case nbE if nbE > -1 =>
          val nbPlaceHandicap = random.nextInt(20) + 15
          val nbPlacePriseHandicap = random.nextInt(15)
          val nbPlaceTotal = random.nextInt(100) + nbPlaceHandicap + 70
          val nbPlacePriseTotal = random.nextInt(70) + nbPlaceHandicap
          generateEtages(nbE-1, Etage(s"étage $nbE", nbPlaceHandicap, nbPlacePriseHandicap, nbPlacePriseTotal, nbPlaceTotal) +: acc)
        case _ => acc
      }
    }
    generateEtages(nbEtage, Nil)
  }
}

case class Etage(
                  nomEtage : String,
                  nbPlaceHandicap: Int,
                  nbPlacePriseHandicap: Int,
                  nbPlacePriseTotal: Int,
                  nbPlaceTotal : Int,
)

//class Etage(etageName : String){
//  var pl = Array[Array[Place]]();
//
//  def name = etageName;
//
//  def generateEtage (raw : Integer, column : Integer, nbHandicape : Integer): Etage =
//  {
//      var i = 1;
//      var j = 0;
//      var handy = 0;
//      for ( i <- 1 to raw)
//      {
//          var eta = new Array[Place](0);
//          for ( j <- 1 to column) {
//
//            if (handy <= nbHandicape) {
//              eta :+= new Place(false, true, j, i);
//              handy = handy + 1;
//            }
//            else {
//              eta :+= new Place(false, false, j, i);
//            }
//          }
//          pl :+= eta;
//      }
//      return this;
//  }
//
//  def toHtml () : String =
//  {
//      var etageInHtml = name;
//
//      for (raw <- pl) {
//        etageInHtml = etageInHtml + "    "
//        for (onePlace <- raw) {
//          etageInHtml = etageInHtml + onePlace.toHtml
//        }
//        etageInHtml = etageInHtml + "    "
//      }
//
//      return etageInHtml;
//  }
//}
