package control;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.EntityStudente;
import entity.EntityDocente;
import entity.EntityGenitore;
import entity.EntityMateria;
import entity.EntityValutazione;

public class prova {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int control=0;
		
		EntityStudente s=new EntityStudente();
		s.setMatricola(1);
		Date datanascita= new Date(2001-01-20);
		
		s.setNome("Vincenzo Flavio");
		s.setCognome("Carlo");
		s.setCodiceFiscale("VFCTI675DHGB56IK");
		s.setDataNascita(datanascita);
		s.setComuneResidenza("Lignano Sabbiadoro");
		s.setEmail("vincenzof.carlo@labuonascuola.it");
		s.setNumeroCellulare("3275693956");
		s.setUsername("vincenzofl");
		s.setPassword("dHSn119LtT%!");
		
		control= s.scriviSuDB(1);
		
		System.out.println(control);
		
		
		
		//Prova genitore
		EntityGenitore gen =new EntityGenitore();
		gen.setUsername("mammadivinci");
		
		gen.setPassword("FlowerPower68");
		gen.setNome("Rosa");
		gen.setCognome("Bruno Carlo");
		gen.setCodiceFiscale("RBCAI675DHGB56IK");
		gen.setDataNascita(datanascita);
		gen.setComuneResidenza("Giugliano in Campania");
		gen.setEmail("rosa.bruno@alice.it");
		gen.setNumeroCellulare("3275643926");
		gen.setStudente(s);
		
		control= gen.scriviSuDB("mammadivinci");
		System.out.println(control);
		
		EntityGenitore gen2 =new EntityGenitore("mammadivinci");
		gen2.caricaStudente("mammadivinci");
		
		
		EntityStudente s2 =new EntityStudente(gen2.getStudente().getMatricola());
		
		
		System.out.println(s);
		System.out.println(gen);
		System.out.println(gen2);
		System.out.println(s2);
		
		
		//Prova docente
		EntityDocente d= new EntityDocente("ersiliav");
		ArrayList<EntityMateria> m= new ArrayList<EntityMateria>();
		
		d.setPassword("Kierkegaard34");
		d.setNome("Ersilia");
		d.setCognome("Viola");
		d.setCodiceFiscale("ERVLI675DHGB56IK");
		d.setDataNascita(datanascita);
		d.setComuneResidenza("Castellammare di Stabia");
		d.setEmail("ersv@alice.it");
		d.setNumeroCellulare("3453628465");
		
		EntityMateria materia = new EntityMateria(1);
		m.add(materia);
		EntityMateria materia2 = new EntityMateria(7);
		m.add(materia2);
		EntityMateria materia3 = new EntityMateria(10);
		m.add(materia3);
		
		d.setMaterie(m);
		
		control=d.scriviSuDB("ersiliav");
		System.out.println(control);
		
		control=d.aggiornaMaterieSuDB("ersiliav");
		System.out.println(control);
		
		System.out.println(d);
		
		Date datavalutazione = Date.valueOf("2023-06-11");
		
		
		//Prova aggiungivoto
		EntityValutazione v= new EntityValutazione();
		
		v.setIdvalutazioni(3);
		v.setData(datanascita);
		v.setVoto((float) 8.5);
		v.setMateria(materia3);
		v.setStudente(s);
		
		control=v.scriviSuDB(3);
		System.out.println(control);
		
		
		
		Controller.aggiungiVoto(d.getUsername(), s.getMatricola(), materia2.getIdmaterie(), datavalutazione, 7);
		
		
	}
	
	

}
