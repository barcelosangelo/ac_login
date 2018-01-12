package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.bootcamp.Navigation;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.UserService;
import org.academiadecodigo.bootcamp.utils.Security;

public class LoginController implements Controller{

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private Label emailLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Label registerLabel;

    @FXML
    private Label errorLabel;

    private UserService userService;

    private boolean login = true;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Called reflectively by JavaFX after all bindings are done and
     * the root element has been completely processed
     */
    public void initialize() {

        //gridPane.setGridLinesVisible(true);
        showLogin();

    }

    private void showLogin() {

        login = true;

        errorLabel.setVisible(false);

        gridPane.getChildren().remove(emailField);
        gridPane.getChildren().remove(emailLabel);

        loginButton.setText("Login");
        registerLabel.setText("Register");

    }

    private void showRegister() {

        login = false;

        errorLabel.setVisible(false);

        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailField, 1, 2);

        loginButton.setText("Submit");
        registerLabel.setText("Cancel");

    }

    private void doLogin() {

        if (usernameField.getText().isEmpty()) {
            showConsoleText("username missing");
            return;
        }

        if (passwordField.getText().isEmpty()) {
            showConsoleText("password missing");
            return;
        }

        if (userService.authenticate(usernameField.getText(), passwordField.getText())) {
            showConsoleText("login accepted");
            Navigation.getInstance().loadScreen("AcademiaCodigo");

        } else {
            showConsoleText("authentication failed");
        }

    }

    private void doRegister() {

        if (usernameField.getText().isEmpty()) {
            showConsoleText("username missing");
            return;
        }

        if (passwordField.getText().isEmpty()) {
            showConsoleText("password missing");
            return;
        }

        if (emailField.getText().isEmpty()) {
            showConsoleText("email missing");
            return;
        }

        if (userService.findByName(usernameField.getText()) != null) {
            showConsoleText("username taken");
            return;
        }

        userService.addUser(new User(usernameField.getText(), emailField.getText(), Security.getHash(passwordField.getText())));

        showLogin();
        showConsoleText("registration successful");

    }

    private void showConsoleText(String text) {

        errorLabel.setText("console.log(\"" + text + "\");");
        errorLabel.setVisible(true);

    }

    public void onButton(ActionEvent event) {

        if (login) {
            doLogin();
        } else {
            doRegister();
        }

    }

    public void onLink(MouseEvent event) {

        if (login) {
            showRegister();
        } else {
            showLogin();
        }

    }

}
