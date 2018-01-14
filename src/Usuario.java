import java.util.ArrayList;

public class Usuario {
	
	private int idUsuario;
	ArrayList<Local> locaisVisitados = new ArrayList<Local>();
	ArrayList<Local> locaisCurtidos = new ArrayList<Local>();
	ArrayList<Integer> idLocaisVisitados = new ArrayList<Integer>();
	ArrayList<Integer> idLocaisCurtidos = new ArrayList<Integer>();
	
	//para cálculo do knn
	private double x;
	private double y;
	
	public Usuario(int idUsuario, ArrayList<Local> locaisVisitados, ArrayList<Local> locaisCurtidos) {
		super();
		this.idUsuario = idUsuario;
		this.locaisVisitados = locaisVisitados;
		this.locaisCurtidos = locaisCurtidos;
		//System.out.println(this.locaisVisitados.size());
	}
	
	public Usuario(ArrayList<Integer> idLocaisVisitados, ArrayList<Integer> idLocaisCurtidos, int idUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.idLocaisVisitados = idLocaisVisitados;
		this.idLocaisCurtidos = idLocaisCurtidos;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public ArrayList<Local> getLocaisVisitados() {
		return locaisVisitados;
	}

	public void setLocaisVisitados(ArrayList<Local> locaisVisitados) {
		this.locaisVisitados = locaisVisitados;
	}

	public ArrayList<Local> getLocaisCurtidos() {
		return locaisCurtidos;
	}

	public void setLocaisCurtidos(ArrayList<Local> locaisCurtidos) {
		this.locaisCurtidos = locaisCurtidos;
	}
	
	public ArrayList<Integer> getIdLocaisVisitados() {
		return idLocaisVisitados;
	}

	public void setIdLocaisVisitados(ArrayList<Integer> idLocaisVisitados) {
		this.idLocaisVisitados = idLocaisVisitados;
	}

	public ArrayList<Integer> getIdLocaisCurtidos() {
		return idLocaisCurtidos;
	}

	public void setIdLocaisCurtidos(ArrayList<Integer> idLocaisCurtidos) {
		this.idLocaisCurtidos = idLocaisCurtidos;
	}
	
	
	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "id=" + idUsuario + ", locaisVisitados=" + locaisVisitados + ", locaisCurtidos="+ locaisCurtidos + "]";
	}
	
	public void printLocaisVisitados(){
		System.out.print(idUsuario+" Visitas: ");
		for(int i:idLocaisVisitados){
			System.out.print(i+" ");
		}
		System.out.println("");
	}
	
	public void print(){
		System.out.print(idUsuario+" qtd"+this.locaisVisitados.size()+" Visitas:");
		for(int i:idLocaisVisitados){
			System.out.print(i+" ");
		}
		System.out.print(" Curtidos: ");
		for(int i:idLocaisCurtidos){
			System.out.print(i+" ");
		}
		System.out.println("");
	}
	
	public void printTudo(){
		System.out.print("Id: "+idUsuario+" ");
		System.out.print(" -Locais visitados: ");
		for(Local l:locaisVisitados){
			System.out.print(" "+l.getCategoria());
		}
		System.out.print(" -Locais curtidos: ");
		for(Local l:locaisCurtidos){
			System.out.print(" "+l.getCategoria());
		}
		System.out.println("");
	}
	
}
