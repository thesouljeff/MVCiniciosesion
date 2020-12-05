package dad.javafx.iniciosesion;

import dad.javafx.iniciosesion.mvn.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private Controller controller = new Controller();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene escena = new Scene(controller.getView(), 350, 150);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Iniciar Sesión");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
