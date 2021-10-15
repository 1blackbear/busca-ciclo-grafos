package business;

import java.util.ArrayList;
import java.util.List;

public class Permutacao {
		public List<List<Vertice>> gerarPermutacoes(List<Vertice> elementos, int tamanhoDaLista) {
			List<List<Vertice>> todasAsListas = new ArrayList<List<Vertice>>();
			if (tamanhoDaLista == 1) {
				for (int i = 0; i < elementos.size(); i++) {
					List<Vertice> listaDeVertices = new ArrayList<Vertice>();
					listaDeVertices.add(elementos.get(i));
					todasAsListas.add(listaDeVertices);
				}
			}	else {
				List<List<Vertice>>todasAsSublistas = gerarPermutacoes(elementos, tamanhoDaLista - 1);
				for (int i = 0; i < elementos.size(); i++) {
					for (int j = 0; j < todasAsSublistas.size(); j++) {
						List<Vertice> listaAtual = todasAsSublistas.get(j); 
						List<Vertice> novaLista = new ArrayList<Vertice>();
						Vertice itemVertice = elementos.get(i);
						novaLista.add(itemVertice);
						novaLista.addAll(listaAtual);
						todasAsListas.add(novaLista);
					}
				}
			}
			return todasAsListas;
		}

		public boolean buscaCiclo(List<Vertice> elementos) {
			boolean resp = false;
			if (elementos.size() >= 3) {
				resp = true;
				for (int i = 0; i < elementos.size(); i++) {
					for (int J = 0; J < elementos.size(); J++) {
						if (i!= J && elementos.get(i).equals(elementos.get(J))   ) {										
							resp = false;
						}
					}
				}
				for (int i = 0; i < elementos.size(); i++) {
					if(!elementos.get(i).haAresta(elementos.get( (i+1)%elementos.size()).getnumeroDoVertice())) {	
						resp = false;
					}
				}
			}
			return resp;
		}
}






