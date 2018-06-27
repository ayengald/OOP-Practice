package com.assignment13;

public class SolarSystem {

    public static void main (String[] args) {

        for (Planet p : Planet.values()) {
            String planetName = p.toString();
            planetName = planetName.substring(0,1) + planetName.substring(1).toLowerCase();
            System.out.printf("%s is the %s planet from the Sun.%n", planetName, p.getPosition() + p.getEnding());
        }
    }

}
