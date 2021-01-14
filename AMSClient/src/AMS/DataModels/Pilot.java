
package AMS.DataModels;

public class Pilot {
    private int pilotID;
    private String name;
    private boolean isAvailable;

    public Pilot(int pilotID, String name, boolean isAvailable) {
        this.pilotID = pilotID;
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public Pilot() {
    }

    public int getPilotID() {
        return pilotID;
    }

    public void setPilotID(int pilotID) {
        this.pilotID = pilotID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
