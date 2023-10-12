package adapter_design_pattern;

// Define an interface called 'WebDriver' that represents the common methods for different web drivers.
interface WebDriver
{
	public void getElement();    // Method to get an element.
	public void selectElement(); // Method to select an element.
}

// Implement the 'ChromeDriver' class that conforms to the 'WebDriver' interface.
class ChromeDriver implements WebDriver
{
	@Override
	public void getElement()
	{
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement()
	{
		System.out.println("Select element from ChromeDriver");
	}
}

// Create a class 'IEDriver' that is not part of the 'WebDriver' interface but will be adapted later.
class IEDriver
{
	public void findElement()
	{
		System.out.println("Find element from IEDriver");
	}

	public void clickElement()
	{
		System.out.println("Click element from IEDriver");
	}
}

// Implement the 'WebDriverAdapter' class that adapts 'IEDriver' to the 'WebDriver' interface.
class WebDriverAdapter implements WebDriver
{
	IEDriver ieDriver;

	public WebDriverAdapter(IEDriver ieDriver)
	{
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement()
	{
		ieDriver.findElement();
	}

	@Override
	public void selectElement()
	{
		ieDriver.clickElement();
	}
}

// The main class 'AdapterPattern' demonstrates the usage of the adapter design pattern.
public class AdapterPattern
{
	public static void main(String[] args)
	{
		// Create an instance of 'ChromeDriver'.
		ChromeDriver a = new ChromeDriver();
		a.getElement();    // Call the 'getElement' method of 'ChromeDriver'.
		a.selectElement(); // Call the 'selectElement' method of 'ChromeDriver'.

		// Create an instance of 'IEDriver'.
		IEDriver e = new IEDriver();
		e.findElement();    // Call the 'findElement' method of 'IEDriver'.
		e.clickElement();   // Call the 'clickElement' method of 'IEDriver'.

		// Create a 'WebDriver' object that adapts 'IEDriver' using 'WebDriverAdapter'.
		WebDriver wID = new WebDriverAdapter(e);
		wID.getElement();    // Calls the 'getElement' method through the adapter.
		wID.selectElement(); // Calls the 'selectElement' method through the adapter.
	}
}
