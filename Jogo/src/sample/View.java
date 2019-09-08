package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class View extends Application {

    Stage window;
    String appTitle = "Interpool";
    WelcomePage welcomePage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Inicia a view e carrega a pagina Welcome
        this.window = primaryStage;
        window.setTitle(this.appTitle);

        welcomePage = new WelcomePage("Bem vindo ao Interpool");
        window.setScene(welcomePage.getScene());

        Scene turn = new TurnPage("Fabio", new int[]{4, 6, 1} ).getScene();
        welcomePage.getInitBtn().setOnAction(e -> window.setScene(turn));;
        window.show();
    }

}
