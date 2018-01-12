

package org.academiadecodigo.bootcamp.controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TableColumn;

public class Page2Controller implements Controller{

    @FXML
    private Button btnOK;

    @FXML
    private Button btnPrev;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> location;

    @FXML
    private TableColumn<?, ?> startDate;

    @FXML
    private TableColumn<?, ?> endDate;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> gender;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> city;

    @FXML
    private TableColumn<?, ?> phone;

    @FXML
    private TableColumn<?, ?> birthdate;

    @FXML
    private TableColumn<?, ?> bootcamp;

    @FXML
    private Label bootcampID;

    @FXML
    private Label location1;

    @FXML
    private Label startDate1;

    @FXML
    private Label endDate1;

    @FXML
    void back(ActionEvent event) {

    }

}


