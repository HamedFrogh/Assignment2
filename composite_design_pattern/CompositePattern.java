package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Abstract class 'Account' represents a generic bank account.
abstract class Account
{
  public abstract float getBalance(); // Abstract method to get the account balance.
}

// 'DepositeAccount' class represents a deposit account and extends 'Account'.
class DepositeAccount extends Account
{
  private String accountNo;     // Account number for the deposit account.
  private float accountBalance; // Current balance of the deposit account.

  public DepositeAccount(String accountNo, float accountBalance)
  {
    super();                  // Call the constructor of the superclass.
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;  // Return the balance of the deposit account.
  }
}

// 'SavingAccount' class represents a savings account and extends 'Account'.
class SavingAccount extends Account
{
  private String accountNo;     // Account number for the savings account.
  private float accountBalance; // Current balance of the savings account.

  public SavingAccount(String accountNo, float accountBalance)
  {
    super();                  // Call the constructor of the superclass.
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance()
  {
    return accountBalance;  // Return the balance of the savings account.
  }
}

// 'CompositeAccount' class represents a composite account, which is a collection of multiple accounts.
class CompositeAccount extends Account
{
  private float totalBalance;           // Total balance of all accounts in the composite.
  private List<Account> accountList = new ArrayList<Account>(); // List of accounts in the composite.

  public float getBalance()
  {
    totalBalance = 0;
    for (Account acc : accountList)
    {
      totalBalance = totalBalance + acc.getBalance(); // Calculate the total balance by summing individual account balances.
    }
    return totalBalance; // Return the total balance of the composite account.
  }

  public void addAccount(Account acc)
  {
    accountList.add(acc); // Add an account to the composite.
  }

  public void removeAccount(Account acc)
  {
    accountList.remove(acc); // Remove an account from the composite.
  }
}

// The 'CompositePattern' class demonstrates the Composite Design Pattern.
public class CompositePattern
{
  public static void main(String[] args)
  {
    CompositeAccount component = new CompositeAccount(); // Create a composite account.

    component.addAccount(new DepositeAccount("DA001", 100)); // Add deposit accounts.
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));  // Add a savings account.

    float totalBalance = component.getBalance(); // Calculate the total balance of the composite.
    System.out.println("Total Balance : " + totalBalance); // Print the total balance.
  }
}
