package facade_design_pattern;

import java.sql.Driver;

// 'Firefox' class provides methods related to the Firefox browser.
class Firefox
{
    public static Driver getFirefoxDriver()
    {
        return null; // Returns a Firefox driver instance (not implemented).
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

// 'Chrome' class provides methods related to the Chrome browser.
class Chrome
{
    public static Driver getChromeDriver()
    {
        return null; // Returns a Chrome driver instance (not implemented).
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

// 'WebExplorerHelperFacade' class acts as a facade to simplify using different browsers for report generation.
class WebExplorerHelperFacade
{
    public static void generateReports(String explorer, String report, String test)
    {
        Driver driver = null;
        switch(explorer)
        {
            case "firefox":
                driver = Firefox.getFirefoxDriver(); // Get a Firefox driver instance.
                switch(report)
                {
                    case "html":
                        Firefox.generateHTMLReport(test, driver); // Generate an HTML report using the Firefox driver.
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver); // Generate a JUNIT report using the Firefox driver.
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver(); // Get a Chrome driver instance.
                switch(report)
                {
                    case "html":
                        Chrome.generateHTMLReport(test, driver); // Generate an HTML report using the Chrome driver.
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver); // Generate a JUNIT report using the Chrome driver.
                        break;
                }
        }
    }
}

// The 'FacadePattern' class demonstrates the use of the Facade Design Pattern.
public class FacadePattern
{
    public static void main(String[] args)
    {
        String test = "CheckElementPresent";

        // Generate different reports for different browsers and report types using the facade.
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
