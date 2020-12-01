package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroWindowController {

    /**
     *
     * This method changes the from the main
     * scene to the Introduction scene.
     */
    public void goBackButtonPushed(ActionEvent event) throws IOException {

        Parent introParent = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene introScene = new Scene(introParent);

        //Getting the stage information
        Stage introStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        introStage.setScene(introScene);
        introStage.show();
    }
}
