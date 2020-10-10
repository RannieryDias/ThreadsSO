package com.company;

public class Orc extends Thread {
    public boolean gritou = false;
    public boolean gritar(){
        return gritou = true;
    }
    public void run(){
        gritar();
        System.out.println("O orc gritou? " + gritou);
    }
}
