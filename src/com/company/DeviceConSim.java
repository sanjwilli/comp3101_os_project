package com.company;

import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;

/*import javax.swing.*;
import java.awt.*;*/
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Sanjay
 */
public class DeviceConSim implements Initializable {

    @FXML
    private Rectangle cpu;

    @FXML
    private Rectangle sys_bus;

    @FXML
    private Rectangle monitor_driver;

    @FXML
    private Rectangle keyboard_driver;

    @FXML
    private Rectangle usb_driver;

    @FXML
    private Rectangle disk_driver;

    @FXML
    private Rectangle _driver;

    @FXML
    private Rectangle video_ctr;

    @FXML
    private Rectangle keyboard_ctr;

    @FXML
    private Rectangle usb_ctr;

    @FXML
    private Rectangle disk_ctr;

    @FXML
    private Line monitor_cnt_line;

    @Override
    public void initialize(URL location, ResourceBundle resources){

    }

    private void pause(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ScaleTransition pulse(Rectangle r) {

        ScaleTransition trans = new ScaleTransition();
        trans.setByX(0.1);
        trans.setByY(0.1);
        trans.setDuration(Duration.millis(1000));
        trans.setCycleCount(6);
        trans.setAutoReverse(true);
        trans.setNode(r);
        return trans;
        //trans.play();
    }

    private  void sequence() {

    }

    private ScaleTransition pulse(Line l) {

        ScaleTransition trans = new ScaleTransition();
        trans.setByX(0.1);
        trans.setByY(0.1);
        trans.setDuration(Duration.millis(1000));
        trans.setCycleCount(500);
        trans.setAutoReverse(true);
        trans.setNode(l);
        trans.play();
        return trans;
    }

    /**
     *
     * This method will simulate
     * Device Controller I/O system
     */
    @FXML
    private void simulateButtonPushed(ActionEvent event) {
        /*pulse(monitor_driver);
        //pulse(monitor_cnt_line);
        pulse(sys_bus);
        //pause(6000);
        pulse(sys_bus);
        //pause(8000);
        //pulse(cpu);
        //pause(12000);
        //pulse(video_ctr);*/

        SequentialTransition seq = new SequentialTransition(pulse(monitor_driver), pulse(sys_bus), pulse(cpu), pulse(sys_bus), pulse(video_ctr));
        seq.play();
    }

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

    /**
     *
     * This method will simulate
     * Device Controller I/O system
     */
    public void simulateMonitorPushed(javafx.scene.input.MouseEvent mouseEvent) {
        SequentialTransition seq = new SequentialTransition(pulse(monitor_driver), pulse(sys_bus), pulse(cpu), pulse(sys_bus), pulse(video_ctr));
        seq.play();
    }

    public void simulateKeyboardPushed(javafx.scene.input.MouseEvent mouseEvent) {
        SequentialTransition seq = new SequentialTransition(pulse(keyboard_driver), pulse(sys_bus), pulse(cpu), pulse(sys_bus), pulse(keyboard_ctr));
        seq.play();
    }

    public void simulateUSBPushed(javafx.scene.input.MouseEvent mouseEvent) {
        SequentialTransition seq = new SequentialTransition(pulse(usb_driver), pulse(sys_bus), pulse(cpu), pulse(sys_bus), pulse(usb_ctr));
        seq.play();
    }

    public void simulateDiskPushed(javafx.scene.input.MouseEvent mouseEvent) {
        SequentialTransition seq = new SequentialTransition(pulse(disk_driver), pulse(sys_bus), pulse(cpu), pulse(sys_bus), pulse(disk_ctr));
        seq.play();
    }
}
