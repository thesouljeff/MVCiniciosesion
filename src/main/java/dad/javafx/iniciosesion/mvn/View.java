package dad.javafx.iniciosesion.mvn;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View extends BorderPane {
	
	private TextField tfUsuario;
	private PasswordField pfPassword;
	
	private Button btAcceder;
	private Button btCancelar;
	
	public View() {
		super();
		
		tfUsuario = new TextField();
		pfPassword = new PasswordField();
		
		tfUsuario.setPromptText("Usuario");
		pfPassword.setPromptText("Contraseña");
		
		GridPane centro = new GridPane();
		centro.setHgap(30);
		centro.setVgap(10);
//		centro.setGridLinesVisible(true);
//		centro.setStyle("-fx-background-color: red;");
		centro.setAlignment(Pos.CENTER);
		
		centro.addRow(0,  new Label("Usuario:"), tfUsuario);
		centro.addRow(1,  new Label("Contraseña:"), pfPassword);
		
		ColumnConstraints[] cols = {
			new ColumnConstraints(),
			new ColumnConstraints(),
		};
		
		centro.getColumnConstraints().setAll(cols);
		
		// Botones de acceso
		btAcceder = new Button("Acceder");
		btCancelar = new Button("Cancelar");
		
		HBox abajo = new HBox();
		abajo.setAlignment(Pos.TOP_CENTER);
		abajo.setSpacing(10);
		
		btAcceder.setDefaultButton(true);
		
		abajo.getChildren().addAll(btAcceder, btCancelar);
		
		centro.add(abajo, 0, 2);
		GridPane.setColumnSpan(abajo, 2);
		
		this.setCenter(centro);
	}
	
	public void mostrarAlertAccesoPermitido() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText("Acceso permitido");
		alert.setContentText("Las credenciales de acceso son válidas.");

		alert.showAndWait();
		Platform.exit();
	}
	
	public void mostrarAlertAccesoDenegado() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText("Acceso denegado");
		alert.setContentText("El usuario y/o la contraseña no son válidos.");

		alert.showAndWait();
		Platform.exit();
	}
	
	public void mostrarAlertFicheroNoEncontrado() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText("Fichero no encontrado");
		alert.setContentText("Se ha producido un error intentando acceder al fichero con los datos de los usuarios");

		alert.showAndWait();
	}

	public TextField getTfUsuario() {
		return tfUsuario;
	}

	public void setTfUsuario(TextField tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public PasswordField getPfPassword() {
		return pfPassword;
	}

	public void setPfPassword(PasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}

	public Button getBtAcceder() {
		return btAcceder;
	}

	public void setBtAcceder(Button btAcceder) {
		this.btAcceder = btAcceder;
	}

	public Button getBtCancelar() {
		return btCancelar;
	}

	public void setBtCancelar(Button btCancelar) {
		this.btCancelar = btCancelar;
	}
}
