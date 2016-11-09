package ar.edu.unlam.tallerweb1.pruebas;

import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.SpringTest;
import tallerweb.keeprunning.modelo.Persona;

public class PersonaTest extends SpringTest{
	/*esto es una Herencia*/
	@Test
	@Transactional @Rollback /*@Transactional para que los test corran en un contexto transaccional,y @Rollback SPRING borra los datos de los tests*/
	public void testPersona(){
	Persona seba = new Persona();
	seba.setNombre("Sebastian");
	Session s = getSession();
	s.save(seba);
	
	Assertions.assertThat(s.get(Persona.class, seba.getId()));
	}

}
