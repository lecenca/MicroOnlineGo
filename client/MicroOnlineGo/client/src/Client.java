package src;

/**
 * Created by touhoudoge on 2017/3/20.
 */

import javafx.stage.Modality;
import src.createRoom.CreateRoomController;
import src.game.GameController;
import src.lobby.LobbyController;
import src.lobby.Room;
import src.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.signIn.SignInController;

import java.io.IOException;
import java.io.InputStream;

public class Client extends Application
{
    private Stage primaryStage;
    private Stage createRoomStage;
    private Stage gameStage;
    private Account account;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setTitle("MicroOnlineGo");
        gotoLogin();
    }

    public void gotoLogin() throws Exception{
        LoginController loginController = (LoginController) replaceSceneContent("login/login.fxml");
        loginController.setClient(this);
    }

    public void gotoLobby() throws Exception{
        LobbyController lobbyController = (LobbyController) replaceSceneContent("lobby/Lobby.fxml");
        lobbyController.setClient(this);
    }

    public void gotoSignIn() throws Exception{
        SignInController signInController = (SignInController) replaceSceneContent("signIn/SignIn.fxml");
        signInController.setClient(this);
    }

    public void backToLobby(){
        createRoomStage.close();
    }

    public void gotoCreateRoom(Room room) throws IOException {
        createRoomStage = new Stage();
        createRoomStage.initModality(Modality.APPLICATION_MODAL);
        createRoomStage.initOwner(primaryStage);
        FXMLLoader loader = new FXMLLoader();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getResource("createRoom/CreateRoom.fxml"));
        InputStream in = getClass().getResourceAsStream("createRoom/CreateRoom.fxml");
        createRoomStage.setScene(new Scene(loader.load(in)));
        createRoomStage.show();
        CreateRoomController createRoomController = (CreateRoomController) loader.getController();
        createRoomController.setClient(this);
        createRoomController.setRoom(room);
    }

    public void gotoGame() throws Exception{
        gameStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getResource("game/Game.fxml"));
        InputStream in = getClass().getResourceAsStream("game/Game.fxml");
        gameStage.setScene(new Scene(loader.load(in)));
        gameStage.show();
        GameController gameController = (GameController) loader.getController();
        gameController.setClient(this);
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getResource(fxml));
        InputStream in = getClass().getResourceAsStream(fxml);
        primaryStage.close();
        primaryStage = new Stage();
        primaryStage.setScene(new Scene(loader.load(in)));
        primaryStage.show();
        return (Initializable) loader.getController();
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public Account getAccount(){
        return account;
    }

    public static void main(String[] args)
    {
        launch(args);
    }


}
