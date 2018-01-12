package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;
import org.academiadecodigo.bootcamp.service.JdbcUserService;
import org.academiadecodigo.bootcamp.service.JpaUserService;
import org.academiadecodigo.bootcamp.service.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application {

    private FXMLLoader fxmlLoader;

    private Parent root;

    private EntityManagerFactory emf;

    private ConnectionManager connectionManager = new ConnectionManager();

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void init() {

        emf = Persistence.createEntityManagerFactory("app");

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("login");
        UserService userService = new JpaUserService(emf);

        LoginController loginController = (LoginController)Navigation.getInstance().getController("login");
        loginController.setUserService(userService);




    }

    @Override
    public void stop() throws Exception {
        emf.close();


    }
}

