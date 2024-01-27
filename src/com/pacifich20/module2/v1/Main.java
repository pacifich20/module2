package com.pacifich20.module2.v1;

public class Main {

    public static void main(String[] args) {

        Planet neptune1 = new Planet("Neptune", PlanetType.ICE);
        Planet mars1 = new Planet("Mars", PlanetType.ROCKY);
        Planet jupiter1 = new Planet("Jupiter", PlanetType.GAS);
        Planet jupiter2 = new Planet("Jupiter", PlanetType.GAS);

        System.out.println("Neptune 1 - " + neptune1);
        System.out.println("Neptune 1 hashcode: " + neptune1.hashCode());
        System.out.println("Mars 1 - " + mars1);
        System.out.println("Mars 1 hashcode: " + mars1.hashCode());
        System.out.println("Jupiter 1 - " + jupiter1);
        System.out.println("Jupiter 1 hashcode: " + jupiter1.hashCode());
        System.out.println("Jupiter 2 - " + jupiter2);
        System.out.println("Jupiter 2 hashcode: " + jupiter2.hashCode());
        System.out.println("Is Jupiter 1 equal to Jupiter 2? " + jupiter1.equals(jupiter2));
        System.out.println("Is Mars 1 equal to Jupiter 2? " + mars1.equals(jupiter2));
        System.out.println("Is Neptune 1 equal to Jupiter 1? " + neptune1.equals(jupiter1));
        System.out.println("Is Neptune 1 equal to Mars 1? " + neptune1.equals(mars1));
    }
}