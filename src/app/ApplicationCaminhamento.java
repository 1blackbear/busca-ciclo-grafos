package app;

import business.Caminhamento;
import business.Grafo;

public class ApplicationCaminhamento {
	public static void main(String[] args) {
		double inicio, fim, res;
		inicio = System.currentTimeMillis();
		Grafo grafo = new Grafo(6);
		Caminhamento ca = new Caminhamento();
		grafo.colocarAresta(0, 1);
		grafo.colocarAresta(0, 2);
		grafo.colocarAresta(2, 3);
		grafo.colocarAresta(3, 0);
		grafo.colocarAresta(3, 5);
		grafo.colocarAresta(5, 0);
		grafo.colocarAresta(3, 4);
		grafo.colocarAresta(4, 0);

		ca.quantosCiclos(grafo);
		fim = System.currentTimeMillis();
		res = fim - inicio;
		System.out.println("Tempo de execução: " + res + "ms");
		System.out.println("Tempo de execução em segundos: " + res / 1000 + "s");
	}
}
