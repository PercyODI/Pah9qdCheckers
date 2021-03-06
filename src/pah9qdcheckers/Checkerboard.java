/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pah9qdcheckers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author pah9qd
 */
public class Checkerboard {
    
    private AnchorPane board = null;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private double rectangleWidth;
    private double rectangleHeight;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        setWidth(boardWidth);
        setHeight(boardHeight);
//        this.boardWidth = boardWidth;
//        this.boardHeight = boardHeight;
//        rectangleWidth = boardWidth / numCols;
//        rectangleHeight = boardHeight / numRows;
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        // Create a new AnchorPane
        AnchorPane newAnchorPane = new AnchorPane();
        
        // Calculate Rectangle Width and Height
        rectangleWidth = calcRectangleWidth();
        rectangleHeight = calcRectangleHeight();
        
        // For Each Row
        for(int row = 0; row < numRows; row++) {
            // For Each Column in Row
            for(int col = 0; col < numCols; col++) {
                // Create Rectangle
                Rectangle newRect = new Rectangle(rectangleWidth, rectangleHeight);
                
                // Determine Color
                if((row + col) % 2 == 0) {
                    newRect.setFill(lightColor);
                } else {
                    newRect.setFill(darkColor);
                }
                
                // Position Rectangle
                AnchorPane.setTopAnchor(newRect, (row * rectangleHeight));
                AnchorPane.setLeftAnchor(newRect, (col * rectangleWidth));
                
                // Add rectangle to anchorpane
                newAnchorPane.getChildren().add(newRect);
            }
        }
        
        return newAnchorPane;
    }
    
    public AnchorPane getBoard() {
        return board;
    }
    
    public int getNumRows(){
        return numRows;
    }
    
    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public void setWidth(double width) {
        boardWidth = width;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public void setHeight(double height) {
        boardHeight = height;
    }
    
    public Color getLightColor() {
        return lightColor;
    }

    void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }

    void setDarkColor(Color darkColor) {
        this.darkColor = darkColor;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
    
    private double calcRectangleWidth() {
        return boardWidth / numCols;
    }
    
    private double calcRectangleHeight() {
        return boardHeight / numRows;
    }
    
}