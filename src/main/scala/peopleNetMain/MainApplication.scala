package peopleNetMain

import org.springframework.boot.SpringApplication
import controller.PeopleNetController
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

@Configuration
@ComponentScan
@EnableAutoConfiguration
object MainApplication {

	def main(args: Array[String]) {
		SpringApplication.run(classOf [PeopleNetController])
	}
}

