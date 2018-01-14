import java.util.ArrayList;
import java.util.Random;

public class Util {
	
	public static double setEixoX(ArrayList<Local>locaisVisitados){
		double aux=0.0;
		int i = 0;
		if(locaisVisitados.isEmpty()) return 0;
		for(i=0;i<locaisVisitados.size();i++){
			aux = aux + locaisVisitados.get(i).getCategoria().getValor();
		}
		return aux/i;
	}
	
	public static double setEixoY(ArrayList<Local>locaisCurtidos){
		double aux=0.0;
		int i = 0;
		if(locaisCurtidos.isEmpty()) return 0;
		for(i=0;i<locaisCurtidos.size();i++){
			aux = aux + locaisCurtidos.get(i).getCategoria().getValor();
		}
		return aux/i;
	}
	
	public static double euclidianDistance(double xA, double yA, double xB, double yB){
		double auxA = (xA-xB)*(xA-xB);
		double auxB = (yA-yB)*(yA-yB);
		return Math.sqrt(auxA + auxB);
	}
	
	public static Usuario geraUsuario(ArrayList<Local>locais){
		Usuario user;
		ArrayList<Local>locaisVisitados = new ArrayList<Local>();
		ArrayList<Local>locaisCurtidos = new ArrayList<Local>();
		Random gerador = new Random();
		int k = gerador.nextInt(8);
		int l = gerador.nextInt(8);
				
		for(int i=0;i<k;i++){
			locaisVisitados.add(locais.get(gerador.nextInt(locais.size())));
			//System.out.println("hue");			
		}
		//System.out.println(locaisVisitados.size());
		System.out.print("Locais visitados: ");
		for(Local local:locaisVisitados){
			System.out.print(local.getCategoria()+" ");
		}
		for(int i=0;i<l;i++){
			locaisCurtidos.add(locais.get(gerador.nextInt(locais.size())));
		}
		System.out.print("\nLocais curtidos: ");
		for(Local local:locaisCurtidos){
			System.out.print(local.getCategoria()+" ");
		}
		System.out.println("");
		//System.out.println(locaisCurtidos.size());
		user = new Usuario(666, locaisVisitados, locaisCurtidos);
		//System.out.println("print do user gerado");
		//user.print();
		//user.printLocaisVisitados();
		return user;
	}
	
}
