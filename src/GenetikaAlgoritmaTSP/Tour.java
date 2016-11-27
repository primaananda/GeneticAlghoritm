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
            int start1 = 0;
            int start2 = 0;
            
//            for (int cityIndeks = 0; cityIndeks < tourSize(); cityIndeks++) {
//                sourceCity = getCity(cityIndeks);
//                if (sourceCity.nama.equals("S")) {
//                    if (sourceCity.nama.equals("A")) {
//                        if (sourceCity.nama.equals("D")) {
//                            if (sourceCity.nama.equals("G")) {
//                                travelingTime += (3600*6/90);
//                            } else if (sourceCity.nama.equals("E")) {
//                                if (sourceCity.nama.equals("G")) {
//                                    
//                                }else if (sourceCity.nama.equals("F")) {
//                                    if (sourceCity.nama.equals("G")) {
//                                        
//                                    }
//                                }
//                            }
//                        } else if (sourceCity.nama.equals("B")) {
//                            
//                        }
//                    }
//                }
//            }
            
            //berfungsi untuk menghitung nilai dari node s menuju ke a, s menuju ke b dan s menuju ke c
            for (int cityIndeks = 0; cityIndeks < tourSize(); cityIndeks++) {
                sourceCity = getCity(cityIndeks);
                if (sourceCity.nama.equals("A")) {
                    travelingTime += (3600*6/90);
                    start1 = cityIndeks;
                    break;
                } else if (sourceCity.nama.equals("B")) {
                    travelingTime += (3600*14/70);
                    start1 = cityIndeks;
                    break;
                } else if (sourceCity.nama.equals("C")) {
                    travelingTime += (3600*10/60);
                    start1 = cityIndeks;
                    break;
                }
            }
            
            for (int cityIndeks = start1+1; cityIndeks < tourSize(); cityIndeks++) {
                destinationCity = getCity(cityIndeks);
                if(sourceCity.nama.equals("A")) {
                    if (destinationCity.nama.equals("B")) {
                        travelingTime += (3600*4/40);
                        sourceCity = getCity(cityIndeks);
                        start2 = cityIndeks;
                        break;
                    } else if (destinationCity.nama.equals("D")) {
                        travelingTime += (3600*16/40);
                        sourceCity = getCity(cityIndeks);
                        start2 = cityIndeks;
                        break;
                    } else {
                        travelingTime += 0;
                        start2 = cityIndeks;
                        break;
                    }
                } else if (sourceCity.nama.equals("B")) {
                    if (destinationCity.nama.equals("A")) {
                        travelingTime += (3600*4/40);
                        sourceCity = getCity(cityIndeks);
                        start2 = cityIndeks;
                        break;
                    } else if (destinationCity.nama.equals("C")) {
                        travelingTime += (3600*4/80);
                        sourceCity = getCity(cityIndeks);
                        start2 = cityIndeks;
                        break;
                    } else if (destinationCity.nama.equals("E")) {
                        travelingTime += (3600*15/60);
                        sourceCity = getCity(cityIndeks);
                        start2 = cityIndeks;
                        break;
                    } else {
                        travelingTime += 0;
                    }
                    start2 = cityIndeks;
                } else if(sourceCity.nama.equals("C")) {
                    if (destinationCity.nama.equals("B")) {
                        travelingTime += (3600*4/40);
                        sourceCity = getCity(cityIndeks);
                        start2 = cityIndeks;
                        break;
                    } else if (destinationCity.nama.equals("F")) {
                        travelingTime += (3600*12/40);
                        sourceCity = getCity(cityIndeks);
                        start2 = cityIndeks;
                        break;
                    } else {
                        travelingTime += 0;
                        start2 = cityIndeks;
                        break;
                    }
                } else if(sourceCity.nama.equals("D")) {
                        travelingTime += (3600*9/70);
                        break;
                    }else if(sourceCity.nama.equals("E")){
                        travelingTime += (3600*9/80);
                        break;
                    }else if(sourceCity.nama.equals("F")){
                        travelingTime += (3600*6/40);
                        break;
                }
            }
            
            
            
            if (sourceCity.nama.equals("A")) {
                travelingTime += (3600*16/40);
                travelingTime += (3600*9/70);
            }else if (sourceCity.nama.equals("B")) {
                travelingTime += (3600*15/60);
                travelingTime +=  (3600*9/80);
            }else if (sourceCity.nama.equals("C")) {
                travelingTime +=  (3600*12/40);
                travelingTime +=  (3600*6/40);
            }
            
//            for (int cityIndeks = start2+1; cityIndeks < tourSize(); cityIndeks++) {
//                destinationCity = getCity(cityIndeks);
//                if (sourceCity.nama.equals("D")) {
//                    if (destinationCity.nama.equals("G")) {
//                        travelingTime += (3600*9/70);
//                    } else if (destinationCity.nama.equals("E")) {
//                        travelingTime += (3600*4/120);
//                    } else {
//                        travelingTime += 0;
//                    }
//                } else if (sourceCity.nama.equals("E")) {
//                    if (destinationCity.nama.equals("G")) {
//                        travelingTime += (3600*9/70);
//                    } else if (destinationCity.nama.equals("D")) {
//                        travelingTime += (3600*4/120);
//                    } else if (destinationCity.nama.equals("F")) {
//                        travelingTime += (3600*4/70);
//                    } else {
//                        travelingTime += 0;
//                    }
//                } else if (sourceCity.nama.equals("F")) {
//                    if (destinationCity.nama.equals("G")) {
//                        travelingTime += (3600*9/70);
//                    } else if (destinationCity.nama.equals("E")) {
//                        travelingTime += (3600*4/120);
//                    } else {
//                        travelingTime += 0;
//                    }
//                }
//            }
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
