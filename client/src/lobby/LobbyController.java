package src.lobby;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import src.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import src.component.ChatBox;


import javax.swing.text.html.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by touhoudoge on 2017/3/20.
 */
public class LobbyController implements Initializable{

    private Client client;

    @FXML private TextField inputField;
    @FXML private Button sentBtn;
    @FXML private Button createRoomBtn;
    @FXML private ListView<String> chatBox;
    @FXML private ChatBox chatBoxController;
    @FXML private Room roomController;

    @FXML private void sent(){
        /************* test ********************/
        chatBoxController.sentSentence(inputField.getText());
        /************* test ********************/
    }

    @FXML
    private void logout() throws Exception{
        /************* release *****************/
        client.gotoLogin();
        /************* release *****************/
    }

    @FXML
    private void gotoCreateRoom() throws IOException {
        client.gotoCreateRoom(roomController);
    }

    public void setClient(Client client){
        this.client = client;
        roomController.setClient(client);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        chatBox.setPrefWidth(542);
        chatBox.setPrefHeight(119);
        chatBox.setLayoutX(37);
        chatBox.setLayoutY(492);
    }
}
