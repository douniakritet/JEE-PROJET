package Model;

import java.util.Date;

public class Tableau {
    private int idO;
    private int idArtiste;
    private String titre;
    private Date anneeCreation;
    private String description;
    private Double prix;
    private String image;

    public Tableau(int idO, int idArtiste, String titre, Date anneeCreation, String description, Double prix, String image) {
        this.idO = idO;
        this.idArtiste = idArtiste;
        this.titre = titre;
        this.anneeCreation = anneeCreation;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }

    // Getters and Setters
    public int getIdO() {
        return idO;
    }

    public void setIdO(int idO) {
        this.idO = idO;
    }

    public int getIdArtiste() {
        return idArtiste;
    }

    public void setIdArtiste(int idArtiste) {
        this.idArtiste = idArtiste;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getAnneeCreation() {
        return anneeCreation;
    }

    public void setAnneeCreation(Date anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
