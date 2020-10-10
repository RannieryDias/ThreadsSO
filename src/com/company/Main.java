package com.company;

public class Main {

    public static void main(String[] args) {
	    Runtime rt = Runtime.getRuntime();
	    System.out.println(rt.availableProcessors());
	    Orc orc1 = new Orc();
	    orc1.start();
        Orc orc2 = new Orc();
        orc2.start();
    }
}
