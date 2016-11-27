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
public class Algorithm {
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    
    private static Tour tournamentSelection(Population population) {
        Population tournament = new Population(tournamentSize, false);
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * population.populationSize());
            tournament.saveTour(i, population.getTour(randomId));
        }
        Tour bestroute = tournament.getBestRoute();
        return bestroute;
    }
    
    public static Tour crossover(Tour parent1, Tour parent2) {
        Tour child = new Tour();

        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        for (int i = 0; i < child.tourSize(); i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            }
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }
        
        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.containsCity(parent2.getCity(i))) {
                for (int ii = 0; ii < child.tourSize(); ii++) {
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }
    
    private static void mutate(Tour tour) {
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            if(Math.random() < mutationRate){
                int tourPos2 = (int) (tour.tourSize() * Math.random());
                NodeCity city1 = tour.getCity(tourPos1);
                NodeCity city2 = tour.getCity(tourPos2);

                tour.setCity(tourPos2, city1);
                tour.setCity(tourPos1, city2);
            }
        }
    }
    
    public static Population evolvePopulation(Population population) {
        Population newPopulation = new Population(population.populationSize(), false);
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveTour(0, population.getBestRoute());
            elitismOffset = 1;
        }
        
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            Tour parent1 = tournamentSelection(population);
            Tour parent2 = tournamentSelection(population);
            
            Tour child = crossover(parent1, parent2);
            newPopulation.saveTour(i, child);
        }
        
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }
        return newPopulation;
    }
}
