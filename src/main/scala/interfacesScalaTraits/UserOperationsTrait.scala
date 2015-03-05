package interfacesScalaTraits

import resources.User

trait UserOperationsTrait {
  
  def createUser (user : User) : Unit
  def getUser(user_id : Int): User
  def deleteUser (user_id : Int) : Unit
  def updateUser (user : User) : Unit
   
  
}