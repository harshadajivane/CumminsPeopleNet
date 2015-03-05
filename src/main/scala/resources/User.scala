package resources

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.joda.time.DateTime;
import scala.beans.BeanProperty


//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
class User {
    
@BeanProperty 
var user_id : Int = _

@BeanProperty
var user_name = ""

@BeanProperty
var user_email = ""

@BeanProperty
var user_phone = ""

@BeanProperty
var user_city = ""
  
@BeanProperty
var user_residence_pincode = 0
  
@BeanProperty
var user_residence_latittude = 0

@BeanProperty
var user_residence_longitude = 0

@BeanProperty
var user_workplace_pincode = 0
  
@BeanProperty
var user_workplace_latittude = 0

@BeanProperty
var user__longitude = 0

@BeanProperty
var user_registration_date : DateTime = _

}

   