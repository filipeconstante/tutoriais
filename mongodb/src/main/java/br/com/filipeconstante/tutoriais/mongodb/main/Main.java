package br.com.filipeconstante.tutoriais.mongodb.main;

import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoCollection;

import br.com.filipeconstante.tutoriais.mongodb.connection.Connection;
import br.com.filipeconstante.tutoriais.mongodb.model.User;

public class Main {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		Connection conn = Connection.getInstance();
		MongoCollection<User> userCollection = conn.getMongoCollection(User.class);

		User u = new User();
		u.setName("Filipe");
		u.setEmployee(true);
		u.setRole("CEO");

		userCollection.insertOne(u);
		
		User userData = userCollection.find(eq("name", "Filipe")).first();
		userData.setRole("Presidente");
		userCollection.replaceOne(eq("_id", userData.getId()), userData);
		
		userData = userCollection.find(eq("name", "Filipe")).first();
		System.out.println(userData.getId());
		
		userCollection.deleteOne(eq("_id", userData.getId()));

		conn.getMongo().close();
	}
	
}
