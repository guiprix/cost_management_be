package cost.management.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import cost.management.entities.Azienda;
import cost.management.entities.Dipendente;
import cost.management.repository.AziendaRepository;
import cost.management.repository.DipendenteRepository;

@Service
public class DipendenteServiceImpl implements DipendenteService {

	Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	// inietta il repository nel service
	@Autowired
	private DipendenteRepository dipRepo;

	@Autowired
	private AziendaRepository aziendaRepo;

	// aggiungi dipendente
	@Override
	public Dipendente addDipendente(Dipendente dipendente, int id) {
		String message = "Dipendente NON INSERITO!!";
		Azienda azienda = aziendaRepo.findById(id).get();
		dipendente.setAzienda(azienda);

		try {
			return dipRepo.save(dipendente);
		} catch (IllegalArgumentException ex) {
			log.info(message);
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Dipendente updateDipendente(Dipendente dipendente, String codiceFiscale, int aziendaId) {

		Dipendente oldDipendente = null;

		Optional<Dipendente> oldDipendenteTemp = dipRepo.findById(codiceFiscale);

		if (oldDipendenteTemp.isPresent()) {
			oldDipendente = oldDipendenteTemp.get();

			//oldDipendente.setCodiceFiscale(dipendente.getCodiceFiscale());
			oldDipendente.setAzienda(dipendente.getAzienda());
			oldDipendente.setNome(dipendente.getNome());
			oldDipendente.setCognome(dipendente.getCognome());
			oldDipendente.setCellulare(dipendente.getCellulare());
			oldDipendente.setDataNascita(dipendente.getDataNascita());
			oldDipendente.setEmail(dipendente.getEmail());
			oldDipendente.setResidenza(dipendente.getResidenza());
			oldDipendente.setLuogoNascita(dipendente.getLuogoNascita());
			System.out.println("*********** updated dipdendente " + oldDipendente + "**********************");
			return addDipendente(oldDipendente,aziendaId);

		} else {
			log.info("*******Dipendente non trovato!!*****");
		}
		return null;

	}
	
	

	@Override
	public Optional<Dipendente> findDipendenteByCodiceFiscale(String codiceFiscale) {

		return dipRepo.findById(codiceFiscale);
	}

	@Override
	public List<Dipendente> findAllDipendenti() {
		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		listaDipendenti = dipRepo.findAll();
		
		//get age from data di nascita
		for(Dipendente dipendente : listaDipendenti) {
			System.out.println( "DATA NASCITA CONTROLLER :" +dipendente.getDataNascita());
			
			LocalDate start = new java.sql.Date(dipendente.getDataNascita().getTime()).toLocalDate();
			LocalDate end = LocalDate.now(); 
			long years = ChronoUnit.YEARS.between(start, end);
			dipendente.setAge(years);
		}

		if (!listaDipendenti.isEmpty()) {
			log.info("La lista di dipendenti e' piena");
			return listaDipendenti;
		} else {
			log.info("la lista dei dipendenti e' vuota");
		}
		return null;
	}



	@Override
	public void deleteDipendente(String codiceFiscale) {

		Optional<Dipendente> dipendenteToDelete = dipRepo.findById(codiceFiscale);

		if (dipendenteToDelete.isPresent()) {
			log.info("***Dipendente trovato!***");

		}
		try {
			dipRepo.deleteById(codiceFiscale);
			log.info("***Dipendente cancellato!***");

		} catch (IllegalArgumentException ex) {
			log.info("***Dipendente NON cancellato!***");
			ex.printStackTrace();
		}
	}

}
