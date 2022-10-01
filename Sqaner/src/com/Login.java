package com;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Login implements Initializable {



    @FXML
    private ImageView backButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}


	@FXML
    void back_event(MouseEvent event) {

    	try
        {
            String fxmlFile = "../resources/fxml/welcome.fxml";
            FXMLLoader loader=new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root=loader.load();

            Stage stageLogin=new Stage();
            stageLogin.initStyle(StageStyle.UNDECORATED);
            stageLogin.setTitle("Welcome");
            stageLogin.setScene(new Scene(root,250, 500));
            stageLogin.show();
            
    		Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            

        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
    }
}
