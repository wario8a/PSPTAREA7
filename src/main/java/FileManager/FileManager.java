package FileManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
/**
*Nombre del Programa: Libreria de Manjeo de Archivos de Texto
*@author Mario Andres Ochoa Camacho
*Fecha: 16/03/2016
*Descripcion: Lee, Escribe y Busca Archivos de texto dada una direccion

*Import:java.io.BufferedReader,
*		java.io.File
*		java.io.FileNotFoundException
*		java.io.FileReader
*		java.io.IOException
*		java.util.LinkedList
*Paquete: 
*Clase: FileManager
*Metodos: ReadFile, SearchFileByExetension
*/
public class FileManager {
	/**
	 * Lee Un Archivo dado su direccion y retorno un LinkedList donde cada elemento es una fila del archivo de texto
	 * @param pathFile Ruta del Archivo
	 * @return LinkedList con las filas del archivo
	 */
	public static LinkedList<String> ReadFile(String pathFile){
		
		LinkedList<String> _LinkedList = new LinkedList<String>();
		
		BufferedReader br = null;
		try {
			
		br = new BufferedReader(new FileReader(pathFile));

		    String line = br.readLine();

		    while (line != null) {
		        _LinkedList.add(line);
		        line = br.readLine();
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return _LinkedList;
	}
	
	/**
	 * Busca los archivos de un tipo de extension especifica en una directorio y sus subdirectorios 
	 * dada su direccion retorno un Linkedlist donde cada elemento es la direccion del archivo eontrado
	 * @param pathFile Direccion donde se inicia la busqueda
	 * @param extension extension de los archivos a buscar
	 * @return LinkedList con la direccion de los archivos encontrados
	 */
	public static LinkedList<String> SearchFileByExetension(String pathFile, String extension){
		
		LinkedList<String> linkedList = new LinkedList<String>();
		File dir = new File(pathFile);
		
		for (File file : dir.listFiles()) {
			if(file.isFile()){
				if (file.getName().endsWith((extension))) {
					linkedList.add(file.getPath());
				}
			}else if(file.isDirectory()){
				LinkedList<String> subFile = SearchFileByExetension(file.getAbsolutePath(),extension);
				
				for (String item : subFile)
					linkedList.add(item);
			}
		}		
		return linkedList;
	}	
}