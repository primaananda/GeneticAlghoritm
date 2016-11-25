package GenetikaAlgoritmaTSP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PrimaAnanda-PC
 */

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
    private ArrayList tour = new ArrayList<NodeCity>();
    private double fitness = 0;
    private double distance = 0;

    public Tour() {
        for (int i = 0; i< ManageTour.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    public Tour(ArrayList tour) {
        this.tour = tour;
    }
    
    public void generateIndividual() {
        for (int cityIndeks = 0; cityIndeks < ManageTour.numberOfCities(); cityIndeks++) {
            setCity(cityIndeks, ManageTour.getCity(cityIndeks));
        }
        Collections.shuffle(tour);
    }
    
    public NodeCity getCity(int tourPosition) {
        return (NodeCity)tour.get(tourPosition);
    }
    
    public void setCity(int tourPosition, NodeCity city) {
        tour.set(tourPosition, city);
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/getDistance();
        }
        return fitness;
    }
    
    public int tourSize() {
        return tour.size();
    }
    
    public double getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            NodeCity sourceCity = getCity(0);
            NodeCity destinationCity;
            double travelingTime = 0;
            int start = 0;
            
            //berfungsi untuk menghitung nilai dari node s menuju ke a, s menuju ke b dan s menuju ke c
            for (int cityIndeks = 0; cityIndeks < tourSize(); cityIndeks++) {
                sourceCity = getCity(cityIndeks);
                if (sourceCity.nama.equals("A")) {
                    travelingTime += (3600*6/90);
                    start = cityIndeks;
                    break;
                } else if (sourceCity.nama.equals("B")) {
                    travelingTime += (3600*14/70);
                    start = cityIndeks;
                    break;
                }
                
                
            }
            distance = travelingTime;
        }
        return distance;
    }
    
    public boolean containsCity(NodeCity city) {
        return tour.contains(city);
    }

    @Override
    public String toString() {
        String string = " ";
        for (int i = 0; i < tourSize(); i++) {
            string += getCity(i)+" ";
        }
        return string;
    }
    
    
}
