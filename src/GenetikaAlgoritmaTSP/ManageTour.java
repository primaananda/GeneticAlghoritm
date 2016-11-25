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

public class ManageTour   {
    private static ArrayList destinationCities = new ArrayList<NodeCity>();
    
    public static void addNodeCity(NodeCity city) {
        destinationCities.add(city);
    }
    
    public static NodeCity getCity(int indeks) {
        return (NodeCity)destinationCities.get(indeks);
    }
    
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
