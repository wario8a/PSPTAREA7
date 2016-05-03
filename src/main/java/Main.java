import java.io.IOException;
import java.util.LinkedList;
import FileManager.FileManager;
import Statistics.Statistics;
/**
*Nombre del Programa: Valores Estadisticos
*@author Mario Andres Ochoa Camacho
*@version 1.0
*Fecha: 27/04/2016
*Descripcion: Calcular Valores Estadisticos para una el valor estimaod y real de 10 programas

*Import: java.io.IOException,LinkedList
*Paquete: Statistics,FileManager
*Clase: Main
*Metodos: main

*Instrucciones de Uso:
*Solo es ecesario ejecutar el programa y se calculan los valores, si se desean calcualr otros es necesario modificar el programa
*/
public class Main {
/**
 * Clase Princial
 * @param args Argumentos de Inicio del Main
 */
  public static void main(String[] args ){
	  double [] xvalues;
	  double [] yvalues;
	  double correlation =0;
	  double r2 =0;
	  double significanceCorrelation =0;
	  double b0 = 0;
	  double b1=0;
	  double yk =0;
	  double range =0;
	  double upi =0;
	  double lpi=0;
	  double xk = 386;
	  LinkedList<String> linkedList;
	  
	  try{
		  
		  for(int count=1; count <= 4; count++){
			System.out.println("Test" + count + " :");
			switch(count){
				case 1:		  
					linkedList = FileManager.ReadFile("D:\\ECOS\\Proyects\\PSPTAREA7\\src\\main\\java\\data\\test1.txt");
					  break;
				case 2:		  
					  linkedList = FileManager.ReadFile("D:\\ECOS\\Proyects\\PSPTAREA7\\src\\main\\java\\data\\test2.txt");
					  break;
				case 3:
					xk = 77.6;
					linkedList = FileManager.ReadFile("D:\\ECOS\\Proyects\\PSPTAREA7\\src\\main\\java\\data\\test3.txt");
					break;
				default:
					xk = 77.6;
					linkedList = FileManager.ReadFile("D:\\ECOS\\Proyects\\PSPTAREA7\\src\\main\\java\\data\\test4.txt");
					break;
			}
						
			xvalues = ConvertListToArray(linkedList,0);
			yvalues = ConvertListToArray(linkedList,1);
			
			correlation= Statistics.LinearRegrationCalcCorrelation(xvalues, yvalues);
			r2 = Math.pow(correlation, 2);			
			b0 = Statistics.LinearRegrationCalcb0(xvalues, yvalues);
			b1 = Statistics.LinearRegrationCalcb1(xvalues, yvalues);
			yk = b1 * xk + b0;
			significanceCorrelation = Statistics.Significance(xvalues, yvalues);
			range = Statistics.Range(xvalues, yvalues,xk);
			upi = Statistics.CalcUPI(range, yk);
			lpi = Statistics.CalcLPI(range, yk);
			
			System.out.println("Rxy" + "\t" + correlation);
			System.out.println("R2" + "\t" + r2);
			System.out.println("Significance" + "\t" + significanceCorrelation);
			System.out.println("B0" + "\t" + b0);
			System.out.println("B1" + "\t" + b1);
			System.out.println("Yk" + "\t" + yk);
			System.out.println("Range" + "\t" + range);
			System.out.println("UPI(70%)" + "\t" + upi);
			System.out.println("LPI(70%)" + "\t" + lpi);
		  }
			
	  }catch (Exception ex) {
          
      }
  }
  
  /**
   * Convierte los datos de una LinkedList a un array de numeros Double
   * La Columna a convertir deben ser valores Double de lo contrario retorna un array vacio
   * @param linkedList Linkedlist de Valores separados por ';'.
   * @param column Columna de la cual se va a extraer el valor a convertir en Double
   * @return Devuelve el array de Double
   */
  private static double [] ConvertListToArray(LinkedList<String> linkedList, int column){
  		double [] values = new double[linkedList.size()];
  		int count=0;
  		try{
	  		for (String item : linkedList)
	  		{
	  			values[count] = new Double(item.split(";")[column]);
	  			count++;
	  		}
  		}catch(Exception ex){
  			values = new double[0];
  		}
  		return values;
  }
}