package org.academiadecodigo.bootcamp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.academiadecodigo.bootcamp.Navigation;


public class AcademiaCodigoController implements Controller {

private boolean back = true;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnPrev;

    @FXML
    void Back(ActionEvent event) {
        if (back = true){
            Back();
        }

    }

    private void Back(){
        if(back = true){
            Navigation.getInstance().back();
        }
    }
}
