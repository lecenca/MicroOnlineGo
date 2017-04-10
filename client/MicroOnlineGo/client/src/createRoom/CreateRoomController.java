package src.createRoom;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import src.Client;
import src.lobby.Room;
import src.lobby.Table;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by touhoudoge on 2017/4/9.
 */
public class CreateRoomController implements Initializable {

    private Client client;
    private Room room;

    @FXML private TextField roomNameField;
    @FXML private TextField passwordField;
    @FXML private Button createRoomBtn;
    @FXML private Button backBtn;

    public void setClient(Client client){
        this.client = client;
    }

    public void setRoom(Room room) {this.room = room;}

    @FXML
    private void createRoom(){
        String roomName = roomNameField.getText();
        String password = passwordField.getText();
        if(password==null){
            room.createRoom(roomName);
        }else{
            room.createRoom(roomName,password);
        }
        client.backToLobby();
    }

    @FXML
    private void back(){
        client.backToLobby();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
