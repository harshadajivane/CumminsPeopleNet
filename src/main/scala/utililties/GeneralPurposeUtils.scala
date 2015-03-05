package utililties

import scala.util.Random
import org.joda.time.DateTime

object GeneralPurposeUtils {

/******************************************************************************************************************/  

	def getRandomInteger () : Int = { 

		var random : Random = new Random()
		var generatedValue = 0
		var dayOfYear = DateTime.now().dayOfYear().get()
		var year = DateTime.now().year().get()
		var minuteOfDay = DateTime.now().minuteOfDay().get()
		var secondOfDay = DateTime.now().secondOfDay().get()

			generatedValue = random.nextInt(Integer.MAX_VALUE) + 1 + year + dayOfYear + minuteOfDay + secondOfDay 

	return generatedValue
	}

/******************************************************************************************************************/



}