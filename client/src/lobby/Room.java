package src.lobby;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import src.Client;
import sun.dc.pr.PRError;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by touhoudoge on 2017/4/9.
 */
public class Room implements Initializable {

    private Client client;

    @FXML
    private ListView<Table> room;
    private ObservableList<Table> obList =  FXCollections.observableArrayList();

    @FXML
    private void click(MouseEvent mouseEvent) throws Exception {
        if(mouseEvent.getClickCount()==2){
            Table table = room.getSelectionModel().getSelectedItem();
            table.setPlayer02("玩家2");
            room.setItems(null);
            room.setItems(obList);
            if(client==null){
                System.out.print("null!!!!!!!!!");
                return;
            }
            client.gotoGame();
        }
    }

    public void setClient(Client client) {this.client = client;}

    @Override
    public void initialize(URL location, ResourceBundle resources){
        room.setItems(obList);
        room.setCellFactory((ListView<Table> lv)->new TableCell());
    }

    public void createRoom(String roomName){
        room.getItems().add(new Table(roomName,"玩家1"));
    }

    public void createRoom(String roomName,String password){
        room.getItems().add(new Table(roomName,"玩家1",password));
    }
}
