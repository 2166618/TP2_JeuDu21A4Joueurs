package model.utilitaires;

import java.util.Random;
import java.util.Scanner;

public class Util {

    /**
     * Retourne une valeur aléatoire entre min et max inclusivement.
     * @param min valeur minimum à retourner
     * @param max valeur minimale à retourner
     * @return une valeur aléatoire entre min et max inclusivement
     */
    public static int obtenirUnNombreAleatoireEntreMinEtMax(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min +1) + min;
    }

    //Methodes d'entrées au clavier

    /**
     * Méthode permettant de lire une chaine de caractère à la console
     * @param question : Reçoit en paramètre la question à demander à l'utilisateur
     * @return Une chaîne de caractère contenant la réponse entrée au clavier par l'utilisateur (String)
     */
    public static String lireUneString(String question) {
        String reponse;
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        reponse = scanner.nextLine();    //lecture de la reponse
        return reponse;
    }

    /**
     * Saisit au clavier une réponse de l'usager au clavier. La réponse doit être un caractère présent dans la
     * chaine valeursValides sans tenir compte de la casse. Dans le cas contraire, la question est reposée indéfiniment.
     * 	L'usager peut entrer plusieurs lettres, mais seule la première lettre entrée est considérée.
     * @param question la question posé à l'usager (exemple : "Votre sexe (m ou f)?
     * @param valeursValides la chaine qui comprend les lettres acceptés (exemple : "mf")
     * @return le caractère saisi au clavier par l'usager. Ce caractère est nécessairement parmis ceux
     * 	envoyés dans valeursValides. On retourne dans tous les cas la minuscule correspondante.
     */
    public static char saisirDesCaracteres(String question, String valeursValides){
        char c = ' ';
        String reponse ;
        boolean estInvalide = true;

        valeursValides = valeursValides.toLowerCase();
        do{
            reponse = lireUneString(question);
            if (reponse.length() > 0){
                c = Character.toLowerCase(reponse.charAt(0));
                estInvalide = valeursValides.indexOf(c) == -1;
            }
            if (estInvalide){
                System.out.println("Entrez un choix valide (" + valeursValides + ")");
            }
        }while (estInvalide);
        return c;
    }
}
