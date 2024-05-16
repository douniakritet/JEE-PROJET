package Model;

import java.sql.Date;

public class Transaction {

	  private int idT;
	  private int idOeuvre;
	  private int idExposition;
	  private String nomClient;
	  private Date dateVente;
	  private String statut;
	public Transaction(int idT, int idOeuvre, int idExposition, String nomClient, java.util.Date dateVente2, String statut) {
		super();
		this.idT = idT;
		this.idOeuvre = idOeuvre;
		this.idExposition = idExposition;
		this.nomClient = nomClient;
		this.dateVente = (Date) dateVente2;
		this.statut = statut;
	}
	public Transaction(int idOeuvre, int idExposition, String nomClient, java.util.Date dateVente2, String statut) {
		super();
		this.idOeuvre = idOeuvre;
		this.idExposition = idExposition;
		this.nomClient = nomClient;
		this.dateVente = (Date) dateVente2;
		this.statut = statut;
	}
	public int getIdT() {
		return idT;
	}
	public void setIdT(int idT) {
		this.idT = idT;
	}
	public int getIdOeuvre() {
		return idOeuvre;
	}
	public void setIdOeuvre(int idOeuvre) {
		this.idOeuvre = idOeuvre;
	}
	public int getIdExposition() {
		return idExposition;
	}
	public void setIdExposition(int idExposition) {
		this.idExposition = idExposition;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Date getDateVente() {
		return dateVente;
	}
	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	  
	  
	  
}
