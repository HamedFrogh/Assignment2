package singleton_design_pattern;

// Singleton with eager initialization
class SingletonEager
{
  private static SingletonEager instance = new SingletonEager();

  // Private constructor to prevent external instantiation
  private SingletonEager()
  {

  }

  // Method to get the instance
  public static SingletonEager getInstance()
  {
    return instance;
  }
}

// Singleton with lazy initialization
class Singleton
{
  private static Singleton instance;

  // Private constructor to prevent external instantiation
  private Singleton()
  {

  }

  // Method to get the instance; creates the instance on first access
  public static Singleton getInstance()
  {
    if(instance == null)
    {
      instance = new Singleton();
    }
    return instance;
  }
}

// Singleton with synchronized method
class SingletonSynchronizedMethod
{
  private static SingletonSynchronizedMethod instance;

  // Private constructor to prevent external instantiation
  private SingletonSynchronizedMethod()
  {

  }

  // Synchronized method to ensure thread safety during instance creation
  public static synchronized SingletonSynchronizedMethod getInstance()
  {
    if(instance == null)
    {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// Singleton with double-checked locking
class SingletonSynchronized
{
  private static SingletonSynchronized instance;

  // Private constructor to prevent external instantiation
  private SingletonSynchronized()
  {

  }

  // Method with double-checked locking for efficient thread safety
  public static SingletonSynchronized getInstance()
  {
    if(instance == null)
    {
      synchronized (SingletonSynchronized.class)
      {
        if(instance == null)
        {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern
{
  public static void main(String[] args)
  {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
