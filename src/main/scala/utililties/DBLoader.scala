package utililties
import scala.collection.mutable.HashMap
import resources.Locations


class DBLoader {
  
  val mongo = MongoConnection.getConnection
  
  
  
  
  def loadLocations ()
  {
    
	  var locationObject = new Locations()
	    
	  var locations : HashMap[String,Int] = new HashMap[String,Int]
	  
	 locations.put("Akurdi", 411035)
	 locations.put("Anandnagar", 411051)
	 locations.put("Hadapsar", 411013)
	 locations.put("Katraj", 411046)
	 locations.put("Kothrud", 411038)
	 locations.put("Model Colony", 411016)
	 locations.put("Pimpri Chinchwad", 411044)
	 locations.put("Swargate", 411042)
	 locations.put("Warje Malwadi", 411052)
	 locations.put("Shivajinagar", 411005)
	 locations.put("Dhankawadi", 411046)
	 
	 var size = locations.size
	 
	 var traverser = locations.iterator
	 
	  while(traverser.hasNext)
	  {
		  var inLoc = traverser.next
		  
		  locationObject.setLocation_pin_code(inLoc._2)
		  locationObject.setLocation_name(inLoc._1)
		  locationObject.setLocation_city("Pune")
		  locationObject.setLocation_state("Maharshtra")
		  locationObject.setLocation_country("India")
		  
		  mongo.insert(locationObject)
	  }
    
    
  }
  

}