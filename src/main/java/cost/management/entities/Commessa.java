package cost.management.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commessa database table.
 * 
 */
@Entity
@NamedQuery(name="Commessa.findAll", query="SELECT c FROM Commessa c")
public class Commessa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codice;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine_commessa")
	private Date dataFineCommessa;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio_commessa")
	private Date dataInizioCommessa;

	@Column(name="descrizione_commessa")
	private String descrizioneCommessa;

	private float importo;

	@Column(name="tipologia_commessa")
	private String tipologiaCommessa;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to DipendenteCommessa
	@OneToMany(mappedBy="commessa")
	private List<DipendenteCommessa> dipendenteCommesse;

	public Commessa() {
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Date getDataFineCommessa() {
		return this.dataFineCommessa;
	}

	public void setDataFineCommessa(Date dataFineCommessa) {
		this.dataFineCommessa = dataFineCommessa;
	}

	public Date getDataInizioCommessa() {
		return this.dataInizioCommessa;
	}

	public void setDataInizioCommessa(Date dataInizioCommessa) {
		this.dataInizioCommessa = dataInizioCommessa;
	}

	public String getDescrizioneCommessa() {
		return this.descrizioneCommessa;
	}

	public void setDescrizioneCommessa(String descrizioneCommessa) {
		this.descrizioneCommessa = descrizioneCommessa;
	}

	public float getImporto() {
		return this.importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public String getTipologiaCommessa() {
		return this.tipologiaCommessa;
	}

	public void setTipologiaCommessa(String tipologiaCommessa) {
		this.tipologiaCommessa = tipologiaCommessa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DipendenteCommessa> getDipendenteCommessas() {
		return this.dipendenteCommesse;
	}

	public void setDipendenteCommesse(List<DipendenteCommessa> dipendenteCommesse) {
		this.dipendenteCommesse = dipendenteCommesse;
	}

	public DipendenteCommessa addDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommessas().add(dipendenteCommessa);
		dipendenteCommessa.setCommessa(this);

		return dipendenteCommessa;
	}

	public DipendenteCommessa removeDipendenteCommessa(DipendenteCommessa dipendenteCommessa) {
		getDipendenteCommessas().remove(dipendenteCommessa);
		dipendenteCommessa.setCommessa(null);

		return dipendenteCommessa;
	}

}