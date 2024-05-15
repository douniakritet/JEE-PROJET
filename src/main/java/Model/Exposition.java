package Model;

import java.sql.Date;

public class Exposition {
	private int idE;
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;
	

	public Exposition(int idE,String nom, java.util.Date dateDebut2, java.util.Date dateFin2, String lieu) {
		super();
		this.idE = idE;
		this.nom = nom;
		this.dateDebut = (Date) dateDebut2;
		this.dateFin = (Date) dateFin2;
		this.lieu = lieu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdE() {
		return idE;
	}
	public void setIdE(int idE) {
		this.idE = idE;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	


}
