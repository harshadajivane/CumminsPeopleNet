package implementation

import utililties.MongoConnection
import org.springframework.data.mongodb.core.query.Query
import resources.User
import org.springframework.data.mongodb.core.query.Criteria
import scala.collection.JavaConversions._
import java.util.ArrayList
import resources.Locations


class BroadcasterImpl {

	val mongo = MongoConnection.getConnection

	def broadcast(pin : Int)
	{
		var email = ""
		var phone = ""
		var userQuery = new Query()
		var locationQuery = new Query()

		userQuery.addCriteria(Criteria.where("user_workplace_pincode").is(pin).orOperator(Criteria.where("user_residence_pincode").is(pin)))
		var users = mongo.find(userQuery, classOf[User],"Users")


		locationQuery.addCriteria(Criteria.where("location_pin_code").is(pin))
		var location =	mongo.findOne(userQuery, classOf[Locations],"Locations")

		var size = users.size()
		var iterator = 0

		for (iterator <- 0 to size-1 )
		{
			var internalObject = users.get(iterator)

					var name =  internalObject.getUser_name
					var email = internalObject.getUser_email
					var phone = internalObject.getUser_phone
					var location_name = location.getLocation_name

					sendEmail(users.get(iterator).getUser_email, name, location_name )
				//	sendSMS(users.get(iterator).getUser_phone)
		}

	}


	def sendEmail (email : String, name:String, location_name:String)
	{

	}

	def sendSMS (email : Int)
	{

	}








}