/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenetikaAlgoritmaTSP;

/**
 *
 * @author PrimaAnanda-PC
 */
public class Population {
    Tour[] thetour;
    
    public int populationSize() {
        return thetour.length;
    }
    
    public Population(int populationSize, boolean init) {
        thetour = new Tour[populationSize];
        if (init) {
            for (int i = 0; i < populationSize(); i++) {
                Tour newTour = new Tour();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }

    public void saveTour(int i, Tour tour) {
        thetour[i] = tour;
    }

    public Tour getTour(int i) {
        return thetour[i];
    }
    
    public Tour getBestRoute() {
        Tour bestroute = thetour[0];
        for (int i = 0; i < populationSize(); i++) {
           if (bestroute.getFitness() <= getTour(i).getFitness()) {
               bestroute = getTour(i);
           } 
        }
        return bestroute;
    }
}
