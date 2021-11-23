package tn.esprit.recapapp.model;

public class Country {

    private int id;
    private String nom;
    private int image;

    public Country() {
    }

    public Country(int id, String nom, int image) {
        this.id = id;
        this.nom = nom;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", image=" + image +
                '}';
    }
}
