package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// 'Subject' interface defines methods for registering, unregistering, and notifying observers.
interface Subject
{
    void register(Observer obj); // Register an observer.
    void unregister(Observer obj); // Unregister an observer.
    void notifyObservers(); // Notify all registered observers.
}

// 'DeliveryData' class implements the 'Subject' interface to manage location updates and observers.
class DeliveryData implements Subject
{
    private List<Observer> observers; // List to store registered observers.
    private String location; // Current delivery location.

    public DeliveryData()
    {
        this.observers = new ArrayList<>(); // Initialize the list of observers.
    }

    @Override
    public void register(Observer obj)
    {
        observers.add(obj); // Register an observer.
    }

    @Override
    public void unregister(Observer obj)
    {
        observers.remove(obj); // Unregister an observer.
    }

    @Override
    public void notifyObservers()
    {
        for (Observer obj : observers)
        {
            obj.update(location); // Notify each observer with the current location.
        }
    }

    public void locationChanged()
    {
        this.location = getLocation(); // Simulate a location change.
        notifyObservers(); // Notify all registered observers.
    }

    public String getLocation()
    {
        return "YPlace"; // Get the current location (simulated).
    }
}

// 'Observer' interface defines the update method for observers.
interface Observer
{
    void update(String location); // Update method to be implemented by observers.
}

// 'Seller' class implements the 'Observer' interface for sellers.
class Seller implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location; // Update the location.
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// 'User' class implements the 'Observer' interface for users.
class User implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location; // Update the location.
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// 'DeliveryWarehouseCenter' class implements the 'Observer' interface for warehouse centers.
class DeliveryWarehouseCenter implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location; // Update the location.
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

// 'ObserverPattern' class demonstrates the Observer Design Pattern.
public class ObserverPattern
{
    public static void main(String[] args)
    {
        DeliveryData topic = new DeliveryData(); // Create a subject.

        Observer obj1 = new Seller(); // Create a seller observer.
        Observer obj2 = new User();   // Create a user observer.
        Observer obj3 = new DeliveryWarehouseCenter(); // Create a warehouse center observer.

        topic.register(obj1); // Register the seller observer.
        topic.register(obj2); // Register the user observer.
        topic.register(obj3); // Register the warehouse center observer.

        topic.locationChanged(); // Simulate a location change and notify observers.
        topic.unregister(obj3);  // Unregister the warehouse center observer.

        System.out.println();
        topic.locationChanged(); // Simulate another location change and notify remaining observers.
    }
}
