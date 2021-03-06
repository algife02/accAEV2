import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Model {
	private String fichLec;
	private String fichEsc;
	
	Model() {
		fichLec = "AE02_T1_2_Streams_Groucho.txt";
		fichEsc = "AE02_T1_2_Streams_Groucho_2.txt";
	}
	
	public ArrayList<String> contenidoFichero(String fichero) {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fichero);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return contenidoFichero;
	}
	
	
	public String ficheroLectura() {
		return fichLec;
	}
	public String ficheroEscritura() {
		return fichEsc;
	}
	
	
	public void reemplazarText(String textbusca, String textnuev) 
    {
        File lec = new File(fichLec);

        File esc = new File(fichEsc);

        try 
        {
            FileReader fr = new FileReader(lec);

            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(esc);

            BufferedWriter bw = new BufferedWriter(fw);

            String linea = br.readLine();

            String linea2;

            while(linea != null)
            {
                linea2 = linea.replace(textbusca, textnuev);

                bw.write(linea2);

                bw.newLine();

                linea = br.readLine();
            }

            br.close();
            fr.close();
            bw.close();
            fw.close();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
	
	public int buscarText(String textbuscar) {
		File lec = new File(fichLec);
		int contador = 0;
		
		try {
			FileReader fr = new FileReader(lec);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			while(linea !=null) {
				contador ++;
				
				if(linea.indexOf(textbuscar) > -1) {
					contador ++;
				}
				linea =br.readLine();
			}
			br.close();
			fr.close();
			
			JOptionPane.showMessageDialog(new JFrame(), contador, "INF", JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return contador;
	}
}

//En aquesta clase el que anem a fer es fer dos strings, amb un constructor
//per a que guarde el archiu descarregat, i uns metodes per a buscar text amb un altre per a que reemplace text