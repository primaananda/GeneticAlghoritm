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
public class Main {
     public static void main(String[] args) {

        NodeCity S = new NodeCity(1, 6, "S");
        ManageTour.addNodeCity(S);
        NodeCity A = new NodeCity(4, 10, "A");
        ManageTour.addNodeCity(A);
        NodeCity B = new NodeCity(4, 6, "B");
        ManageTour.addNodeCity(B);
        NodeCity C = new NodeCity(4, 2, "C");
        ManageTour.addNodeCity(C);
        NodeCity D = new NodeCity(16, 10, "D");
        ManageTour.addNodeCity(D);
        NodeCity E = new NodeCity(16, 6, "E");
        ManageTour.addNodeCity(E);
        NodeCity F = new NodeCity(16, 2, "F");
        ManageTour.addNodeCity(F);
        NodeCity G = new NodeCity(19, 6, "G");
        ManageTour.addNodeCity(G);
        
        Population population = new Population(10, true);
        System.out.println("Rute Sebelum Evolusi Populasi : ");
        for(int i = 0; i < population.getBestRoute().tourSize(); i++){
            System.out.print(population.getBestRoute().getCity(i).nama+" ");
        }
//        System.out.println("");
//        System.out.println(A.distanceTo(D));
//        System.out.println("");
//        
//         for (int i = 0; i < population.populationSize(); i++) {
//             System.out.println(population.getTour(i)+" ");
//         }
        
     }
}
