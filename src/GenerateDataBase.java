import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateDataBase {

	//private int id;
	private static String nome = "";
	private static String[] categorias = {"Nada","Museu","Templo religioso","Shopping","Teatro","Praia",
									"Cinema","Praça","Bar","Hotel","Restaurante","Lanchonete",
									"Estádio de futebol","Monumento","Boate"};
	private static char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l'};
	//private ArrayList<String> resultado = new ArrayList();
	private static String linha;
	private static Random gerador = new Random();		
	
	public static void main(String args[]) throws IOException{
		
		GerarDatabaseLocais();
		GerarDatabaseUsuarios();
		System.out.println("arquivos gerados!");
	}
	
	private static void GerarDatabaseLocais() throws IOException{
		//C:\Users\cesar\Documents\projetos\sDizimo\Kmeans7
		FileWriter arq = new FileWriter("C:\\Users\\cesar\\Documents\\Projetos\\sDizimo\\Kmeans7\\Databases\\DatabaseLugares.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
		for(int i=0;i<300;i++){
			nome = "";
			for(int j=0; j< 8; j++){//gera o nome do local
				nome = nome + letras[gerador.nextInt(11)];
			}
			linha = i+" "+nome+" "+categorias[gerador.nextInt(14)+1]+"%n";
			//System.out.println(linha);
			gravarArq.printf(linha);			
		}
		arq.close();
	}
	
	private static void GerarDatabaseUsuarios() throws IOException{
		
		//int[] locaisVisitados={};
		//int[] locaisCurtidos={};
		String linha="", listVisitados="", listCurtidos="";		
		
		FileWriter arq = new FileWriter("C:\\Users\\cesar\\Documents\\Projetos\\sDizimo\\Kmeans7\\Databases\\DatabaseUsuarios.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    
	    for(int i=0;i<300;i++){
	    	listVisitados = "";
	    	listCurtidos = "";
		    for(int j=0;j<gerador.nextInt(50);j++){
		    	//locaisVisitados[i] = gerador.nextInt(300);
		    	listVisitados = listVisitados + gerador.nextInt(300)+" ";
		    }
		    for(int j=0;j<gerador.nextInt(50);j++){
		    	//locaisCurtidos[i] = gerador.nextInt(300);
		    	listCurtidos = listCurtidos + gerador.nextInt(300)+" ";
		    }
		    linha = i +" - "+ listVisitados+"- "+ listCurtidos+"%n";
		    //System.out.println(linha);
		    gravarArq.printf(linha);
	    }
	    arq.close();
	    
	}
	
	
	
}
