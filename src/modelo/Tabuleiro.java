package modelo;

import java.util.ArrayList;
import java.util.List;
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
		inicializaZeros();
		int dimensao = jogo.length;
		Random gerador = new Random();
		int posicao = gerador.nextInt(dimensao);
		jogo[posicao][0] = 1;
	}

	public void inicializaZeros() {
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo.length; j++) {
				jogo[i][j] = 0;
			}
		}
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

	public void printTabuleiro() {
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo.length; j++) {
				System.out.print(jogo[i][j]+"  ");
			}
			System.out.println();
		}
	}

	public List<Tabuleiro> tabuleirosPossiveis() {
		List<Tabuleiro> tabuleiros = new ArrayList<Tabuleiro>();
		int coluna = 0;
		for (int i = 0; i < jogo.length; i++) {
			boolean colunaVazia = true;
			for (int j = 0; j < jogo.length; j++) {
				if (jogo[j][i] != 0) {
					colunaVazia = false;
				}
			}
			if (colunaVazia) {
				coluna = i;
				break;
			}
		}
		for (int i = 0; i < jogo.length; i++) {
			if(verificaPosicao(i, coluna)) {
				Tabuleiro tabuleiro = new Tabuleiro(copiaJogo());
				tabuleiro.getJogo()[i][coluna] = 1;
				tabuleiros.add(tabuleiro);
			}
		}
		return tabuleiros;
	}

	private boolean verificaPosicao(int linha, int coluna) {
		//verifica a linha
		for (int i = coluna - 1; i >= 0; i--) {
			if (jogo[linha][i] == 1) {
				return false;
			}
		}

		//diagonal primaria superior
		int l = linha, c = coluna;

		while (true) {
			if (jogo[l][c] == 1) {
				return false;
			}
			l--;
			c--;
			if (l < 0 || c < 0) {
				break;
			}
		}

		//diagonal secundaria superior
		l = linha;
		c = coluna;

		while (true) {
			if (jogo[l][c] == 1) {
				return false;
			}
			l++;
			c--;
			if (c < 0 || l > jogo.length - 1) {
				break;
			}
		}
		
		return true;
	}
}
