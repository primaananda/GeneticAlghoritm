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
public class NodeCity {
    private int nodex;
    private int nodey;
    String nama;


    public NodeCity(int x, int y, String nama) {
        this.nama = nama;
        this.nodex = x;
        this.nodey = y;
    }    
    
    public int getNodex() {
        return nodex;
    }

    public void setNodex(int nodex) {
        this.nodex = nodex;
    }

    public int getNodey() {
        return nodey;
    }

    public void setNodey(int nodey) {
        this.nodey = nodey;
    }

    @Override
    public String toString() {
        return getNodex()+", "+getNodey();
    }
    
    public double distanceTo(NodeCity nc) {
        int nilainodex = Math.abs(getNodex()-nc.getNodex());
        int nilainodey = Math.abs(getNodey()-nc.getNodey());
        double nodedistance = Math.sqrt((Math.pow(nilainodex, 2)) + (Math.pow(nilainodey, 2)));
        return nodedistance;
    }
}
