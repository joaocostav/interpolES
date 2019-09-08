package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class TurnPage {
    //Pagina exibida no turno do jogador

    private String player;
    private Scene page;
    String[] btnArrows = {"⇧", "⇨", "⇩", "⇦"};
    private Button[] buttons = new Button[4]; //indexaçao top right bottom left
    private int boardWidth = 30;
    private int boardHeight = 10;
    private Button[][] board;

    public TurnPage(String player, int[] tokens) {
        this.player = player;

        BorderPane layout = new BorderPane();
        layout.setTop(createTop());
        layout.setRight(createRight(tokens));
        layout.setBottom(createBottom());
        layout.setCenter(createCenter());
        page = new Scene(layout,800, 600);
        page.getStylesheets().add("main.css");
    }

    public Scene getScene() {
        return this.page;
    }

    private GridPane createCenter() {
        GridPane grid = new GridPane();
        this.board = new Button[this.boardWidth][this.boardHeight];

        for (int i = 0; i < boardWidth; ++i) {
            for (int j = 0; j < boardHeight; ++j){
                Button btn = new Button();
                btn.getStyleClass().add("board-cell");
                board[i][j] = btn;
                grid.add(btn, i, j);
            }
        }
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        return grid;
    }

    private HBox createTop() {
        HBox top = new HBox();
        Label infoToDisplay = new Label("Turno de " + this.player);
        infoToDisplay.getStyleClass().addAll("page-title", "page-title-turn");
        top.getChildren().add(infoToDisplay);
        return top;
    }

    private VBox createRight(int[] tokens) {
        VBox container = new VBox(20);
        Label columnTitle = new Label("Fichas");
        Label busTokens = new Label("Onibus: " + Integer.toString(tokens[0]));
        Label taxiTokens = new Label("Taxi: " +Integer.toString(tokens[1]));
        Label subwayTokens =  new Label("Metro: "+ Integer.toString(tokens[2]));
        container.getChildren().addAll(columnTitle, busTokens, taxiTokens, subwayTokens);
        container.getStyleClass().add("left-container");
        return container;
    }

    public VBox createBottom() {
        //Cria o tecladinho para o jogador

        initializeButtons();
        VBox topContainer = new VBox(10);
        HBox bottomContainer = new HBox(10);
        StackPane centerTopArrow = new StackPane();

        centerTopArrow.getChildren().add(buttons[0]);
        bottomContainer.getChildren().addAll(buttons[3], buttons[2], buttons[1]);
        bottomContainer.setAlignment(Pos.CENTER);
        topContainer.getChildren().addAll(centerTopArrow, bottomContainer);
        topContainer.getStyleClass().add("arrows-container");
        return topContainer;
    }

    private void initializeButtons() {
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new Button();
            buttons[i].setText(this.btnArrows[i]);
            buttons[i].getStyleClass().add("btn-move");
        }
        buttons[0].getStyleClass().add("btn-move-top");
        buttons[1].getStyleClass().add("btn-move-right");
        buttons[2].getStyleClass().add("btn-move-bottom");
        buttons[3].getStyleClass().add("btn-move-left");
    }

    public Button getButton(int index) {
        //Retorna um dos botoes da pagina indexaçao top right bottom left
        return buttons[index];
    }
}
