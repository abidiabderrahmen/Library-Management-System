import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Auteur {
    private String nom;
    private String nationalite;

    public Auteur() {
    }

    public Auteur(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
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

    @Override
    public String toString() {
        return "Auteur [nom=" + nom + ", nationalite=" + nationalite + "]";
    }
}

class BibliothequeException extends Exception {
    public BibliothequeException(String message) {
        super(message);
    }
}

abstract class Document {
    public abstract void methodeAbstraite();
}

final class Livre extends Document {
    private String titre;
    private Auteur auteur;
    private int anneePublication;
    private int nombrePages;

    public Livre() {
    }

    public Livre(String titre, Auteur auteur, int anneePublication, int nombrePages) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.nombrePages = nombrePages;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

   
    public String toString() {
        return "Livre [titre=" + titre + ", auteur=" + auteur + ", anneePublication=" + anneePublication
                + ", nombrePages=" + nombrePages + "]";
    }

    
    public void methodeAbstraite() {
    }
}

class Bibliotheque {
    private List<Livre> livres;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) throws BibliothequeException {
        if (livre.getAnneePublication() > LocalDate.now().getYear()) {
            throw new BibliothequeException("Année de publication future non autorisée");
        }

        if (livre.getAuteur() == null || livre.getAuteur().getNom().isEmpty()) {
            throw new BibliothequeException("Un livre doit avoir un auteur");
        }

        livres.add(livre);
    }

    public void afficherLivres() {
        for (Livre livre : livres) {
            System.out.println(livre);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Auteur auteur1 = new Auteur("John Doe", "USA");

            Livre livre1 = new Livre("Titre du Livre", auteur1, 2022, 200);
            Bibliotheque bibliotheque = new Bibliotheque();
            bibliotheque.ajouterLivre(livre1);

            bibliotheque.afficherLivres();
        } catch (BibliothequeException e) {
            System.out.println("Erreur dans la bibliothèque : " + e.getMessage());
        }
    }
}
