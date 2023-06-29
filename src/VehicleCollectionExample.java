import java.util.ArrayList;
import java.util.List;
public class VehicleCollectionExample {
    public static void main(String[] args){
        //Create an objects of Car and Truck
        Car car = new Car(4);
        Truck truck = new Truck(6);

        //Create a collection to hold objects of both class
        List<Object> vehicleCollection = new ArrayList<>();
        vehicleCollection.add(car);
        vehicleCollection.add(truck);

        //Access the numberOfWheels field using getter methods
        for(Object vehicle : vehicleCollection) {
            if(vehicle instanceof Car) {
                Car carObj = (Car) vehicle;
                System.out.println("Car wheels: " + carObj.getNumberOfWheels());
            }else if(vehicle instanceof Truck){
                Truck truckObj = (Truck) vehicle;
                System.out.println("Truck wheels: " + truckObj.getNumbersOfWheels());
            }
        }
    }
}
