package cost.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cost.management.entities.Dipendente;
import cost.management.repository.DipendenteRepository;

@Service
public class DipendenteServiceImpl implements DipendenteService {
	
	//inietta il repository nel service
	@Autowired
	private DipendenteRepository dipRepo;
	
	//aggiungi dipendente
	@Override
	public Dipendente addDipendente(Dipendente dipendente) {
			
		return dipRepo.save(dipendente);
	}
	

}
