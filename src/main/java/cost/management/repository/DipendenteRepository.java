package cost.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cost.management.entities.Dipendente;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, String> {

	public Dipendente findDipendenteByCodiceFiscale(String codiceFiscale);
	
}
