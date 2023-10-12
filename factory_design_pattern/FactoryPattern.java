package factory_design_pattern;

// 'Vehicle' abstract class defines the common structure for vehicles.
abstract class Vehicle
{
	public abstract int getWheel(); // Abstract method to get the number of wheels for a vehicle.
	public String toString()
	{
		return "Wheel: " + this.getWheel(); // Returns a string representation with the number of wheels.
	}
}

// 'Car' class represents a type of vehicle, extending the 'Vehicle' abstract class.
class Car extends Vehicle
{
	int wheel; // Number of wheels for the car.
	Car(int wheel)
	{
		this.wheel = wheel; // Initialize the number of wheels for the car.
	}

	@Override
	public int getWheel()
	{
		return this.wheel; // Return the number of wheels for the car.
	}
}

// 'Bike' class represents another type of vehicle, extending the 'Vehicle' abstract class.
class Bike extends Vehicle
{
	int wheel; // Number of wheels for the bike.
	Bike(int wheel)
	{
		this.wheel = wheel; // Initialize the number of wheels for the bike.
	}

	@Override
	public int getWheel()
	{
		return this.wheel; // Return the number of wheels for the bike.
	}
}

// 'VehicleFactory' class provides a method to create instances of different vehicle types.
class VehicleFactory
{
	public static Vehicle getInstance(String type, int wheel)
	{
		if(type == "car")
		{
			return new Car(wheel); // Create and return a car with the specified number of wheels.
		}
		else if(type == "bike")
		{
			return new Bike(wheel); // Create and return a bike with the specified number of wheels.
		}
		return null; // Return null for unsupported vehicle types.
	}
}

// The 'FactoryPattern' class demonstrates the use of the Factory Design Pattern.
public class FactoryPattern
{
	public static void main(String[] args)
	{
		// Create a car and display the number of wheels.
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		// Create a bike and display the number of wheels.
		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
