package model

class Place(occupe : Boolean, handicape : Boolean, column : Integer, raw : Integer) {
  def occ = occupe
  def hand = handicape
  def col = column
  def ra = raw
  override def toString() =
    "Place " + (if (handicape) " pour handicapé et " else "") + (if (occupe) "occupée" else "libre")


  def toHtml () : String =
  {
    return (if (handicape) " Handicapé " else "") + (if (occupe) " occupée " else " libre ")
  }

}
