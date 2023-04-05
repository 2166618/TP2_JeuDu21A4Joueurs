//Chris Tania Meyou Lemanga et Veronique Tavares
package model.paquetDeCarte;

/**
 * Classe représentant une carte de jeu.
 */
public class Carte {

    //Le rang de la carte.
    public Rang rang;
    //La couleur de la carte.
    public Couleur couleur;

    /**
     * Constructeur de carte.
     * @param rang : Le rang de la carte.
     * @param couleur : La couleur de la carte.
     */
    public Carte(Rang rang, Couleur couleur) {
        this.rang = rang;
        this.couleur = couleur;
    }

    /**
     *
     * @return le rang de la carte.
     */
    public Rang getRang() {
        return this.rang;
    }

    /**
     *
     * @return la couleur de la carte
     */
    public Couleur getCouleur() {
        return this.couleur;
    }

    @Override
    public String toString() {
        return this.rang + " " + this.couleur;
    }
}
