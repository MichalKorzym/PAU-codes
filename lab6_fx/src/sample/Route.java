package sample;

import java.util.ArrayList;
import java.util.List;

public class Route {
   public int getNumberOfStops() {
      return numberOfStops;
   }

   public List<TrainStation> getStopsList() {
      return stopsList;
   }

   public Route(int numberOfStops, List<TrainStation> stopsList) {
      this.numberOfStops = numberOfStops;
      this.stopsList = stopsList;
   }

   private int numberOfStops;
   private List<TrainStation> stopsList=new ArrayList<TrainStation>();


}
