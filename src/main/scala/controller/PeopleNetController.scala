package controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid
import resources.User
import org.springframework.http.ResponseEntity
import utililties.GeneralPurposeUtils
import implementation.UserOperations
import org.springframework.http.HttpStatus
import utililties.DBLoader
import utililties.EmailNotification
import implementation.LocationOperations
import utililties.MongoConnection

@RestController
@Configuration
@EnableAutoConfiguration
@ComponentScan
@RequestMapping(Array("/api/v1/*"))
class PeopleNetController {

 var userOps = new UserOperations()
 
 var locOps = new LocationOperations
 
 var dbLoader = new DBLoader
 
 val mongo = MongoConnection.getConnection
  
  
@RequestMapping(value = Array("/newuser"), method = Array(RequestMethod.POST))
@ResponseBody 
	def createUser(@RequestBody user:User): ResponseEntity [User] = { 

    var user_id = GeneralPurposeUtils.getRandomInteger
	user.setUser_id(user_id)
	
	userOps.createUser(user)
	
	
	 var res_location = locOps.getLocation(user.getUser_residence_pincode)
    var work_location = locOps.getLocation(user.getUser_workplace_pincode)
	
	
	var msgBody = "Hi " + user.getUser_name + "\n\nYou have been successfully registered on PeopleNet with following locations: \n\n" + 
					"Residence Location: " + res_location.getLocation_name + "\nWorkplace Location: " + work_location.getLocation_name +
					"\n\nThank you for going social with PeopleNet ! \n\nPeopleNet, Pune"

					      
	EmailNotification.sendEmail(user.getUser_email, user.getUser_name, "Welcome to Cummins PeopleNet !", msgBody )
	
		
	return new ResponseEntity [User] (user, HttpStatus.CREATED)
	
	}

 
  
@RequestMapping(value = Array("/dbload"), method = Array(RequestMethod.POST))
@ResponseBody 
	def databaseLoad(): String = { 
   
		dbLoader.loadLocations
			
	return	"Database loaded !"
 }

 
 @RequestMapping(value = Array("/servercheck"), method = Array(RequestMethod.POST))
@ResponseBody 
	def servercheck(): String = { 

    return "Server is running fine !"
	
	}
 
 

}