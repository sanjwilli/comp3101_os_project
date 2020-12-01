package com.company;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sanjay
 */
public class MainWindowController {


    /**
     *
     * This method changes the from the main
     * scene to the Introduction scene.
     */
    public void introductionSceneButtonPushed(ActionEvent event) throws IOException {

        Parent introParent = FXMLLoader.load(getClass().getResource("IntroWindow.fxml"));
        Scene introScene = new Scene(introParent);

        //Getting the stage information
        Stage introStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        introStage.setScene(introScene);
        introStage.show();
    }

    /**
     *
     * This method changes the from the main
     * scene to the Device controller scene.
     */
    public void deviceControllerSceneButtonPushed(ActionEvent event) throws IOException {

        Parent deviceControlParent = FXMLLoader.load(getClass().getResource("DeviceConSim.fxml"));
        Scene deviceControlScene = new Scene(deviceControlParent);

        //Getting the stage information
        Stage deviceControlStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        deviceControlStage.setScene(deviceControlScene);
        deviceControlStage.show();
    }

    /**
     *
     * This method changes the from the main
     * scene to the DMA simulation
     */
    public void DMAControllerSceneButtonPushed(ActionEvent event) throws IOException {

        DMA dma = new DMA();
        dma.setVisible(true);
        dma.setDefaultCloseOperation(Graphics.EXIT_ON_CLOSE);
    }

    /**
     *
     * This method open a panel to
     * display the Interrupt Simulation
     */
    public void InterruptControllerSceneButtonPushed(ActionEvent event) throws IOException {
        Interrupt interrupt = new Interrupt();
        interrupt.paint(null);
    }
}
