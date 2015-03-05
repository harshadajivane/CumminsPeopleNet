package implementation

import resources.UserEntry
import utililties.MongoConnection

class UserEntryOperations {
    
  val mongo = MongoConnection.getConnection  
  
  def postUserEntry(userEntry : UserEntry)
  {
	 mongo.insert(userEntry)
  }

}