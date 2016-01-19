package ufficiotecnico;

public class ElementoTopografico implements Comparable<ElementoTopografico>{

	private String nome;
	private int codice;

	public ElementoTopografico(String nome, int codice) {
		this.nome = nome;
		this.codice = codice;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodice() {
		
		return codice;
	}
	
	public void setCodice(int codice) {
		this.codice = codice;
	}

	@Override
	public int compareTo(ElementoTopografico a) {
		return this.nome.compareTo(a.getNome());
	}
}
