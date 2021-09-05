package cost.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Azienda;
import cost.management.entities.Dipendente;
import cost.management.service.AziendaService;

@RestController
@RequestMapping("/api")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class AzeindaController {
	
	@Autowired
	private AziendaService aziendaServ;
	 
	@GetMapping("/aziende")
	public List<Azienda> findAllAziende(){
		
		return aziendaServ.findAllAziende();
		
	}
	
	@GetMapping("/aziende/{id}")
	public Azienda findAziendaById(@PathVariable String id) {
		System.out.println("RETURN AZIENDA OBJ BACK END :" + aziendaServ.findAziendaById(id));
		return aziendaServ.findAziendaById(id);
		
	}
	

}
