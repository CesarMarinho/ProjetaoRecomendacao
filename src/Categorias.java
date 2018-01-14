
public enum Categorias {
	MUSEU(1), 
	TEMPLORELIGIOSO(2), 
	SHOPPING(3), 
	TEATRO(4), 
	PRAIA(5), 
	CINEMA(6), 
	PRAÇA(7), 
	BAR(8), 
	HOTEL(9), 
	RESTAURANTE(10), 
	LANCHONETE(11), 
	ESTÁDIODEFUTEBOL(12), 
	MONUMENTO(13), 
	BOATE(14);
	
	public int valorCategoria;
	Categorias(int valor){
		valorCategoria = valor;
	}
	
	public int getValor(){
		return valorCategoria;
	}
}
