package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.sql.Date;

public class EntityIstitutoTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("SETUP eseguito ad ogni caso di test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TEARDOWN eseguito ad ogni caso di test");
	}

	@Test
	public void testCreaDocente() { 
			
		EntityIstituto singleton = EntityIstituto.getInstance();
	
		ArrayList<Integer> materie= new ArrayList<Integer>();
		Date datanascita = new Date(1975-11-30);
		int control=singleton.creaDocente("Luigi", "Bianchi", datanascita , "BNCLGU75S30H703D", "Salerno", "luigibianchi75@gmail.com", "338763435", "l.bianchi30","BianchiPass3@" , materie);
		System.out.println(control);
		
		int expected=0;
		
		
		
	}

	@Test
	public void testCreaStudente() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreaGenitore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListaValutazioni() {
		fail("Not yet implemented");
	}

	@Test
	public void testAggiungiVoto() {
		fail("Not yet implemented");
	}

}
