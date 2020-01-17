package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    TextField login;
    @FXML
    PasswordField password;
    @FXML
    Button buttonOk;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonOk.setOnAction(event -> {
            if (login.getText().equals("admin") && password.getText().equals("12345")){
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("../main/Maain_window.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    buttonOk.getScene().getWindow().hide();
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
