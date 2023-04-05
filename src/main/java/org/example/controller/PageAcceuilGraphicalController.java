package org.example.controller;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.model.Ecran;

/**
 * Graphical controls of a transit ticket vending machine offering to change transit route.
 */
public class PageAcceuilGraphicalController {

    private Ecran ecran;

    @FXML
    private Button boutonAide;
    @FXML
    private Button boutonSuivant;

    public PageAcceuilGraphicalController(Ecran ecran) {
        this.ecran = ecran;
    }

    public void ouvrirLaPageSelectionnerUnCompteSurDemande(ChangeListener<Boolean> ouvertureDeLaPageSelectionnerUnCompte) {
        ecran.gererLOuvertureDeLaPageSelectionnerUnComte(ouvertureDeLaPageSelectionnerUnCompte);
    }

    @FXML
    void passerALaPageSelectionnerUnCompte(ActionEvent event) {
        ecran.setBoutonSuivantClique(true);
    }

}
