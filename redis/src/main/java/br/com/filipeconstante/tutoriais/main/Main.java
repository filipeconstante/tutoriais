package br.com.filipeconstante.tutoriais.main;

import br.com.filipeconstante.tutoriais.model.ModelObject;
import br.com.filipeconstante.tutoriais.redis.GenericRedis;

public class Main {
	
	private static final String REDIS_MODEL_OBJECT = "redisModelObject#";
	
	public static void main(String[] args) {
		
		ModelObject teste = new ModelObject();
		teste.setId(1);
		teste.setEmail("teste@filipeconstante.com.br");
		teste.setNome("Filipe Constante");
		teste.setStatus(true);
		
		GenericRedis.set(REDIS_MODEL_OBJECT, teste);
		
		ModelObject obj2 = (ModelObject) GenericRedis.get(REDIS_MODEL_OBJECT);
		
		System.out.println("Peguei o teste: " + obj2.getEmail());
		
	}

}
