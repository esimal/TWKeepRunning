package ar.edu.unlam.tallerweb1.pruebas;

import org.junit.Assert;
import org.junit.Test;

import tallerweb.keeprunning.modelopersona.Cerradura;

public class CerraduraTest {

	@Test
	public void ingresarClaveCorrectaDeberiaAbrirLaCerradura() {
		Cerradura cerradura = new Cerradura(1234);
		boolean abrio = cerradura.abrir(1234);
		
		Assert.assertTrue(abrio);
	}
	
	@Test
	public void ingresarClaveIncorrectaNoDeberiaAbrirLaCerradura() {
		Cerradura cerradura = new Cerradura(1234);
		boolean abrio = cerradura.abrir(123);
		
		Assert.assertFalse(abrio);
	}

	@Test
	public void alIngresarClaveIncorrectaMasDeTresVecesDeberiaBloquearLaCerradura() {
		Cerradura cerradura = new Cerradura(1234);
		cerradura.abrir(4321);
		cerradura.abrir(7654);
		cerradura.abrir(1222);
		Assert.assertTrue(cerradura.estaBloqueada());
	}	
}
