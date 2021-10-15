package business;

import java.util.ArrayList;
import java.util.List;


public class Grafo {
	private int numeroDeVertices;
	private List<Vertice> vertices; 

	public Grafo(int numeroVertices) {
		this.numeroDeVertices = numeroVertices;
		this.vertices = new ArrayList<Vertice>(0); 
		for (int i = 0; i < numeroVertices; i++)
			this.vertices.add(new Vertice(i));
	}

	public void colocarAresta(int i, int j) { 
     Vertice v1 = this.vertices.get(i); 
     Vertice v2 = this.vertices.get(j);
     v1.getverticesAdjacentes().add(v2);
	 v2.getverticesAdjacentes().add(v1);
	}
	public boolean existeAresta(int i, int j) {
		return this.vertices.get(i).haAresta(j);
	}
	
	public int getNumeroDeVertices() {
		return this.numeroDeVertices;
	}
	
	public List<Vertice> getVertices() {
		return this.vertices;
	}
	

}