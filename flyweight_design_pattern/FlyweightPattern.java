package flyweight_design_pattern;

import java.util.HashMap;
import java.util.Random;

// 'Employee' interface defines the methods that concrete employee classes must implement.
interface Employee
{
  public void assignSkill(String skill); // Method to assign a skill to an employee.
  public void task(); // Method to perform a task.
}

// 'Developer' class implements the 'Employee' interface and represents a developer.
class Developer implements Employee
{

  private final String JOB;
  private String skill;

  public Developer()
  {
    JOB = "Fix the issue"; // Initialize the job for a developer.
  }

  @Override
  public void assignSkill(String skill)
  {
    this.skill = skill; // Assign a skill to the developer.
  }

  @Override
  public void task()
  {
    System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
  }
}

// 'Tester' class implements the 'Employee' interface and represents a tester.
class Tester implements Employee
{
  private final String JOB;
  private String skill;
  public Tester()
  {
    JOB = "Test the issue"; // Initialize the job for a tester.
  }

  @Override
  public void assignSkill(String skill)
  {
    this.skill = skill; // Assign a skill to the tester.
  }

  @Override
  public void task()
  {
    System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
  }
}

// 'EmployeeFactory' class creates and manages instances of employee objects.
class EmployeeFactory
{
  private static HashMap<String, Employee> m = new HashMap<String, Employee>();

  public static Employee getEmployee(String type)
  {
    Employee p = null;
    if(m.get(type) != null)
    {
      p = m.get(type); // Retrieve an existing employee instance from the map.
    }
    else
    {
      switch(type)
      {
        case "Developer":
          System.out.println("Developer Created");
          p = new Developer(); // Create a new developer instance.
          break;
        case "Tester":
          System.out.println("Tester Created");
          p = new Tester(); // Create a new tester instance.
          break;
        default:
          System.out.println("No Such Employee");
      }

      m.put(type, p); // Store the newly created instance in the map for reuse.
    }
    return p; // Return the employee instance.
  }
}

// 'FlyweightPattern' class demonstrates the Flyweight Design Pattern.
public class FlyweightPattern
{
  private static String employeeType[] = {"Developer", "Tester"};
  private static String skills[] = {"Java", "C++", ".Net", "Python"};
  public static void main(String[] args)
  {
    for(int i = 0; i < 10; i++)
    {
      Employee e = EmployeeFactory.getEmployee(getRandEmployee());
      e.assignSkill(getRandSkill()); // Assign a random skill to the employee.
      e.task(); // Perform a task using the assigned skill.
    }
  }

  public static String getRandEmployee()
  {
    Random r = new Random();
    int randInt = r.nextInt(employeeType.length);
    return employeeType[randInt]; // Get a random employee type.
  }

  public static String getRandSkill()
  {
    Random r = new Random();
    int randInt = r.nextInt(skills.length);
    return skills[randInt]; // Get a random skill.
  }
}
