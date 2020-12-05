package dad.javafx.iniciosesion.mvn;

import java.util.HashMap;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty passwd = new SimpleStringProperty();
	private HashMap<String, String> datos;
	
	public Model(HashMap<String, String> datos) {
		this.datos = datos;  
	}
	
	public HashMap<String, String> getDatos() {
		return datos;
	}
	
	public void setDatos(HashMap<String, String> datos) {
		this.datos = datos;
	}

	public boolean usuarioExiste() {
		return (datos.containsKey(getNombre()));
	}

	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	
	public final String getNombre() {
		return this.nombreProperty().get();
	}
	
	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	
	public final StringProperty passwdProperty() {
		return this.passwd;
	}
	
	public final String getPasswd() {
		return this.passwdProperty().get();
	}
	
	public final void setPasswd(final String passwd) {
		this.passwdProperty().set(passwd);
	}
	
}
