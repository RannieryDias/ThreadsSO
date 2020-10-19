package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Orc extends Thread {
    private int id;
    private OrcLock orcLock;
    private Presa presa;

    public Orc(int id, OrcLock orcLock, Presa presa){
        this.id = id;
        this.orcLock = orcLock;
        this.presa = presa;
    }

    public void run(){
        System.out.println("Orc " + id +" gritou");
        while (!presa.mordida) {
            orcLock.tentaMorder(id, presa);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
