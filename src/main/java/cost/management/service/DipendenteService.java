package cost.management.service;

import java.util.List;

import cost.management.entities.Dipendente;

public interface DipendenteService {

	Dipendente addDipendente(Dipendente dipendente);

	List<Dipendente> findAllDipendenti();
}
