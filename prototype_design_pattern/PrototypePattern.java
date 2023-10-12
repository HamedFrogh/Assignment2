package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// 'Vehicle' class represents the prototype for creating vehicle objects.
class Vehicle implements Cloneable
{
  private List<String> vehicleList;

  public Vehicle()
  {
    this.vehicleList = new ArrayList<String>(); // Initialize an empty list to store vehicle names.
  }

  public Vehicle(List<String> list)
  {
    this.vehicleList = list; // Initialize the list of vehicles with provided data.
  }

  // Method to insert initial vehicle data into the list.
  public void insertData()
  {
    vehicleList.add("Honda Amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  // Method to get the list of vehicles.
  public List<String> getVehicleList()
  {
    return this.vehicleList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException
  {
    List<String> tempList = new ArrayList<String>();

    for(String s : this.getVehicleList())
    {
      tempList.add(s); // Create a deep copy of the vehicle list.
    }

    return new Vehicle(tempList); // Create a new 'Vehicle' object with the copied list.
  }
}

public class PrototypePattern
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    Vehicle a = new Vehicle(); // Create a prototype 'Vehicle' object.
    a.insertData(); // Insert data into the prototype object.

    Vehicle b = (Vehicle) a.clone(); // Clone the prototype to create a new 'Vehicle' object.
    List<String> list = b.getVehicleList(); // Get the list from the cloned object.
    list.add("Honda New Amaze"); // Add a new vehicle to the cloned list.

    System.out.println(a.getVehicleList()); // Display the original list.
    System.out.println(list); // Display the modified cloned list.

    b.getVehicleList().remove("Audi A4"); // Remove a vehicle from the cloned list.
    System.out.println(list); // Display the modified cloned list.
    System.out.println(a.getVehicleList()); // Display the original list, which remains unchanged.
  }
}
