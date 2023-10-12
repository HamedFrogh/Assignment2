package bridge_design_pattern;

// Abstract class 'TV' that represents a television, with a reference to a 'Remote'.
abstract class TV
{
    Remote remote; // Reference to a remote control.

    TV(Remote r)
    {
        this.remote = r;
    }

    // Abstract methods to turn the TV on and off.
    abstract void on();
    abstract void off();
}

// 'Sony' class, a specific TV brand that extends the 'TV' class.
class Sony extends TV
{
    Remote remoteType; // Reference to the type of remote control.

    Sony(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    // Implementation of the 'on' method, prints brand-specific message and delegates the 'on' action to the remote.
    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    // Implementation of the 'off' method, prints brand-specific message and delegates the 'off' action to the remote.
    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// 'Philips' class, another specific TV brand that extends the 'TV' class.
class Philips extends TV
{
    Remote remoteType; // Reference to the type of remote control.

    Philips(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    // Implementation of the 'on' method, prints brand-specific message and delegates the 'on' action to the remote.
    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    // Implementation of the 'off' method, prints brand-specific message and delegates the 'off' action to the remote.
    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// 'Remote' interface that defines methods for turning a TV on and off.
interface Remote
{
    public void on();  // Method to turn the TV on.
    public void off(); // Method to turn the TV off.
}

// 'OldRemote' class, an implementation of the 'Remote' interface for older remote controls.
class OldRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with Old Remote");
    }
}

// 'NewRemote' class, an implementation of the 'Remote' interface for modern remote controls.
class NewRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with New Remote");
    }
}

// The 'BridgePattern' class demonstrates the Bridge Design Pattern.
public class BridgePattern
{
    public static void main(String[] args)
    {
        // Create instances of different TVs and associate them with different remote controls.
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}
