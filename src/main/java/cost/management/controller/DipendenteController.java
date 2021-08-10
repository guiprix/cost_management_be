package cost.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Dipendente;
import cost.management.service.DipendenteService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DipendenteController {
	
	@Autowired
	private DipendenteService dipService;
	
	@PostMapping("/dipendenti")
	public Dipendente addDipendente(@RequestBody Dipendente dipendente) {
		/*
		Dipendente newDip = new Dipendente();
		newDip.setCodiceFiscale(dipendente.getCodiceFiscale());
		newDip.setNome(dipendente.getNome());
		newDip.setCognome(dipendente.getCognome());
		newDip.setCellulare(dipendente.getCellulare());
		newDip.setDataNascita(dipendente.getDataNascita());
		newDip.setEmail(dipendente.getEmail());
		newDip.setResidenza(dipendente.getResidenza());
		newDip.setLuogoNascita(dipendente.getLuogoNascita());
		newDip.setAzienda(dipendente.getAzienda());
		
		System.out.println("########### " +newDip +" ################");
		*/
		return dipService.addDipendente(dipendente);
		
	}
	
	@GetMapping("/dipendenti")
	public List<Dipendente> findAllDipendenti(){
		
		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		listaDipendenti = dipService.findAllDipendenti();
		return listaDipendenti;
	}
	
	
}
