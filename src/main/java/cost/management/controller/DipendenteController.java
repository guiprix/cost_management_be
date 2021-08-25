package cost.management.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cost.management.entities.Dipendente;
import cost.management.service.DipendenteService;

@RestController
@RequestMapping("/api")
//to cross origin to a REACT project use "http://localhost:3000"
@CrossOrigin(origins = "http://localhost:4200")
public class DipendenteController {

	@Autowired
	private DipendenteService dipService;

	// inserici un dipendente nel db
	@PostMapping("/dipendenti")
	public Dipendente addDipendente(@Valid @RequestBody Dipendente dipendente) {
		/*
		 * Dipendente newDip = new Dipendente();
		 * newDip.setCodiceFiscale(dipendente.getCodiceFiscale());
		 * newDip.setNome(dipendente.getNome());
		 * newDip.setCognome(dipendente.getCognome());
		 * newDip.setCellulare(dipendente.getCellulare());
		 * newDip.setDataNascita(dipendente.getDataNascita());
		 * newDip.setEmail(dipendente.getEmail());
		 * newDip.setResidenza(dipendente.getResidenza());
		 * newDip.setLuogoNascita(dipendente.getLuogoNascita());
		 * newDip.setAzienda(dipendente.getAzienda());
		 * 
		 * System.out.println("########### " +newDip +" ################");
		 */
		return dipService.addDipendente(dipendente);

	}

	// trova tutti i dipendenti
	@GetMapping("/dipendenti")
	public List<Dipendente> findAllDipendenti() {

		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		listaDipendenti = dipService.findAllDipendenti();
		return listaDipendenti;
	}

	// find dipendente by codice fiscale
	@GetMapping("/dipendenti/{codiceFiscale}")
	public Optional<Dipendente> findDipendenteByCodiceFiscale(@PathVariable String codiceFiscale) {

		return dipService.findDipendenteByCodiceFiscale(codiceFiscale);
	}

	// update un dipendente
	@PutMapping("/dipendenti/{codiceFiscale}")
	public Dipendente updateDipendente(@RequestBody Dipendente dipendente, @PathVariable String codiceFiscale) {

		return dipService.updateDipendente(dipendente, codiceFiscale);
	}

	// delete un dipendente
	@DeleteMapping("/dipendenti/{codiceFiscale}")
	public Map<String, Boolean> deleteDipendente(@PathVariable String codiceFiscale) {

		Map<String, Boolean> deletion = new HashMap<>();

		dipService.deleteDipendente(codiceFiscale);
		deletion.put("Dipendente Deleted", Boolean.TRUE);
		return deletion;
	}

}
