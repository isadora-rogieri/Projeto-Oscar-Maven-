package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LerManipularArquivo {
    public static List<Oscar> criandoNovoOscar(String filename)
            throws IOException {

        List<String> linhas = new ArrayList<>();
        try (InputStream in =
                Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linhas.add(line);
            }
            linhas.remove(0);
            return converterEmOscar(linhas);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
	}
	
	private static  List<Oscar> converterEmOscar(List<String> linhas) {
		List<Oscar> resultado = new ArrayList<>();
		for (String linha : linhas) {
			String[] campos = linha.split(";");
			Oscar novoOscar = new Oscar(Integer.parseInt(campos[0]),Integer.parseInt(campos[1]), 
					Integer.parseInt(campos[2]),
					campos[3], campos[4]);
			resultado.add(novoOscar);
			
		}
		return resultado;
	}

}
