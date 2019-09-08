package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class WelcomePage {

    private Scene page;
    private String info = "Trabalho realizado por\nBruno Borges\nFábio de Abreu\nJoão Vitor Costa";
    private String title;
    private Button initButton;

    public WelcomePage(String pageTitle) {
        this.title = pageTitle;
        BorderPane layout = new BorderPane();
        layout.setBottom(createBottom());
        layout.setTop(createTop());
        layout.setCenter(createCenter());
        page = new Scene(layout, 600, 600);
        page.getStylesheets().add("main.css");
    }

    public Scene getScene() {
        return this.page;
    }

    private HBox createBottom(){
        HBox bottom = new HBox();
        Label bottomLabel = new Label(info);
        bottomLabel.getStyleClass().add("bottom-label");
        bottom.getChildren().add(bottomLabel);
        return bottom;
    }

    private StackPane createTop() {
        StackPane sPane = new StackPane();
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("page-title");
        sPane.getChildren().add(titleLabel);
        return sPane;
    }

    private StackPane createCenter() {
        StackPane sPane = new StackPane();
        this.initButton = new Button("Iniciar Jogo");
        initButton.getStyleClass().add("btn-init");
        sPane.getChildren().add(this.initButton);
        return sPane;
    }

    public Button getInitBtn() {
        return this.initButton;
    }
}
