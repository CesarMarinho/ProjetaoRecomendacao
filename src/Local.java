
public class Local {

	private int idLocal;
	private String nome;
	private Categorias categoria;
	
	public Local(int id, String nome, Categorias categoria){
		this.idLocal = id;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "id=" + idLocal + " nome=" + nome + " categoria=" + categoria;
	}				
	
}
