package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread{
	
	private int idpessoa;
	private Semaphore mutex;

	public ThreadPessoas(int idpessoa, Semaphore mutex) {
		this.idpessoa = idpessoa;
		this.mutex = mutex;
	}
	
	@Override
	public void run() {
		andando();
		try {
			mutex.acquire();
			AbrindoPorta();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mutex.release();
		}
		
	}

	private void andando() {
		int distanciaCorredor = 20;
		int percorrida = 0;
		int passo = (int) ((Math.random() * 3) + 4);
		int tempo = 1000;
		while(percorrida < distanciaCorredor) {
			percorrida += passo;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("A pessoa " + idpessoa + " andou " + percorrida + " metros");
		}
		System.out.println("A pessoa " + idpessoa + " abriu a porta");
	}

	private void AbrindoPorta() {
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
