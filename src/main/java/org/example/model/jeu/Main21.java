//Chris Tania Meyou Lemanga et Veronique Tavares
package model.jeu;

import model.paquetDeCarte.Carte;
import model.paquetDeCarte.Paquet;

import java.util.ArrayList;
import java.util.List;

public class Main21 {

    //attributs
    public List<Carte> mainDe21;
    private Paquet paquet;   //on lie la main d'un paquet


    public Main21(Paquet paquet, int nombreDeCartes) {
        this.paquet = paquet;
        this.mainDe21 = new ArrayList<Carte>();
        for (int i = 0; i < nombreDeCartes; i++){
            this.ajouterUneCarteALaMain();
        }
    }


    /**
     * Piger, c'est prendre une carte dans le paquet et l'ajouter dans sa main.
     * On ajoute une carte seulement s'il reste des cartes dans le paquet. Sinon, on ne fait rien.
     * @return la carte pigée dans le paquet et ajoutée dans la main.
     */
    public Carte ajouterUneCarteALaMain() {
        Carte cartePige = paquet.piger();
        if (cartePige != null){
            mainDe21.add(cartePige);
        }
        return cartePige;
    }

    /**
     * obtenir
     * @return le nombre de cartes dans le paquet
     */
    public int nombreDeCartes(){
        return (int) mainDe21.stream().count();
    }


    public int valeurDeLaMainDe21() {
        int valeur = 0;
        for (Carte c: mainDe21) {
            valeur += getValeurDeLaCarte21(c);
        }
        return valeur;
    }

    public boolean main21GagnanteOuPerdante() {
        return main21Perdante() || main21Gagnante();
    }

    public boolean main21Gagnante() {
        return valeurDeLaMainDe21() == 21;
    }

    public boolean main21Perdante() {
        return valeurDeLaMainDe21() > 21;
    }

    public String MainDe21(){
        String str = "";
        int position = 1;
        for (Carte c: mainDe21) {
            str += position++ + " - " + c + "\n";
        }
        return str;
    }

    @Override
    public String toString() {
        int valeurDuJeu = valeurDeLaMainDe21();
        String strResultat = main21Perdante() ? " 21 est dépassé. " : 21 - valeurDuJeu + " pour dépasser.";
        return MainDe21() + " valeur du jeu 21 : " + valeurDuJeu + " -> " + strResultat + "\n";
    }

    public int getValeurDeLaCarte21(Carte carte) {
        int valeur;
        switch (carte.getRang())
        {
            case AS:
                valeur = 11;
                break;
            case DEUX:
                valeur = 2;
                break;
            case TROIS:
                valeur = 3;
                break;
            case QUATRE:
                valeur = 4;
                break;
            case CINQ:
                valeur = 5;
                break;
            case SIX:
                valeur = 6;
                break;
            case SEPT:
                valeur = 7;
                break;
            case HUIT:
                valeur = 8;
                break;
            case NEUF:
                valeur = 9;
                break;
            default:
                valeur = 10;
                break;
        }
        return valeur;
    }


}
