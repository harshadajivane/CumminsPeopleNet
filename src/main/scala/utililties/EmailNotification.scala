package utililties
import java.io.UnsupportedEncodingException
import java.util.Properties
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.PasswordAuthentication
import javax.mail.Authenticator
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.AddressException
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import scala.annotation.Annotation

object EmailNotification {

	val host = "smtp.gmail.com"
			val username = "cumminspeoplenet@gmail.com"
			val password = "Harshada@4550"

			def sendEmail (userEmailAddress : String,  userName : String,  subject : String,  msgBody : String) =

		{

		var props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);

		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");


		var session = Session.getInstance(props, getPasswordAuthentication(username, password))

				try {
					var msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress("cumminspeoplenet@gmail.com", "PeopleNet"));
					msg.addRecipient(Message.RecipientType.TO,

							new InternetAddress(userEmailAddress, userName ));

					msg.setSubject(subject);			
					msg.setText(msgBody);

					Transport.send(msg);

				} catch {
				case e : AddressException => println(e.getMessage());
				} 
		}

	def getPasswordAuthentication(uname:String, psw:String):Authenticator =
		{

		new Authenticator(){

			override def getPasswordAuthentication():PasswordAuthentication = {

					new PasswordAuthentication(uname, psw)
			}}
		}

}