package cost.management.service;

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
import cost.management.entities.Dipendente;
import cost.management.repository.DipendenteRepository;

@Service
public class DipendenteServiceImpl implements DipendenteService {

	Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

	// inietta il repository nel service
	@Autowired
	private DipendenteRepository dipRepo;

	// aggiungi dipendente
	@Override
	public Dipendente addDipendente(Dipendente dipendente) {
		String message = "Dipendente NON INSERITO!!";

		try {
			return dipRepo.save(dipendente);
			
		} catch (IllegalArgumentException ex) {

			log.info(message);
			ex.printStackTrace();
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
		
		if(!listaDipendenti.isEmpty()) {
			log.info("La lista di dipendenti e' piena");
			
			return listaDipendenti;
		}else {
			log.info("la lista dei dipendenti e' vuota");
		}

		return null;

	}

	@Override
	public Dipendente updateDipendente(Dipendente dipendente, String codiceFiscale) {

		Dipendente oldDipendente = null;

		Optional<Dipendente> oldDipendenteTemp = dipRepo.findById(codiceFiscale);

		if (oldDipendenteTemp.isPresent()) {
			oldDipendente = oldDipendenteTemp.get();

			//oldDipendente.setCodiceFiscale(codiceFiscale); puo' cambiare?
			oldDipendente.setAzienda(dipendente.getAzienda());
			oldDipendente.setNome(dipendente.getNome());
			oldDipendente.setCognome(dipendente.getCognome());
			oldDipendente.setCellulare(dipendente.getCellulare());
			oldDipendente.setDataNascita(dipendente.getDataNascita());
			oldDipendente.setEmail(dipendente.getEmail());
			oldDipendente.setResidenza(dipendente.getResidenza());
			oldDipendente.setLuogoNascita(dipendente.getLuogoNascita());
			System.out.println("*********** updated dipdendente " + oldDipendente + "**********************");
			return addDipendente(oldDipendente);

		} else {
			log.info("*******Dipendente non trovato!!*****");
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
