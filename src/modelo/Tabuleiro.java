package modelo;

import java.util.Random;

public class Tabuleiro {
	private int[][] jogo;

	/**
	 * 
	 */
	public Tabuleiro() {
		super();
	}

	/**
	 * @param jogo
	 */
	public Tabuleiro(int[][] jogo) {
		super();
		this.jogo = jogo;
	}

	public boolean testeObjetivo() {
		int numeroRainhas = jogo.length;
		int aux = 0;
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo.length; j++) {
				if (jogo[i][j] == 1) {
					aux++;
				}
			}
		}
		if(aux == numeroRainhas) {
			return true;
		}else {
			return false;
		}
	}

	public void inicializaAleatorio() {
		int dimensao = jogo.length;
		Random gerador = new Random();
		int posicao = gerador.nextInt(dimensao);
		jogo[posicao][0] = 1;
	}

	public int[][] copiaJogo(){
		int[][] novoJogo = new int[jogo.length][jogo.length];
		for (int i = 0; i < novoJogo.length; i++) {
			for (int j = 0; j < novoJogo.length; j++) {
				novoJogo[i][j] = jogo[i][j];
			}
		}
		return novoJogo;
	}

	public int[][] getJogo() {
		return jogo;
	}

	public void setJogo(int[][] jogo) {
		this.jogo = jogo;
	}
}
