package implementation

import java.util.ArrayList
import utililties.MongoConnection
import resources.Locations
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Criteria

class LocationOperations {

	val mongo = MongoConnection.getConnection

	def registerLocation(pin : Int, name : String, city : String, state : String, country : String, latittude : String, longitude : String)
	{
		var location = new Locations

				location.setLocation_pin_code(pin)
				location.setLocation_city(city)
				location.setLocation_state(state)
				location.setLocation_country(country)
				location.setLatittude(latittude)
				location.setLongitude(longitude)

				mongo.insert(location)    
	}
	
	def getLocation(pin : Int) : Locations =
	{
	  
	  var query = new Query()
	  
	  var location = new Locations()
	  
	  query.addCriteria(Criteria.where("location_pin_code").is(pin))	  
	  
	  location = mongo.findOne(query, classOf[Locations])
	  
	  return location
	  
	}
	
	
	
}