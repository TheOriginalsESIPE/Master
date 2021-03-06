package Server.serialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Server.dto.BreakdownDTO;
import Server.dto.IndicatorDTO;
import Server.dto.ParkingDTO;
import Server.dto.VehicleDTO;
import Server.dto.VisitingMotifDTO;
import Server.dto.Vehicle_warehouseDTO;
import Server.dto.Vehicle_warehouseDTOL;

import java.util.List;

/**
 * Created by tearsyu on 10/05/17.
 */
public class SerializationGson {
	
    public String serialGeneric(Object o){
        Gson gson = new Gson();
        java.lang.reflect.Type obj = new TypeToken<List<IndicatorDTO>>(){}.getType();
        String parseString = gson.toJson(o, obj);
        return parseString;
    }
    
    
    public String serialGenericBreakdown(Object o){
        Gson gson = new Gson();
        java.lang.reflect.Type obj = new TypeToken<List<BreakdownDTO>>(){}.getType();
        String parseString = gson.toJson(o, obj);
        return parseString;
    }
    
    public String serialGenericVehicle(Object o){
        Gson gson = new Gson();
        java.lang.reflect.Type obj = new TypeToken<List<VehicleDTO>>(){}.getType();
        String parseString = gson.toJson(o, obj);
        return parseString;
    }
    
    public String serialGenericMotif(Object o){
        Gson gson = new Gson();
        java.lang.reflect.Type obj = new TypeToken<List<VisitingMotifDTO>>(){}.getType();
        String parseString = gson.toJson(o, obj);
        return parseString;
    }
    
    public String serialGenericParking(Object o){
        Gson gson = new Gson();
        java.lang.reflect.Type obj = new TypeToken<List<ParkingDTO>>(){}.getType();
        String parseString = gson.toJson(o, obj);
        return parseString;
    }
    
    public String serialGenericVehicle_warehouseDTOL(Object o){
      	 Gson gson = new Gson();
           java.lang.reflect.Type obj = new TypeToken<List<Vehicle_warehouseDTOL>>(){}.getType();
           String parseString = gson.toJson(o, obj);
           return parseString;
      }

}
