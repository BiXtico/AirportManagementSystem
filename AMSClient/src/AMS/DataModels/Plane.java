/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AMS.DataModels;

import java.io.Serializable;

/**
 *
 * @author mahmo
 */
public class Plane implements Serializable  {
    private int planeID;
    private int planeCapacity;
    private PlaneSlot slot;

    public Plane() {
    }

    public Plane(int planeID, int planeCapacity, PlaneSlot slot) {
        this.planeID = planeID;
        this.planeCapacity = planeCapacity;
        this.slot = slot;
    }

    public int getPlaneID() {
        return planeID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public int getPlaneCapacity() {
        return planeCapacity;
    }

    public void setPlaneCapacity(int planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

    public PlaneSlot getSlot() {
        return slot;
    }

    public void setSlot(PlaneSlot slot) {
        this.slot = slot;
    }
    
}