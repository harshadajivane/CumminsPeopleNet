package implementation

import interfacesScalaTraits.UserOperationsTrait
import resources.User
import utililties.MongoConnection
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Criteria
import resources.User
import org.springframework.data.mongodb.core.query.Update

class UserOperations extends UserOperationsTrait {

	val mongo = MongoConnection.getConnection

/***************************************************************************************************************/
	
	def createUser (user : User) : Unit = 
		{
			mongo.insert(user)
		}
	
/***************************************************************************************************************/
	
	def getUser(user_id : Int): User = 
		{

			var query = new Query()
			var user = new User ()

			query.addCriteria(Criteria.where("user_id").is(user_id))

			user = mongo.findOne(query, classOf[User],"Users")

			return user
		}
	
/***************************************************************************************************************/

	def deleteUser (user_id : Int) : Unit= 
		{
			var query = new Query()
			var user = new User ()

			query.addCriteria(Criteria.where("user_id").is(user_id))

			mongo.remove(query, classOf[User],"Users")
		}
	
	
/***************************************************************************************************************/
	
	def updateUser (user : User) : Unit = 
		{
			var query = new Query()
			var update = new Update()
			
			update.set("user_residence_pincode", user.getUser_residence_pincode)
			update.set("user_workplace_pincode", user.getUser_workplace_pincode)
			update.set("user_city", user.getUser_city)
			update.set("user_phone", user.getUser_phone)
			update.set("user_email", user.getUser_email)
	
			query.addCriteria(Criteria.where("user_id").is(user.getUser_id))
			
			mongo.updateFirst(query, update, classOf[User], "Users")
		}




}