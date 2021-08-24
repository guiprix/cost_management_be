package cost.management.service;

import java.util.ArrayList;
import java.util.List;
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
	
	
	//@Autowired
	//private Validator validator;
	
	
	//inietta il repository nel service
	@Autowired
	private DipendenteRepository dipRepo;
	
	//aggiungi dipendente
	@Override
	public Dipendente addDipendente(Dipendente dipendente) {
		String message  = "Dipendente NON INSERITO/AGGIORNATO!!";
		/*
      Set<ConstraintViolation<Dipendente>> violations = validator.validate(dipendente);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Dipendente> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }*/
			
				
				return dipRepo.save(dipendente);
				
	}
	
	@Override
	public Dipendente findDipendenteByCodiceFiscale(String codiceFiscale) {
		
		return dipRepo.findDipendenteByCodiceFiscale(codiceFiscale);
	}
	
	
	@Override
	public List<Dipendente> findAllDipendenti(){
		List<Dipendente> listaDipendenti = new ArrayList<Dipendente>();
		
		listaDipendenti = dipRepo.findAll();
		
		return listaDipendenti;
		
	}
	
	
	@Override 
	public Dipendente updateDipendente(Dipendente dipendente, String codiceFiscale) {
		
		Dipendente oldDipendente = dipRepo.findDipendenteByCodiceFiscale(codiceFiscale);
		
		//oldDipendente.setCodiceFiscale(dipendente.getCodiceFiscale());
		oldDipendente.setAzienda(dipendente.getAzienda());
		oldDipendente.setNome(dipendente.getNome());
		oldDipendente.setCognome(dipendente.getCognome());
		oldDipendente.setCellulare(dipendente.getCellulare());
		oldDipendente.setDataNascita(dipendente.getDataNascita());
		oldDipendente.setEmail(dipendente.getEmail());
		oldDipendente.setResidenza(dipendente.getResidenza());
		oldDipendente.setLuogoNascita(dipendente.getLuogoNascita());
		
		System.out.println("*********** updated dipdendente "+ oldDipendente +"**********************");
		return addDipendente(oldDipendente);
		
	}

	
	

}
