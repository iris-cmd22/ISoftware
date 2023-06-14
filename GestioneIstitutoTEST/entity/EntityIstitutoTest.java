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
		
		EntityIstituto singleton = EntityIstituto.getInstance();
		Date datanascita = new Date(1980-06-13);
		
		//Test Case 1: Tutti input validi
		int control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);
		
		int expected=1;
		assertEquals(expected, control);
		
		//Test Case 2: Nome string he inizia con una minuscola
		control=singleton.creaGenitore("carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);
		
		expected=-2;
		assertEquals(expected, control);
		
		//Test Case 3: Nome vuoto
		control=singleton.creaGenitore("", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);
		
		expected=-2;
		assertEquals(expected, control);
		
		//Test Case 4: Nome stringa di lunghezza >100
		control=singleton.creaGenitore("Carla Carla Carla Carla Carla Carla Carla Carla Carla Carla Carla Carla  Carla Carla Carla Carla Carla Carla Carla Carla Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);
		
		expected=-2;
		assertEquals(expected, control);
		
		//Test Case 5: Cognome stringa di caratteri che inizia con una minuscola
		control=singleton.creaGenitore("Carla", "viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);
		
		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 6:Cognome stringa vuota
		control=singleton.creaGenitore("Carla", "", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);
		
		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 7:Cognome stringa di lunghezza >100
		control=singleton.creaGenitore("Carla", "Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 8: Codice Fiscale stringa alfanumerica di lunghezza != 16
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z910","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-5;
		assertEquals(expected, control);
		
		//Test Case 9: Codice Fiscale composta da simboli non validi
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CR%L&80/5&F8$9Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-5;
		assertEquals(expected, control);
		
		//Test Case 10: Comune di residenza stringa vuota
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-6;
		assertEquals(expected, control);
		
		//Test Case 11: Comune di Residenza stringa di lunghezza > 50
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli Napoli Napoli Napoli Napoli Napoli Napoli Napoli Napoli Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-6;
		assertEquals(expected, control);
		
		//Test Case 12: Comune di Residenza stringa composta da simboli non validi
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","N@p0li" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-6;
		assertEquals(expected, control);
		
		//Test Case 13: Email stringa in cui non è presente il simbolo @
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80.gmail.com", "327673435", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-7;
		assertEquals(expected, control);
		
		//Test Case 14: Numero Cellulare Stringa vuota 
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 15: Numero Cellulare stringa di lunghezza > 15
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "+39 33920182038402810 ", "c.viola13", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 16: Username stringa vuota
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 17: Username stringa di lunghezza > 20
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "carla.viola13278738193037", "IstitutoCarla80", 1);
		System.out.println(control);

		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 18: Password stringa vuota
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "", 1);
		System.out.println(control);

		expected=-4;
		assertEquals(expected, control);
		
		//Test Case 19:Password stringa di lunghezza  > 50
		control=singleton.creaGenitore("Carla", "Viola", datanascita, "CRLVLI80H53F839Z","Napoli" , "carlaviola80@gmail.com", "327673435", "c.viola13", "IstitutoCarlaIstitutoCarlaIstitutoCarlaIstitutoCarlaIstitutoCarla", 1);
		System.out.println(control);

		expected=-4;
		assertEquals(expected, control);
		
		
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


