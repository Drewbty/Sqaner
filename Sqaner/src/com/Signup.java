package com;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Signup implements Initializable {


    @FXML
    private ImageView backButton;

    @FXML
    private Button signupButton;
    

    @FXML
    private TextField FirstNameTextField;

    @FXML
    private CheckBox agreeCheckBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField lastNameTextFİeld;

    @FXML
    private PasswordField password2Field;

    @FXML
    private PasswordField passwordField;
    

    @FXML
    private Label passwordErrorLabel;
    
    @FXML
    private Label emailErrorLabel;
    
    private String defaultPasswordErrorText = "Use 8 or more characters with a mix of letters, numbers & symbols";
	
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
	
	public boolean checkName(String name, String surname) {
		return name != null && surname != null && !name.isBlank() && !surname.isBlank();
	}
	
	public boolean checkEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		 
		Pattern pattern = Pattern.compile(regex);
		
		return email != null && pattern.matcher(email).matches();
	}
	
	public boolean checkPasswords(String password1, String password2) {
		
		
		return password1 != null && password2 != null && !password1.isBlank() && containsNumber(password1)  && containsLowerCase(password1) && containsUpperCase(password1) && containsSpecialCharacter(password1) && password1.equals(password2);
	}

	private boolean containsLowerCase(String value) {
	    return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
	}

	private boolean containsUpperCase(String value) {
	    return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
	}

	private boolean containsNumber(String value) {
	    return contains(value, Character::isDigit);
	}

	private boolean contains(String value, IntPredicate predicate) {
	    return value.chars().anyMatch(predicate);
	}
	
	private boolean containsSpecialCharacter(String value) {
		for (char c : value.toCharArray()) {
			if (!Character.isUpperCase(c) && !Character.isLowerCase(c) && !Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
	
    @FXML
    void signup_event(ActionEvent event) {
    	passwordErrorLabel.setText(defaultPasswordErrorText);
    	emailErrorLabel.setText("");
    	boolean ok = true;
		if (!checkName(FirstNameTextField.getText(), lastNameTextFİeld.getText())) {
			FirstNameTextField.setPromptText("Names cannot be empty");
			lastNameTextFİeld.setPromptText("Names cannot be empty");
			ok = false;
		}
		if (!checkEmail(emailTextField.getText())) {
			if (emailTextField.getText().isBlank()) {
				emailErrorLabel.setText("Email cannot be blank");
			}else if(emailTextField.getText().indexOf('@') < 0) {
				emailErrorLabel.setText("Email should contain @");
			}else if(emailTextField.getText().indexOf('.') < 0) {
				emailErrorLabel.setText("Email should contain a domain");
			}else {
				emailErrorLabel.setText("Email can only contain letters, numbers and periods");
			}
			ok = false;
		}
		if (!checkPasswords(passwordField.getText(), password2Field.getText())) {
			if (passwordField.getText().isBlank()) {
				passwordErrorLabel.setText("Password cannot be blank");
			}else if (!containsNumber(passwordField.getText())) {
				passwordErrorLabel.setText("A digit must occur at least once.");
			}else if (!containsLowerCase(passwordField.getText())) {
				passwordErrorLabel.setText("A lower case letter must occur at least once.");
			}else if (!containsUpperCase(passwordField.getText())) {
				passwordErrorLabel.setText("A lower case letter must occur at least once.");
			}else if (!containsSpecialCharacter(passwordField.getText())) {
				passwordErrorLabel.setText("Password should contain at least 1 special character.");
			} else if (!password2Field.getText().equals(passwordField.getText())) {
				password2Field.setText("");
				password2Field.setPromptText("Both passwords must be the same.");
			}
			ok = false;
		}else {
			passwordErrorLabel.setText("");
		}
		
		if (ok) {
			System.out.print("OK");
		}
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
