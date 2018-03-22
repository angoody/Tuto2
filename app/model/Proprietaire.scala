package model

class Proprietaire (nom : String, prenom : String, voiture : Voiture) {
  def voit = voiture
  def leNom = nom
  def lePrenom = prenom
}
