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
    private int distance = 0;

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
    
    public double getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            for (int cityIndeks = 0; cityIndeks < tourSize(); cityIndeks++) {
                NodeCity city = getCity(cityIndeks);
                NodeCity desNodeCity;
                
                
            }
        }
    }
}
