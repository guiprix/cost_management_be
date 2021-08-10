package cost.management;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cost.management.entities.Azienda;
import cost.management.entities.Dipendente;
import cost.management.service.DipendenteService;

@SpringBootApplication
public class CostManagementApplication  implements CommandLineRunner{
	
	@Autowired
	private DipendenteService dipService;

	public static void main(String[] args) {
		SpringApplication.run(CostManagementApplication.class, args);
		
	
		
	
		
	}

	@Override
	public void run(String... args) throws Exception {
		/* TODO Auto-generated method stub
		Azienda azienda = new Azienda("nike");
		Date newDate = new Date();
		Dipendente dip= new Dipendente();
		 dip = new Dipendente("vndgdu74b21","3510642728","vendrame",
				newDate, "via mecenate","guido.vndr@gmail.com","udine","guido",
				"via delle betulle",azienda);
		Dipendente dip1 = new Dipendente();
		 dip1 = new Dipendente("audgdu74b21","77128163","rossi",
				newDate, "via malaga","vittorio@gmail.com","milano","vittorio",
				"via delle acacie",azienda);
		
		dipService.addDipendente(dip);
		dipService.addDipendente(dip1);
		*/
	}

}
