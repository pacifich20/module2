package com.pacifich20.module2.v1;
import java.util.Objects;

public class Planet {
    //variables
    private String designation;
    private double massKg;
    private double orbitEarthYears;
    private PlanetType type;


    /**
     * creates planet using given designation and type
     * @param designation unique identifier for the planet.
     * @param type type of planet
     */
    public Planet(String designation, PlanetType type) {
        this.designation = designation;
        this.type = type;

    }

    /**
     * creates planet using given designation, mass, orbit years and type
     * @param designation unique identifier for the planet
     * @param massKg mass of planet in kg
     * @param orbitEarthYears amount of time it takes for planet to orbit earth in years
     * @param type type of planet
     */
    public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
        this.designation = designation;
        this.massKg = massKg;
        this.orbitEarthYears = orbitEarthYears;
        this.type = type;

    }

    /**
     * checks if two planet objects are equal by comparing designations
     * @param o object to compare with current planet
     * @return true if  equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        } else if (o == null || getClass() != o.getClass()){
            return false;
        } else {
            Planet planet = (Planet) o;
            return Objects.equals(designation, planet.designation);
        }
    }

    /**
     * generates hash code based designation of planet
     * @return hash code for the planet
     */
    @Override
    public int hashCode() {
        return designation.hashCode();
    }

    /**
     * converts planet information to string format for printing
     * @return planet information in string format
     */
    @Override
    public String toString() {
        return "Planet: Designation = " + designation + ", Type = " + type;
    }
}