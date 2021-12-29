package br.com.filipeconstante.tutoriais.mongodb.connection;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.filipeconstante.tutoriais.mongodb.model.User;

public class Connection<T> {

	private static final String MONGODB_HOST = "localhost";
	private static final String MONGODB_USER = "admin";
	private static final String MONGODB_PASS = "admin";
	private static final String MONGODB_SOURCE = "admin";
	private static final Integer MONGODB_PORT = 27017;

	private MongoClient mongo;
	private MongoDatabase database;
	private static Connection instance;

	private Connection() {
		MongoCredential credential = MongoCredential.createCredential(MONGODB_USER, MONGODB_SOURCE,
				MONGODB_PASS.toCharArray());

		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		mongo = new MongoClient(new ServerAddress(MONGODB_HOST, MONGODB_PORT), credential,
				MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
		
		database = mongo.getDatabase(MONGODB_SOURCE);
	}
	
	public MongoCollection<T> getMongoCollection(Class clazz){
		return getInstance().getDatabase().getCollection(clazz.getName(), clazz);
	}

	public MongoClient getMongo() {
		return mongo;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
			return instance;
		} else {
			return instance;
		}
	}

}
