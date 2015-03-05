package resources

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import scala.beans.BeanProperty

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
class Locations {

	@BeanProperty
	var location_pin_code = 0

	@BeanProperty
	var location_name = ""

	@BeanProperty
	var location_city = ""

	@BeanProperty
	var location_state = ""

	@BeanProperty
	var location_country = ""
	
	@BeanProperty
	var latittude = ""
	
	@BeanProperty
	var longitude = ""
	
}