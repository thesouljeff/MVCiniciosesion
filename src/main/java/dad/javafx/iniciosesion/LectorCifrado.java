package dad.javafx.iniciosesion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public abstract class LectorCifrado {

	public static HashMap<String, String> leerFichero(String nombre) throws IOException {
		HashMap<String, String> result = new HashMap<String, String>();
		FileReader fr = new FileReader(new File(nombre));
		BufferedReader br = new BufferedReader(fr);
		String[] actual;
		String line;
		
		while ((line = br.readLine()) != null) {
			actual = line.split(",");
			result.put(actual[0], actual[1]);
		}
		
		br.close();
		fr.close();
		
		return result;
	}
}
