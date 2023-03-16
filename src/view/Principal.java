package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoas;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idpessoa = 0; idpessoa < 4; idpessoa++) {
			Thread tpessoa = new ThreadPessoas(idpessoa, semaforo);
			tpessoa.start();
		}

	}

}
