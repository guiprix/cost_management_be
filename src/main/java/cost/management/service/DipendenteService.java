package cost.management.service;

import java.util.List;
import java.util.Optional;

import cost.management.entities.Dipendente;

public interface DipendenteService {

	Dipendente addDipendente(Dipendente dipendente);

	List<Dipendente> findAllDipendenti();

	Dipendente updateDipendente(Dipendente dipendente, String codiceFiscale);

	Optional<Dipendente> findDipendenteByCodiceFiscale(String codiceFiscale);

	void deleteDipendente(String codiceFiscale);
}
