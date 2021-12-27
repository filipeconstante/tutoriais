package br.com.filipeconstante.tutoriais.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ModelObjectTest {

	public static final String MODEL_OBJECT_EMAIL = "teste@filipeconstante.com.br";
	public static final String MODEL_OBJECT_NOME = "Filipe Constante";
	public static final Boolean MODEL_OBJECT_STATUS = true;
	public static final Integer MODEL_OBJECT_ID = 1;
	
	@Test
	void constructorTest() {
		ModelObject object = new ModelObject(MODEL_OBJECT_ID, MODEL_OBJECT_NOME, MODEL_OBJECT_EMAIL, MODEL_OBJECT_STATUS);
		assertEquals(MODEL_OBJECT_ID, object.getId());
		assertEquals(MODEL_OBJECT_EMAIL, object.getEmail());
		assertEquals(MODEL_OBJECT_NOME, object.getNome());
		assertEquals(MODEL_OBJECT_STATUS, object.getStatus());
	}

	@Test
	void constructorTestWithoutArguments() {
		ModelObject object = getModelObject();
		assertEquals(MODEL_OBJECT_ID, object.getId());
		assertEquals(MODEL_OBJECT_EMAIL, object.getEmail());
		assertEquals(MODEL_OBJECT_NOME, object.getNome());
		assertEquals(MODEL_OBJECT_STATUS, object.getStatus());
	}
	
	public static ModelObject getModelObject() {
		ModelObject teste = new ModelObject();
		teste.setId(MODEL_OBJECT_ID);
		teste.setEmail(MODEL_OBJECT_EMAIL);
		teste.setNome(MODEL_OBJECT_NOME);
		teste.setStatus(MODEL_OBJECT_STATUS);
		return teste;
	}
	
}
