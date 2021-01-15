
package AMS.ResevationSubSystem;

import AMS.DB_SC_Manager;
import AMS.FlightManagementSubSystem.Flight;
import java.util.ArrayList;


public class SearchByAirline implements SearchStrategy {

    @Override
    public String searchMethod(String Airline) {
        ArrayList<Flight> FF = new ArrayList<>();
        for(Flight f:DB_SC_Manager.getFlights_S()){
            if(f.getAirline().equals(Airline)){
                FF.add(f);
            }
        }
       String s = "";
        for(Flight F:FF){
            s+= F.getAirline() + F.getDestination();
        }
        return s;
    }
    
}
