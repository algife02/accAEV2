
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(model, vista);
	}

}


//En la clase principal utilitzem les clases que hem emprat.