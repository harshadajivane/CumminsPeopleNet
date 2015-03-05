package resources

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.joda.time.DateTime;
import scala.beans.BeanProperty

class UserEntry {

	@BeanProperty
	var userEntry_user_id = ""
  
	@BeanProperty
	var userEntry_user_name = ""
	  
	@BeanProperty
	var userEntry_from_residence_location : Boolean = _
	  
	@BeanProperty
	var userEntry_from_workplace_location : Boolean = _
	
	@BeanProperty
	var userEntry_reporting_pincode = 0
	
	@BeanProperty
	var userEntry_user_Comments = ""
	  
	@BeanProperty
	var userEntry_traffic_congestion : Boolean = _
	
	@BeanProperty
	var userEntry_visible_incident : Boolean = _

	@BeanProperty
	var userEntry_many_potholes : Boolean = _

}