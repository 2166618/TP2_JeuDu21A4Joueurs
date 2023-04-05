package model.paquetDeCarte;

//Chris Tania Meyou Lemanga et Veronique Tavares
import model.utilitaires.Util;

/**
 * Classe représentant un jeu de cartes.
 */
public class Paquet {

    // Paquet de carte
    public Carte[] paquet;
    public int nombreDeCartePigees;

    /**
     * Constructeur
     */
    public Paquet(boolean melange) {
        //Initialisation des cartes du paquet.
        this.paquet = new Carte[Rang.values().length * Couleur.values.length];
        this.nombreDeCartePigees = 0;
        remplirPaquet();

        if (melange){
            melanger();
        }
    }

    public void remplirPaquet() {

        Carte carte;
        int indicePaquet = 0;
        for (Couleur couleur : Couleur.values) {
            for (Rang rang : Rang.values()) {
                carte = new Carte(rang, couleur);
                this.paquet[indicePaquet++] = carte;
            }
        }
    }

    /**
     * Echange deux cartes d'un paquet.
     *
     * @param i: L'indice de la première carte à échanger.
     * @param j  : L'indice de la seconde carte à échanger.
     */
    public void permuter(int i, int j) {
        Carte temp;
        temp = this.paquet[i];
        this.paquet[i] = this.paquet[j];
        this.paquet[j] = temp;
    }

    /**
     * Mélange les cartes du paquet.
     */
    public void melanger() {
        for (int i = 0; i < this.paquet.length; i++) {
            permuter(i, Util.obtenirUnNombreAleatoireEntreMinEtMax(0,i));
        }
    }

    /**
     * Piger une carte dans le paquet.
     * @return Retourne la carte suivante du paquet ou null si toutes les cartes ont été pigées.
     */
    public Carte piger() {
        Carte pige = null;
        if (this.nombreDeCartePigees < this.paquet.length) {
            pige = this.paquet[this.nombreDeCartePigees++];
        }
        return pige;
    }

}
