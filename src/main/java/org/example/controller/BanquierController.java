package org.example.controller;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.model.Ecran;

import java.io.IOException;


/**
 * Graphical controls and command line controls offering a choice of ticket vending machines.
 */
public class BanquierController extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Page d'acceuil");

        Ecran ecran = new Ecran();

        TabPane root = new TabPane();

        Tab tabOfPageAcceuil = new Tab();
        tabOfPageAcceuil.setText("Page d'acceuil");

        //FXML loaders
        FXMLLoader fxmlLoaderPageAcceuil = new FXMLLoader(getClass().getResource("/view/PageAcceuil.fxml"));
        FXMLLoader fxmlLoaderSelectionnerUnCompte = new FXMLLoader(getClass().getResource("/view/SelectionnerUnComte.fxml"));
        FXMLLoader fxmlLoaderChoixDeLOperationAEffectuer = new FXMLLoader(getClass().getResource("/view/ChoixDeLOperationAEffectuer.fxml"));
        FXMLLoader fxmlLoaderEffectuerUnDepot = new FXMLLoader(getClass().getResource("/view/EffectuerUnDepot.fxml"));
        FXMLLoader fxmlLoaderEffectuerUnRetrait = new FXMLLoader(getClass().getResource("/view/EffectuerUnRetrait.fxml"));
        FXMLLoader fxmlLoaderAide = new FXMLLoader(getClass().getResource("/view/Aide.fxml"));

        //Roots et Scenes
        Parent rootSelectionnerUnCompte = fxmlLoaderSelectionnerUnCompte.load();
        Scene sceneSelectionnerUnCompte = new Scene(rootSelectionnerUnCompte, 600, 450);

        Parent rootChoixDeLOperationAEffectuer = fxmlLoaderChoixDeLOperationAEffectuer.load();
        Scene sceneChoixDeLOperationAEffectuer = new Scene(rootChoixDeLOperationAEffectuer, 600, 450);

        Parent rootSEffectuerUnDepot = fxmlLoaderEffectuerUnDepot.load();
        Scene sceneEffectuerUnDepot= new Scene(rootSEffectuerUnDepot, 600, 450);

        Parent rootEffectuerUnRetrait = fxmlLoaderEffectuerUnRetrait.load();
        Scene sceneEffectuerUnRetrait = new Scene(rootEffectuerUnRetrait, 600, 450);

        Parent rootAide = fxmlLoaderAide.load();
        Scene sceneAide = new Scene(rootAide, 600, 450);

        //Ouverture de la fenetre SelectionnerUnCompte à partir de PageAcceuil
        fxmlLoaderPageAcceuil.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> param) {
                PageAcceuilGraphicalController pageAcceuilGraphicalController = new PageAcceuilGraphicalController(ecran);
                ChangeListener<Boolean> ouvertureDeLaPageSelectionnerUnCompte = new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        Stage selectionnerUnCompteStage = new Stage();
                        selectionnerUnCompteStage.setTitle("Selectionner un compte");
                        selectionnerUnCompteStage.setScene(sceneSelectionnerUnCompte);
                        selectionnerUnCompteStage.show();
                    }
                };
                pageAcceuilGraphicalController.ouvrirLaPageSelectionnerUnCompteSurDemande(ouvertureDeLaPageSelectionnerUnCompte);
                return pageAcceuilGraphicalController;
            }
        });

        //Ouverture de la fenetre ChoixDeLOperationAEffectuer à partir de la page SelectionnerUnCompte
        fxmlLoaderSelectionnerUnCompte.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> param) {
                SelectionnerUnCompteGraphicalController selectionnerUnCompteGraphicalController = new SelectionnerUnCompteGraphicalController(ecran);
                ChangeListener<Boolean> ouvertureDeLaPageChoixDeLOperationAEffectuer = new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        Stage choixDeLOperationAEffectuerStage = new Stage();
                        choixDeLOperationAEffectuerStage.setTitle("Operation à effectuer");
                        choixDeLOperationAEffectuerStage.setScene(sceneChoixDeLOperationAEffectuer);
                        choixDeLOperationAEffectuerStage.show();
                    }
                };
                selectionnerUnCompteGraphicalController.ouvrirLaPageChoixDeLOperationAEffectuerSurDemande(ouvertureDeLaPageChoixDeLOperationAEffectuer);
                return selectionnerUnCompteGraphicalController;
            }
        });



        //PageAcceuil
        tabOfPageAcceuil.setContent(fxmlLoaderPageAcceuil.load());
        root.getTabs().add(tabOfPageAcceuil);

        Scene scene = new Scene(root, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
