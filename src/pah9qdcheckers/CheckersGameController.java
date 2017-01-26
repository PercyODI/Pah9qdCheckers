/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pah9qdcheckers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author pah9qd
 */
public class CheckersGameController implements Initializable {
    
    Checkerboard checkerboard;
    
    @FXML
    VBox vBox;
    
    @FXML
    AnchorPane anchorPane;
    
    @FXML
    MenuBar menuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void ready(Scene scene) {
        // Create initial checkerboard
        checkerboard = new Checkerboard(8, 8, anchorPane.getWidth(), anchorPane.getHeight());
        buildAndReplace();
        
        scene.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
            double changeDelta = newSceneWidth.doubleValue() - oldSceneWidth.doubleValue();
            checkerboard.setWidth(checkerboard.getWidth() + changeDelta);
            buildAndReplace();
        });
        
        scene.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
            // TODO Generalize so this doesn't depend on this exact setup of menubar followed by checkerboard
            double changeDelta = newSceneHeight.doubleValue() - oldSceneHeight.doubleValue();
            checkerboard.setHeight(checkerboard.getHeight() + changeDelta);
            buildAndReplace();
        });
    }
    
    private void buildAndReplace() {
        AnchorPane newCheckerboard = checkerboard.build();
        if(vBox.getChildren().contains(anchorPane))
            vBox.getChildren().remove(anchorPane);
        
        // Set settings for the checkerboard ui
        VBox.setVgrow(newCheckerboard, Priority.ALWAYS);
        
        vBox.getChildren().add(newCheckerboard);
        anchorPane = newCheckerboard;
    }
    
    private void changeNumRowsAndCols(int numRows, int numCols) {
        checkerboard.setNumRows(numRows);
        checkerboard.setNumCols(numCols);
        buildAndReplace();
    }
    
    private void changeColorScheme(Color lightColor, Color darkColor) {
        checkerboard.setLightColor(lightColor);
        checkerboard.setDarkColor(darkColor);
        buildAndReplace();
    }
    
    // Set Menu Handlers
    @FXML
    private void handleSixteenGrid(ActionEvent event) {
        changeNumRowsAndCols(16, 16);
    }
    
    @FXML
    private void handleTenGrid(ActionEvent event) {
        changeNumRowsAndCols(10, 10);
    }
    
    @FXML
    private void handleEightGrid(ActionEvent event) {
        changeNumRowsAndCols(8, 8);
    }
    
    @FXML
    private void handleThreeGrid(ActionEvent event) {
        changeNumRowsAndCols(3, 3);
    }
    
    @FXML
    private void handleDefaultColors(ActionEvent event) {
        changeColorScheme(Color.RED, Color.BLACK);
    }
    
    @FXML
    private void handleBlueColors(ActionEvent event) {
        changeColorScheme(Color.SKYBLUE, Color.DARKBLUE);
    }
    
    
}
