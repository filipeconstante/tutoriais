package br.com.filipeconstante.tutoriais.redis;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.filipeconstante.tutoriais.model.ModelObject;
import br.com.filipeconstante.tutoriais.model.ModelObjectTest;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class GenericRedisTest {
	
	private static final String REDIS_MODEL_OBJECT = "test#redisModelObject#";

	@Test
	void genericRedisTest() {
		GenericRedis.set(REDIS_MODEL_OBJECT, ModelObjectTest.getModelObject());
		ModelObject objectTest = (ModelObject) GenericRedis.get(REDIS_MODEL_OBJECT);
		assertEquals(ModelObjectTest.MODEL_OBJECT_EMAIL, objectTest.getEmail());
		assertEquals(ModelObjectTest.MODEL_OBJECT_NOME, objectTest.getNome());
		assertEquals(ModelObjectTest.MODEL_OBJECT_STATUS, objectTest.getStatus());
		assertEquals(ModelObjectTest.MODEL_OBJECT_ID, objectTest.getId());
	}
	
}
