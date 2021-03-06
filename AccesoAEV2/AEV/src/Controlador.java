import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador {
	private Model model;
	private Vista vista;
	private ActionListener actionListenerBuscar, actionListenerReemplazar;
	private String lectura, escritura;
	
	Controlador(Model model,Vista vista) {
		this.model = model;
		this.vista= vista;
		control();
	}
		
		private void control() 
		{
			lectura = model.ficheroLectura();
	        escritura = model.ficheroEscritura();

	        verfichero(lectura,1);

	        actionListenerBuscar = new ActionListener()
	        {
	          public void actionPerformed(ActionEvent actionevent) 
	            
	            {
	                String text1 = vista.getTextFieldBuscar().getText();
	                model.buscarText(text1);
	            }
	          
	        }; 
	        vista.getBtnBuscar().addActionListener(actionListenerBuscar);

	        actionListenerReemplazar = new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent actionevent)  
	            {
	        		String text1 = vista.getTextFieldBuscar().getText();
	                String text2 = vista.getTextFieldReemplazar().getText();
	                model.reemplazarText(text1, text2);
	                verfichero(escritura,2);
	            }
	        };
	        vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);
	    	}
		private void verfichero(String fich, int numCamp) {
			ArrayList<String> arrayCont = model.contenidoFichero(fich);
			
			for(String contenido : arrayCont) {
				if(numCamp == 1) {
					vista.getTextAreaOriginal().append(contenido + "\n");
				}else {
					vista.getTextAreaModificado().append(contenido + "\n");
				}
				}
			
		}
			
		}
//Aci el que fem es ficar dos strings per a la lectura i escriptura del fitxer, amb un metode per a poder
//visualitzar.
