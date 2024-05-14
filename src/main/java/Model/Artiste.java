package Model;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Artiste {

	private int id;
	private String nom;
	private String nationalite;
	private Date dateNaissance;
	
	public Artiste(int idAr,String nom, String nationalite, java.util.Date dateNaissance2) {
		super();
		this.id = idAr;
		this.nom = nom;
		this.nationalite = nationalite;
		this.dateNaissance = (Date) dateNaissance2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
}

