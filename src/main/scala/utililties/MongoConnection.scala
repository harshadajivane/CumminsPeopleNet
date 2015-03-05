package utililties
import java.net.UnknownHostException

import com.mongodb.MongoClient

import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.MongoClientURI

object MongoConnection {

	def getConnection() : MongoTemplate =
		{
			var uri : MongoClientURI =null;
			var mongoclient : MongoClient = null;
			var mongoConnection : MongoTemplate =null;
	try {
		uri = new MongoClientURI("mongodb://harshada:india@ds045031.mongolab.com:45031/peoplenet");
		mongoclient = new MongoClient(uri);
		mongoConnection = new MongoTemplate(mongoclient,"peoplenet");
	} catch {
	case e :UnknownHostException => e.printStackTrace()
	} 
	return mongoConnection;
		}

}


