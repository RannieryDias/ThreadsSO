package com.company;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrcLock {
    private final Lock lock = new ReentrantLock();
    int id;

    public void tentaMorder(int id, Presa presa) {
        boolean myLock = false;
        try {
            myLock = this.lock.tryLock();
        } finally {
            if (myLock && !presa.mordida) {
                System.out.println("O orc " + id + " Mordeu");
                presa.mordida = true;
                this.lock.unlock();
            }
            else {
                System.out.println("O orc "+ id + " não conseguiu morder");
            }
        }
    }

}

