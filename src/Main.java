import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Local> locais = new ArrayList<Local>();
	static Usuario usuario;

	public static void main(String[] args){
		System.out.println("começou!");
		setLists();	
		usuario = Util.geraUsuario(locais);
		//System.out.println("print do usuario");
		//usuario.print();
		usuario.setX(Util.setEixoX(usuario.getLocaisVisitados()));
		usuario.setY(Util.setEixoY(usuario.getLocaisCurtidos()));
		setXY();
		knn(usuario, usuarios);
	}
	
	public static void knn(Usuario usuario, ArrayList<Usuario>listaUsuarios){
		double menorDistancia = Util.euclidianDistance(usuario.getX(), usuario.getY(), usuarios.get(0).getX(), usuarios.get(0).getY());
		double aux=0;
		int id=0;
		double xUsuario = usuario.getX();
		double yUsuario = usuario.getY();
		for(Usuario u:listaUsuarios){
			aux = Util.euclidianDistance(xUsuario, yUsuario, u.getX(), u.getY());
			if(menorDistancia > aux){
				menorDistancia = aux;
				id = u.getIdUsuario();
			}
		}
		//System.out.println("Meu usuario");
		//usuario.print();
		//usuario.printLocaisVisitados();
		System.out.println("Usuário mais próximo: ");
		listaUsuarios.get(id).print();
	}
	
	public static void setLists(){
		
		ArrayList<Local> auxLocais = new ArrayList<Local>();
		
		String pathUsuarios = "Databases/DatabaseUsuarios.txt";
		String pathLocais = "Databases/DatabaseLugares.txt";
		
		try {
			usuarios = getUsuarios(pathUsuarios);
			locais = getLocais(pathLocais);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		for(Usuario u:usuarios){
			for(int i:u.getIdLocaisVisitados()){
				auxLocais.add(locais.get(i));
			}
			u.setLocaisVisitados(auxLocais);
			auxLocais = new ArrayList<Local>();
			for(int i:u.getIdLocaisCurtidos()){
				auxLocais.add(locais.get(i));
			}
			u.setLocaisCurtidos(auxLocais);
			auxLocais = new ArrayList<Local>();
		}
		
//		for(Usuario u:usuarios){
//			u.printTudo();
//		}
		
	}
	
	public static void setXY(){
		for(Usuario u:usuarios){
			u.setX(Util.setEixoX(u.getLocaisVisitados()));
			u.setY(Util.setEixoY(u.getLocaisCurtidos()));
			//System.out.println("x: "+u.getX()+" y: "+u.getY());
		}
	}
	
	public static ArrayList<Usuario> getUsuarios(String path) throws IOException{ //lê arquivo txt e cria lista de usuários		
		
		Usuario usuario;
		ArrayList<Usuario>usuarios = new ArrayList<Usuario>();		
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		while(br.ready()){
			String linha = br.readLine();
			String aux="";
			int id=0, count=0, aux2;
			ArrayList<Integer> locaisCurtidos = new ArrayList<Integer>();
			ArrayList<Integer> locaisVisitados = new ArrayList<Integer>();
			
			for(int i=0; i<linha.length();i++){
				
				if(count == 0){
					if(linha.charAt(i)==' '){
						i+=2;//para pular a sequência "- "
						id = Integer.parseInt(aux);
						aux = "";
						count = 1;
					}else{
						aux = aux + linha.charAt(i);
					}
				}else if(count == 1){
					if(linha.charAt(i)=='-'){
						i++;//para pular a sequência "- "
						count = 2;
					}else{
						if(linha.charAt(i)==' '){
							aux2 = Integer.parseInt(aux);
							aux="";
							locaisVisitados.add(aux2);
						}else{
							aux = aux+linha.charAt(i);
						}
					}
					
				}else{
					if(linha.charAt(i)==' '){
						aux2 = Integer.parseInt(aux);
						aux="";
						locaisCurtidos.add(aux2);
					}else{
						aux = aux+linha.charAt(i);
					}
				}				
			}
			usuario = new Usuario(locaisVisitados, locaisCurtidos, id);
			usuarios.add(usuario);
			
		}
		br.close();

		return usuarios;
	}
	
	public static ArrayList<Local> getLocais(String path) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		ArrayList<Local> locais = new ArrayList<Local>();
		
		while(br.ready()){
			String linha = br.readLine();
			int count=0, id=0;
			String aux="", nome="", auxCategoria="";
			Categorias categoria = null;
			Local local;	
			
			for(int i=0;i<linha.length();i++){
				if(count==0){
					if(linha.charAt(i)==' '){
						id = Integer.parseInt(aux);
						count=1;
						aux="";
					}else{
						aux = aux+linha.charAt(i);
					}					
				}else if(count==1){					
					if(linha.charAt(i)==' '){
						nome = aux;		
						count = 2;
						aux="";						
					}else{
						aux = aux + linha.charAt(i);
					}					
				}else{
					if(linha.charAt(i)==' '){

					}else{
						aux = aux + linha.charAt(i);						
					}					
				}
			}
			
			auxCategoria = aux;	
			auxCategoria = auxCategoria.toUpperCase();
			categoria = Categorias.valueOf(auxCategoria);
			
			local = new Local(id, nome, categoria);
			locais.add(local);
			
		}
		br.close();
		
		return locais;		
	}

}
