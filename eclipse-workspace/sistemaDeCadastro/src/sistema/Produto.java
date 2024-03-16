package sistema;

public class Produto {
	
	public Produto(int codigo, String produto, double preco) {

		this.codigo = codigo;
		this.produto = produto;
		this.preco = preco;
	}
	
	    //ATRIBUTOS

	private int codigo;
	private String produto;
	private double preco;
	
	    //GETTERS AND SETTERS 

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}



