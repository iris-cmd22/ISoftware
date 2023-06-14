package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;


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
		materie.add(1);
		
		LocalDate localDate = LocalDate.of(1975,11,30);
		 java.sql.Date datanascita = java.sql.Date.valueOf(localDate);
		int control=singleton.creaDocente("Luigi", "Bianchi", datanascita , "BNCLGU75S30H703D", "Salerno", "luigibianchi75@gmail.com", "+338763435", "l.bianchi30","BianchiPass3@" , materie);
		System.out.println(control);
		
		int expected=1;
		
		assertEquals(expected, control);		
		
		
	}

	
	@Test
	public void testCreaStudente() {
		EntityIstituto singleton = EntityIstituto.getInstance();
		
		
		
		LocalDate localDate = LocalDate.of(2001,10,20);
		 java.sql.Date datanascita = java.sql.Date.valueOf(localDate);
		
		int control=singleton.creaStudente("Mario", "Rossi", datanascita , "RSSMRA01R20F839P", "Napoli", "mariorossi2001@gmail.com", "338765432", "m.rossi20","ScuolaMario20@" , 1);
		
		
	

		System.out.println(control);
		
		int expected=1;
		
		assertEquals(expected, control);	
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
	 EntityIstituto singleton = EntityIstituto.getInstance();
	    
	   // Preparazione dei dati di test
	
	 LocalDate localDate = LocalDate.of(2023, 06, 10);
	 java.sql.Date datavalutazione = java.sql.Date.valueOf(localDate);

	   float votoValido = (float)7.5;
	   
	   // Esecuzione del metodo con un voto valido
	   int control = singleton.aggiungiVoto("l.bianchi30", 1, 1,datavalutazione, votoValido);
	   System.out.println(control);
	   int expected=1;
	   
	   assertEquals(expected, control); // Verifica che il risultato sia conforme alle aspettative
	    
	   
	   float votoMaggiore = 11;
	   
	   // Esecuzione del metodo con un voto valido
	    control = singleton.aggiungiVoto("l.bianchi30", 1, 1,datavalutazione, votoMaggiore);
	   System.out.println(control);
	   expected=-2;
	   
	   assertEquals(expected, control); // Verifica che il risultato sia conforme alle aspettative
	    
	   
	   
	   float votoMinore = (float) 0.5;
	   
	   // Esecuzione del metodo con un voto valido
	    control = singleton.aggiungiVoto("l.bianchi30", 1, 1,datavalutazione, votoMinore);
	   System.out.println(control);
	   expected=-2;
	   
	   assertEquals(expected, control); // Verifica che il risultato sia conforme alle aspettative
	    
	   
	}
	}


