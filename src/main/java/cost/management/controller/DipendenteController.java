package cost.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Dipendente addDipendente(Dipendente dipendente) {
		
		return dipService.addDipendente(dipendente);
		
	}
	
	
}
