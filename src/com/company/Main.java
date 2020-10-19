package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    int presas = 4;
        int qtdOrcs = 2;
        int id = 0;

        for (int index = 1; index < presas+1; index++) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Presa " + index);
            System.out.println("-----------------------------------------------------------");

            Presa presa = new Presa();
            OrcLock orcLock = new OrcLock();
            Thread myOrcs[] = new Thread[qtdOrcs];

            for (int i = 0; i < qtdOrcs; i++) {
                id = i + 1;
                myOrcs[i] = new Thread(new Orc(i, orcLock, presa));
            }
            for (int i = 0; i < qtdOrcs; i++) myOrcs[i].start();
            for (int i = 0; i < qtdOrcs; i++) myOrcs[i].join();

        }
    }
}
