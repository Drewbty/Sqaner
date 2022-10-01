package com;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Main extends Application {


    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
    	primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/welcome.fxml"));
        primaryStage.setTitle("Sqaner");
        Scene scene = new Scene(root, 250, 500);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("../resources/css/theme.css").toExternalForm());
        primaryStage.show();
    }
    
    @FXML
    public void onSettingButtonClick(ActionEvent event)
    {
        
    }
    
    @FXML
    void Login_event(ActionEvent event) {
    	try
        {
            String fxmlFile = "../resources/fxml/login.fxml";
            FXMLLoader loader=new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root=loader.load();

            Stage stageLogin=new Stage();
            stageLogin.initStyle(StageStyle.UNDECORATED);
            stageLogin.setTitle("Login");
            stageLogin.setScene(new Scene(root,250, 500));
            stageLogin.show();
            
    		Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            

        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
    	
    }

    @FXML
    void signup_event(ActionEvent event) {
    	try
        {
            String fxmlFile = "../resources/fxml/signup.fxml";
            FXMLLoader loader=new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root=loader.load();

            Stage stageSignup=new Stage();
            stageSignup.initStyle(StageStyle.UNDECORATED);
            stageSignup.setTitle("Signup");
            stageSignup.setScene(new Scene(root,250, 500));
            stageSignup.show();
            
    		Stage stage = (Stage) signupButton.getScene().getWindow();
            stage.close();
            

        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
    }
	
	public static void main(String[] args) {
        launch(args);
	}
}
