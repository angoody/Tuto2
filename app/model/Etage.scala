package model

class Etage(etageName : String){
  var pl = Array[Array[Place]]();

  def name = etageName;


  def generateEtage (raw : Integer, column : Integer, nbHandicape : Integer): Etage =
  {
      var i = 1;
      var j = 0;
      var handy = 0;
      for ( i <- 1 to raw)
      {
          var eta = new Array[Place](0);
          for ( j <- 1 to column) {

            if (handy <= nbHandicape) {
              eta :+= new Place(false, true, j, i);
              handy = handy + 1;
            }
            else {
              eta :+= new Place(false, false, j, i);
            }
          }
          pl :+= eta;
      }
      return this;
  }

  def toHtml () : String =
  {
      var etageInHtml = name;

      for (raw <- pl) {
        etageInHtml = etageInHtml + "    "
        for (onePlace <- raw) {
          etageInHtml = etageInHtml + onePlace.toHtml
        }
        etageInHtml = etageInHtml + "    "
      }

      return etageInHtml;
  }
}
