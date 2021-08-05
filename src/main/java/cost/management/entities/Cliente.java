package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="partita_iva")
	private String partitaIva;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	@Column(name="codice_interscambio")
	private String codiceInterscambio;

	private String pec;

	@Column(name="regione_sociale")
	private String regioneSociale;

	@Column(name="sede_legale")
	private String sedeLegale;

	//bi-directional many-to-one association to Commessa
	@OneToMany(mappedBy="cliente")
	private List<Commessa> commesse;

	public Cliente() {
	}

	public String getPartitaIva() {
		return this.partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCodiceInterscambio() {
		return this.codiceInterscambio;
	}

	public void setCodiceInterscambio(String codiceInterscambio) {
		this.codiceInterscambio = codiceInterscambio;
	}

	public String getPec() {
		return this.pec;
	}

	public void setPec(String pec) {
		this.pec = pec;
	}

	public String getRegioneSociale() {
		return this.regioneSociale;
	}

	public void setRegioneSociale(String regioneSociale) {
		this.regioneSociale = regioneSociale;
	}

	public String getSedeLegale() {
		return this.sedeLegale;
	}

	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}

	public List<Commessa> getCommesse() {
		return this.commesse;
	}

	public void setCommessas(List<Commessa> commesse) {
		this.commesse = commesse;
	}

	public Commessa addCommessa(Commessa commessa) {
		getCommesse().add(commessa);
		commessa.setCliente(this);

		return commessa;
	}

	public Cliente(String partitaIva, String codiceFiscale, String codiceInterscambio, String pec,
			String regioneSociale, String sedeLegale) {
		super();
		this.partitaIva = partitaIva;
		this.codiceFiscale = codiceFiscale;
		this.codiceInterscambio = codiceInterscambio;
		this.pec = pec;
		this.regioneSociale = regioneSociale;
		this.sedeLegale = sedeLegale;
	}

	public Commessa removeCommessa(Commessa commessa) {
		getCommesse().remove(commessa);
		commessa.setCliente(null);

		return commessa;
	}

}