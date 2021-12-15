import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {
	BorderPane pane;
	HashMap<String, Scene> sceneMap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("15 PUZZLE BY HKN");
		PuzzleList puzzles = new PuzzleList();

		ExecutorService ex = Executors.newFixedThreadPool(12);
		ex.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);

					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							primaryStage.close();
							GamePlay game = new GamePlay(puzzles.getPuzzle());
							game.show();
						}
					});
					ex.shutdown();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		createScene();
		sceneMap.put("Welcome Scene", createWelcomeScene());
		primaryStage.setScene(sceneMap.get("Welcome Scene"));
		primaryStage.show();
		Thread t = new Thread(()-> {A_IDS_A_15solver ids = new A_IDS_A_15solver();});
		t.start();

	}

	public Scene createWelcomeScene() {
		// Create the border pane and set its style, font and position.
		BorderPane welcomePane = new BorderPane();  // to add to the Scene
		welcomePane.setStyle("-fx-background-image: url(" + "welcome.jpg" + "); "
				+ "-fx-background-size: cover;");
		Font font = Font.font(null, FontWeight.EXTRA_BOLD, 30);
		Label welcomeText = new Label("15 PUZZLE BY HKN\n" + " ARE YOU READY?");
		VBox center = new VBox(welcomeText);
		center.setAlignment(Pos.CENTER);
		welcomeText.setFont(font);
		welcomePane.setCenter(center);

		// Return the welcome scene
		return new Scene(welcomePane, 1000,800);  // Return the welcome scene
	}

	public void createScene() {
		pane = new BorderPane();
		sceneMap = new HashMap<>();
	}
}
