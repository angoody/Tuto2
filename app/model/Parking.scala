package model

class Parking (){
  var eta = Array[Etage]();

  def addEtage (etage : Etage) = {
    eta :+= etage
  }


  def generateParking (nbEtage : Integer, column : Integer, raw : Integer, nbHandycape : Integer) =
  {
      var i = 0;

      for (i <- 1 to nbEtage)
      {
          addEtage(new Etage("Etage " + i) generateEtage(raw, column, nbHandycape))
      }
  }

  def toHtml () : String =
  {
    var etageInHtml = "";

    for (etage <- eta) {
      etageInHtml = etageInHtml + "    "
      etageInHtml = etageInHtml + etage.toHtml()
      etageInHtml = etageInHtml + "    "
    }

    return etageInHtml;
  }
}
