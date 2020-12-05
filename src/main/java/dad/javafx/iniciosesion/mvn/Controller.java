package dad.javafx.iniciosesion.mvn;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import dad.javafx.iniciosesion.LectorCifrado;
import javafx.application.Platform;

public class Controller {
	
	private View view = new View();
	private Model model;
	
	public Controller() {
		
		try {
			model = new Model(LectorCifrado.leerFichero("users.csv"));
		} catch (IOException e1) {
			view.mostrarAlertFicheroNoEncontrado();
			Platform.exit();
		}
		
		
		
		// Bindings Vista - Modelo
		model.nombreProperty().bind(view.getTfUsuario().textProperty());
		model.passwdProperty().bind(view.getPfPassword().textProperty());
		
		
		
		
		// Bindings de los botones
		view.getBtCancelar().setOnAction(e-> Platform.exit());
		view.getBtAcceder().setOnAction(e -> comprobarLogin());
	}
	
	private boolean usuarioExiste() {
		return (model.getDatos().containsKey(model.getNombre()));
	}
	
	private void comprobarLogin() {
		if (usuarioExiste()) {
			String md5 = DigestUtils.md5Hex(model.getPasswd()).toUpperCase();
			if (model.getDatos().get(model.getNombre()).equals(md5))
				view.mostrarAlertAccesoPermitido();
			else
				view.mostrarAlertAccesoDenegado();
		}
			
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}
	
}
