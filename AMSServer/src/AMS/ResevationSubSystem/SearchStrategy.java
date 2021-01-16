
package AMS.ResevationSubSystem;

import AMS.FlightManagementSubSystem.Flight;
import java.util.ArrayList;

public interface SearchStrategy {
    
     public ArrayList<Flight> searchMethod(String Searchable);
}
