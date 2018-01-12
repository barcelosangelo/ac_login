package org.academiadecodigo.bootcamp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.controller.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class Navigation {

    private final int MIN_WITH = 1024;
    private final int MIN_HEIGHT = 768;

    private LinkedList<Scene> scenes = new LinkedList<Scene>();
    private Map<String, Controller> controllers = new HashMap<>();

    private Stage stage;


    private static Navigation instance = null;

    private Navigation(){

    }
    public static synchronized Navigation getInstance(){
        if(instance == null){
            instance = new Navigation();
        }
        return instance;
    }

    public void loadScreen(String view){
        try {
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + view + ".fxml"));
            Parent root = fxmlLoader.load();

            controllers.put(view, fxmlLoader.<Controller>getController());

            Scene scene = new Scene(root, MIN_WITH, MIN_HEIGHT);
            scenes.push(scene);

            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view" + view + " : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void back(){
        if (scenes.isEmpty()){
            return;
        }
        scenes.pop();

        setScene(scenes.peek());
    }

    private void setScene(Scene scene){

        stage.setScene(scene);

        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Controller getController(String key) {
        return controllers.get(key);
    }
}
