package builder_design_pattern;

// Class 'Vehicle' represents a vehicle with various properties.
class Vehicle
{
  private String engine; // Engine type of the vehicle.
  private int wheel;     // Number of wheels on the vehicle.
  private int airbags;   // Number of airbags in the vehicle.

  public String getEngine()
  {
    return this.engine;  // Getter method to retrieve the engine type.
  }

  public int getWheel()
  {
    return this.wheel;  // Getter method to retrieve the number of wheels.
  }

  public int getAirbags()
  {
    return this.airbags; // Getter method to retrieve the number of airbags.
  }

  // Private constructor for 'Vehicle' that takes a 'VehicleBuilder' as an argument.
  private Vehicle(VehicleBuilder builder)
  {
    this.engine = builder.engine;   // Initialize the engine type from the builder.
    this.wheel = builder.wheel;     // Initialize the number of wheels from the builder.
    this.airbags = builder.airbags; // Initialize the number of airbags from the builder.
  }

  // 'VehicleBuilder' is a static inner class responsible for building 'Vehicle' objects.
  public static class VehicleBuilder
  {
    private String engine; // Engine type of the vehicle.
    private int wheel;     // Number of wheels on the vehicle.
    private int airbags;   // Number of airbags in the vehicle.

    // Constructor for 'VehicleBuilder' that requires engine type and the number of wheels.
    public VehicleBuilder(String engine, int wheel)
    {
      this.engine = engine; // Initialize the engine type.
      this.wheel = wheel;   // Initialize the number of wheels.
    }

    // Method to set the number of airbags and return the builder for method chaining.
    public VehicleBuilder setAirbags(int airbags)
    {
      this.airbags = airbags; // Set the number of airbags.
      return this;
    }

    // Build method creates a new 'Vehicle' object using the current 'VehicleBuilder'.
    public Vehicle build()
    {
      return new Vehicle(this);
    }
  }
}

// The 'BuilderPattern' class demonstrates the use of the builder design pattern.
public class BuilderPattern
{
  public static void main(String[] args)
  {
    // Create a car using the 'VehicleBuilder' with specified properties and airbags.
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

    // Create a bike using the 'VehicleBuilder' with specified properties (no airbags).
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

    // Print the properties of the car and bike.
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());

    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags()); // This will print 0 for the bike since no airbags were specified.
  }
}
