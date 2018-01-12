package org.academiadecodigo.bootcamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;
import org.academiadecodigo.bootcamp.service.JdbcUserService;
import org.academiadecodigo.bootcamp.service.UserService;

public class Main extends Application {

    private FXMLLoader fxmlLoader;

    private Parent root;

    private ConnectionManager connectionManager = new ConnectionManager();

    public static void main(String[] args) {
        launch(args);
    }



    /*@Override
    public void init() {

        try {

            // Instantiate the view and associated controller
            fxmlLoader = new FXMLLoader(getClass().getResource("/org/academiadecodigo/bootcamp/view/login.fxml"));
            root = fxmlLoader.load();

            // Add a test user
            UserService userService = new MockUserService();
            userService.addUser(new User("Rui Ferrao", "rui.ferrao@academiadecodigo", Security.getHash("codigoergosum")));

            // Wire the controller to the service
            LoginController loginController = fxmlLoader.getController();
            loginController.setUserService(userService);

        } catch (IOException e) {
            System.out.println("Unable to load view: " + e.getMessage());
            System.exit(1);
        }

    }*/

    @Override
    public void start(Stage primaryStage) throws Exception{

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("login");

        UserService userService = new JdbcUserService(connectionManager);
        LoginController loginController =(LoginController)Navigation.getInstance().getController("login");
        loginController.setUserService(userService);




    }

    @Override
    public void stop() throws Exception {
        super.stop();
        connectionManager.close();

    }
}

