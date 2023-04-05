//Chris Tania Meyou Lemanga et Veronique Tavares
package model.paquetDeCarte;

/**
 * Couleur de la carte
 */
public class Couleur {
    public static final Couleur PIQUE = new Couleur("PIQUE", "♠");
    public static final Couleur TREFLE = new Couleur("TREFLE", "♣");
    public static final Couleur CARREAU = new Couleur("CARREAU", "♦");
    public static final Couleur COEUR = new Couleur("COEUR", "♥");

    public static final Couleur[] values = {PIQUE,TREFLE,CARREAU,COEUR};

    public String nom;
    public String symbole;

    public Couleur(String nom, String symbole) {
        this.nom = nom;
        this.symbole = symbole;
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public String getSymbole() {
        return symbole;
    }

    private void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    @Override
    public String toString() {
        return this.symbole;
    }
}
