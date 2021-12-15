import java.util.HashMap;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GamePlay extends Stage{
    // defining variables
    Pane board;
    TextField winner; ;
    TextArea extraInfo2, extraInfo3;
    MyButton gameButton[][];
    Button runSolver, h1, h2;
    VBox leftBox, rightBox;
    BorderPane pane;
    MenuBar menubar;
    Menu gamePuzzles, options;
    MenuItem GameInstruction, newGame, exitGame;
    MenuItem p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;;
    HashMap<String, Scene> sceneMap;
    int ZeroX, ZeroY;
    PuzzleList puzzleList = new PuzzleList();
    int[] puzzle;

    // 1 arg constructor
    public GamePlay(int[] puzzleInput) {
        this.puzzle = puzzleInput;
        this.setScene(getMyScene());
    }

    // creating the control scene where it will hold all the elements of the game play
    public Scene createControlScene() {
        // create the pane for the scene
        pane = new BorderPane();
        pane.setStyle("-fx-background-color: beige");
        pane.setPrefSize(1000, 500);

        // create the board at the middle and the buttons inside the board
        createButtons();
        createBoard();

        // the menu bar will be in the top
        pane.setTop(menubar);
        // the left box will have the solution H1 and H2
        pane.setLeft(leftBox);
        // the center box will have the game board
        pane.setCenter(board);
        // the right box will display all the game information
        pane.setRight(rightBox);
        return new Scene(pane, 1000, 800);
    }

    // create the game scene
    public void createScene() {
        pane = new BorderPane();
        sceneMap = new HashMap<>();
    }

    // create all the menus
    public void createMenu() {
        menubar = new MenuBar();
        // all the main menus
        gamePuzzles = new Menu("Game Puzzles");
        options = new Menu("Game Options");
        menubar.getMenus().addAll(gamePuzzles, options);

        // sub-menus for Game Puzzles
        p1 = new MenuItem("First Puzzle");
        p2 = new MenuItem("Second Puzzle");
        p3 = new MenuItem("Third Puzzle");
        p4 = new MenuItem("Forth Puzzle");
        p5 = new MenuItem("Fifth Puzzle");
        p6 = new MenuItem("Sixth Puzzle");
        p7 = new MenuItem("Seventh Puzzle");
        p8 = new MenuItem("Eighth Puzzle");
        p9 = new MenuItem("Ninth Puzzle");
        p10 = new MenuItem("Tenth Puzzle");

        // sub-menu for game option
        GameInstruction = new MenuItem("How To Play");
        newGame = new MenuItem("New Game");
        exitGame = new MenuItem("Exit Game");
        // get all the menu option item
        gamePuzzles.getItems().add(p1);
        gamePuzzles.getItems().add(p2);
        gamePuzzles.getItems().add(p3);
        gamePuzzles.getItems().add(p4);
        gamePuzzles.getItems().add(p5);
        gamePuzzles.getItems().add(p6);
        gamePuzzles.getItems().add(p7);
        gamePuzzles.getItems().add(p8);
        gamePuzzles.getItems().add(p9);
        gamePuzzles.getItems().add(p10);
        options.getItems().add(GameInstruction);
        options.getItems().add(newGame);
        options.getItems().add(exitGame);
        loadPuzzle();
    }

    // function to load in the puzzle
    public void loadPuzzle() {
        p1.setOnAction(e -> {
            puzzle = puzzleList.getPuzzle(0);
            updateButtons();
        });
        p2.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(1);
            updateButtons();
        });
        p3.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(2);
            updateButtons();
        });
        p4.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(3);
            updateButtons();
        });
        p5.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(4);
            updateButtons();
        });
        p6.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(5);
            updateButtons();
        });
        p7.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(6);
            updateButtons();
        });
        p8.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(7);
            updateButtons();
        });
        p9.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(8);
            updateButtons();
        });
        p10.setOnAction(e->{
            puzzle = puzzleList.getPuzzle(9);
            updateButtons();
        });
        newGame.setOnAction(e->{
            puzzle = puzzleList.getPuzzle();
            updateButtons();
        });
    }

    // displaying the solution
    public void infoDisplay() {
        runSolver = new Button("See The Solution");
        runSolver.setPrefWidth(200);
        runSolver.setOnAction(e -> {
            runSolver.setDisable(true);
            h1.setDisable(false);
            h2.setDisable(false);
        });

        // option for H1
        h1 = new Button("A1 H1");
        h1.setDisable(true);
        h1.setPrefWidth(200);
        h1.setOnAction(e -> {
            int[] temp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    temp[4 * i + j] = gameButton[i][j].val;
                }
            }

            A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
            Node startState = new Node(temp);
            startState.setDepth(0);
            String path = solution.A_Star(startState, "heuristicOne");
            char[] chars = path.toCharArray();
            String s = "";
            for (int i = 0; i < 10; i++) {
                s += chars[i];
            }
            extraInfo3.clear();
            extraInfo3.setText("HINT: " + s);

        });

        // option for H2
        h2 = new Button("A1 H2");
        h2.setDisable(true);
        h2.setPrefWidth(200);
        h2.setOnAction(e -> {
            int[] temp = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    temp[4*i + j] = gameButton[i][j].val;
                }
            }

            A_IDS_A_15solver solution = new A_IDS_A_15solver(true);
            Node startState = new Node(temp);
            startState.setDepth(0);
            String path = solution.A_Star(startState, "heuristicTwo");
            extraInfo3.clear();
            extraInfo3.setText("HINT: " + path);
        });

        leftBox = new VBox();
        leftBox.setPrefWidth(200);
        leftBox.getChildren().addAll(runSolver, h1, h2);
        // starting the game announcement
        extraInfo2 = new TextArea("The game has been started");
        extraInfo2.setPrefSize(200, 250);
        extraInfo2.setWrapText(true);
        extraInfo2.setDisable(true);

        extraInfo3 = new TextArea("");
        extraInfo3.setPrefSize(200, 250);
        extraInfo3.setWrapText(true);
        extraInfo3.setDisable(true);

        rightBox = new VBox();
        rightBox.setPrefSize(200, 500);
        rightBox.getChildren().addAll(extraInfo2, extraInfo3);

    }

    // creating the game button
    public void createButtons() {
        EventHandler<ActionEvent> handler = gameButtonHandler();
        gameButton = new MyButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameButton[i][j] = new MyButton(i, j, 0);
                gameButton[i][j].setOnAction(handler);
            }
        }
    }

    // update the button
    public void updateButtons() {
        EventHandler<ActionEvent> handler = gameButtonHandler();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameButton[i][j].changeValue(puzzle[4 * i + j]);
            }
        }
        enableAvailableTiles();
    }

    // create the game board
    public void createBoard() {
        board = new Pane();
        board.setStyle("-fx-background-image: url(" + "board.jpg"
                + "); " + "-fx-background-size: cover;");
        board.setMaxSize(800, 600);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameButton[i][j].setLayoutX(100*(j+1));
                gameButton[i][j].setLayoutY(100*(i+1));
            }
        }
        board.getChildren().addAll(gameButton[0][0], gameButton[0][1], gameButton[0][2], gameButton[0][3],
                gameButton[1][0], gameButton[1][1], gameButton[1][2], gameButton[1][3],
                gameButton[2][0], gameButton[2][1], gameButton[2][2], gameButton[2][3],
                gameButton[3][0], gameButton[3][1], gameButton[3][2], gameButton[3][3]);
    }


    public EventHandler<ActionEvent> gameButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if ( event.getSource() == gameButton[i][j]) {
                            String str;
                            str = "(X = " + i + ", Y = " + j + ")";
                            extraInfo2.setText(str + "\nValue: " + gameButton[i][j].val);
                            swap(i, j);
                        }
                    }
                }
            }
        };
    }

    public void updateZeroPos() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameButton[i][j].val == 0) {
                    ZeroX = i;
                    ZeroY = j;
                }
            }
        }
    }

    public void disableAllAblities() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameButton[i][j].setDisable(true);
            }
        }
    }

    public void enableAvailableTiles() {
        updateZeroPos();
        disableAllAblities();
        if (ZeroX + 1 < 4) {
            gameButton[ZeroX+1][ZeroY].setDisable(false);
        }
        if (ZeroX - 1 > -1) {
            gameButton[ZeroX-1][ZeroY].setDisable(false);
        }
        if (ZeroY + 1 < 4) {
            gameButton[ZeroX][ZeroY+1].setDisable(false);
        }
        if (ZeroY - 1 > -1) {
            gameButton[ZeroX][ZeroY-1].setDisable(false);
        }
    }

    public void swap(int x, int y) {
        gameButton[ZeroX][ZeroY].changeValue(gameButton[x][y].val);
        gameButton[x][y].changeValue(0);

        updateZeroPos();
        extraInfo2.setText(ZeroX + ", " + ZeroY);
        enableAvailableTiles();
        winCheck();
    }

    public boolean winCheck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameButton[i][j].val != (4 * i + j)) {
                    return false;
                }
            }
        }
        extraInfo2.setText("You Won!!! Is this game too easy for you?");
        disableAllAblities();
        return true;
    }

    public Scene getMyScene()  {
        setTitle("15 Puzzle by HKN");
        createScene();
        infoDisplay();
        createMenu();

        GameInstruction.setOnAction(e -> {
            String s = "You will have to try to solve the puzzle so that every number will be in the numerical order.\n"
                    + "You will only allow to swap 0 with other numbers. GOOD LUCK!!!";
            extraInfo2.setText(s);
        });

        exitGame.setOnAction(e -> {
            System.exit(0);
            Platform.exit();
        });

        winner = new TextField("Congratulation! You Win");
        winner.setDisable(true);
        winner.setPrefSize(150, 150);


        sceneMap.put("scene", createControlScene());
        updateButtons();
        updateZeroPos();
        enableAvailableTiles();
        winCheck();

        return sceneMap.get("scene");
    }
}
