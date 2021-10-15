package business;

import java.util.ArrayList;
import java.util.List;



public  class Vertice {
	private int cor;
	private int numeroDoVertice;
	private List<Vertice> verticesAdjacentes; 
	
	public Vertice(int numeroDoVertice) {
		this.numeroDoVertice = numeroDoVertice;
		this.verticesAdjacentes = new ArrayList<Vertice>();
	}

	public boolean haAresta(int j) {
		for (Vertice v : verticesAdjacentes)
			if (v.numeroDoVertice == j)
				return true;
		return false;
	}

	@Override
	public String toString() {
		return numeroDoVertice + "";
	}

	public int getnumeroDoVertice() {
		return this.numeroDoVertice;
	}

	public List<Vertice> getverticesAdjacentes() {
		return this.verticesAdjacentes;
	}

	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}
}