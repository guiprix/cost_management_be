package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dipendente database table.
 * 
 */
@Entity
@NamedQuery(name="Dipendente.findAll", query="SELECT d FROM Dipendente d")
public class Dipendente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="codice_fiscale")
	@Pattern(regexp="^[a-zA-Z0-9]{16}$")
	private String codiceFiscale;
	
	@NotBlank(message="Cellulare e' obbligatorio")
	private String cellulare;
	
	@NotBlank(message="Nome e' obbligatorio")
	private String nome;
	
	@NotBlank(message="Cognome e' obbligatorio")
	private String cognome;

	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita", nullable=false)
	private Date dataNascita;

	private String domicilio;
	
	@NotBlank
	@Email(message="La email deve essere un'email valida")
	private String email;

	@NotBlank(message="luogo di nascita e' obbligatorio")
	@Column(name="luogo_nascita")
	private String luogoNascita;

	
	@NotBlank(message="residenza e' obbligatorio")
	private String residenza;

	//bi-directional many-to-one association to Contratto
	@OneToMany(mappedBy="dipendente")
	private List<Contratto> contratti;

	//bi-directional many-to-one association to Azienda
	@ManyToOne
	private Azienda azienda;

	//bi-directional many-to-one association to DipendenteCommessa
	//@OneToMany(mappedBy="dipendente")
	//private List<DipendenteCommessa> dipendenteCommesse;

	
	public Dipendente() {
	}
	
	public Dipendente(String codiceFiscale, String cellulare, String cognome, Date dataNascita, String domicilio,
			String email, String luogoNascita, String nome, String residenza, Azienda azienda) {
		
		this.codiceFiscale = codiceFiscale;
		this.cellulare = cellulare;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.domicilio = domicilio;
		this.email = email;
		this.luogoNascita = luogoNascita;
		this.nome = nome;
		this.residenza = residenza;
		this.azienda = azienda;
		
	}


	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCellulare() {
		return this.cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLuogoNascita() {
		return this.luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResidenza() {
		return this.residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public List<Contratto> getContratti() {
		return this.contratti;
	}

	public void setContratti(List<Contratto> contratti) {
		this.contratti = contratti;
	}

	public Contratto addContratto(Contratto contratto) {
		getContratti().add(contratto);
		contratto.setDipendente(this);

		return contratto;
	}



	public Contratto removeContratto(Contratto contratto) {
		getContratti().remove(contratto);
		contratto.setDipendente(null);

		return contratto;
	}
	
	
	public Azienda getAzienda() {
		return this.azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}
	
	/*
	public List<DipendenteCommessa> getDipendenteCommessas() {
		return this.dipendenteCommesse;
	}

	public void setDipendenteCommessas(List<DipendenteCommessa> dipendenteCommessas) {
		this.dipendenteCommesse = dipendenteCommessas;
	}

	public DipendenteCommessa addDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommessas().add(dipendenteCommessa);
		dipendenteCommessa.setDipendente(this);

		return dipendenteCommessa;
	}

	public DipendenteCommessa removeDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommessas().remove(dipendenteCommessa);
		dipendenteCommessa.setDipendente(null);

		return dipendenteCommessa;
	}
	*/

	@Override
	public String toString() {
		return "Dipendente [codiceFiscale=" + codiceFiscale + ", cellulare=" + cellulare + ", cognome=" + cognome
				+ ", dataNascita=" + dataNascita + ", domicilio=" + domicilio + ", email=" + email + ", luogoNascita="
				+ luogoNascita + ", nome=" + nome + ", residenza=" + residenza + "]";
	}
	
	

}