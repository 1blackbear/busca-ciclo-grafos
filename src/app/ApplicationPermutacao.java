package app;

import java.util.List;

import business.Grafo;
import business.Permutacao;
import business.Vertice;

public class ApplicationPermutacao {
	public static void main(String[] args) {
		double inicio, fim, res;
		inicio = System.currentTimeMillis();
		Grafo grafo = new Grafo(6);
		Permutacao p = new Permutacao();
		List<Vertice> listaDeVertices = grafo.getVertices();
		grafo.colocarAresta(0, 1);
		grafo.colocarAresta(0, 2);
		grafo.colocarAresta(2, 3);
		grafo.colocarAresta(3, 0);
		grafo.colocarAresta(3, 5);
		grafo.colocarAresta(5, 0);
		grafo.colocarAresta(3, 4);
		grafo.colocarAresta(4, 0);

		for (int i = 3; i <= listaDeVertices.size(); i++) {
			List<List<Vertice>> permutacao = p.gerarPermutacoes(listaDeVertices, i);
			for (int j = 0; j < permutacao.size(); j++) {
				if (p.buscaCiclo(permutacao.get(j))) {
					permutacao.get(j).add(permutacao.get(j).get(0));
					System.out.println(permutacao.get(j));
				}
			}
		}

		fim = System.currentTimeMillis();
		res = fim - inicio;
		System.out.println("Tempo de execução : " + res + "ms");
		System.out.println("Tempo de execução em segundos: " + res / 1000 + "s");
	}
}
