package com.company;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrcLock {
    private final Lock lock = new ReentrantLock();
    int id;


    public static int Prob(double prob){
        return Math.random() < prob ? 0 : 1;
    }

    public void tentaMorder(int id, Presa presa) {
        boolean myLock = false;
        try {
            myLock = this.lock.tryLock();
        } finally {
            if (myLock && !presa.mordida) {
                int prob = Prob(0.5);
                if (prob == id) {
                    System.out.println("O orc " + id + " Mordeu a presa!");
                    presa.mordida = true;
                    this.lock.unlock();
                }
                else{
                    System.out.println("O orc "+ id + " não conseguiu morder");
                    this.lock.unlock();
                }
            }
            else {
                System.out.println("O orc "+ id + " não conseguiu morder, o outro Orc esta tentando morder");
            }
        }
    }

}

