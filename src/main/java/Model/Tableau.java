package Model;

import java.util.Date;

public class Tableau {
    private int idO;
    private int idArtiste;
    private String titre;
    private Date aneeCreation;
    private String description;
    private double prix;
    private String image;

    public Tableau(int idO, int idArtiste, String titre, Date aneeCreation, String description, Double prix, String image) {
        this.idO = idO;
        this.idArtiste = idArtiste;
        this.titre = titre;
        this.aneeCreation = aneeCreation;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }
    public Tableau(int idArtiste, String titre, Date aneeCreation, String description, Double prix, String image) {
        this.idArtiste = idArtiste;
        this.titre = titre;
        this.aneeCreation = aneeCreation;
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

    public Date getAneeCreation() {
        return aneeCreation;
    }

    public void setAneeCreation(Date aneeCreation) {
        this.aneeCreation = aneeCreation;
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
