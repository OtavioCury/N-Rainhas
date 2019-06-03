package executaveis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import modelo.Tabuleiro;

public class BuscaLargura extends Busca{

	protected void executaLargura() {
		System.out.println("=======================Executando busca em largura=======================\n");
		int numeroIteracao = 1;
		boolean parada = false;
		List<Tabuleiro> tabuleirosVerificados = new ArrayList<Tabuleiro>();
		Queue<Tabuleiro> fila = new LinkedList<Tabuleiro>();

		Tabuleiro tabuleiroTopo = new Tabuleiro(new int[8][8]);
		tabuleiroTopo.inicializaAleatorio();

		fila.add(tabuleiroTopo);

		while(parada == false) {
			tabuleiroTopo = fila.remove();
			System.out.println("============= Iteração "+numeroIteracao+" ====================");
			System.out.println("=======================Fila===================");
			fila.forEach(k->{
				k.printTabuleiro();
				System.out.println();
			});
			System.out.println("=======================Tabuleiro a ser expandido===================");
			tabuleiroTopo.printTabuleiro();
			parada = tabuleiroTopo.testeObjetivo();
			if (parada == false) {
				tabuleirosVerificados.add(tabuleiroTopo);
				List<Tabuleiro> tabuleirosPossiveis = tabuleiroTopo.tabuleirosPossiveis();
				System.out.println("======================== Tabuleiros filhos ===========================");
				for (int i = 0; i < tabuleirosPossiveis.size(); i++) {
					if(!tabuleiroVerificado(tabuleirosVerificados, tabuleirosPossiveis.get(i))) {
						tabuleirosPossiveis.get(i).printTabuleiro();
						System.out.println();
						fila.add(tabuleirosPossiveis.get(i));
					}
				}
			}
			numeroIteracao++;
		}
		System.out.println("========================Solução=========================");
		tabuleiroTopo.printTabuleiro();
		System.out.println("Número de iterações: "+numeroIteracao);
	}
}
