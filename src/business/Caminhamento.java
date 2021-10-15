package business;

import java.util.ArrayList;
import java.util.List;

public class Caminhamento {
	private  List<Integer>numeroDoVerticeDosCiclos = new ArrayList<Integer>();
	private static final int LARANJA = 10; 
	private static final int CINZA = 0; 
	private static final int BRANCO = -10;
	
	public int buscaEmProfundidade(Vertice x,Vertice y) {       
		int value = 0;
		for (Vertice z : x.getverticesAdjacentes()) {
			z.setCor(CINZA);
			if (y.getnumeroDoVertice()!=x.getnumeroDoVertice() || buscaEmProfundidade(z,y) == 1)
				value = 1;
		}
		x.setCor(LARANJA); 
		return value;
	}

	public void quantosCiclos(Grafo g) {
		for (Vertice ve : g.getVertices())
			ve.setCor(BRANCO);
		for (Vertice v : g.getVertices()) {
			v.setCor(CINZA);
			ContaCiclos(v,v);
		}
	}

	public void ContaCiclos(Vertice x,Vertice y) {
		numeroDoVerticeDosCiclos.add(x.getnumeroDoVertice());
		for (Vertice v : x.getverticesAdjacentes()) {
			if (v.getCor() == CINZA && y.getnumeroDoVertice() != v.getnumeroDoVertice()) {
				numeroDoVerticeDosCiclos.add(v.getnumeroDoVertice());
			    System.out.println(numeroDoVerticeDosCiclos);
				numeroDoVerticeDosCiclos.remove(numeroDoVerticeDosCiclos.size()-1);
			}
			else if (v.getCor() == BRANCO) {
				v.setCor(CINZA);
				ContaCiclos(v,x);
			}
		}
		x.setCor(LARANJA);
		numeroDoVerticeDosCiclos.remove(numeroDoVerticeDosCiclos.size()-1);
	}
}
