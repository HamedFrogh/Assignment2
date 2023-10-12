package proxy_design_pattern;

// Interface for executing database queries
interface DatabaseExecuter
{
	public void executeDatabase(String query) throws Exception;
}

// Implementation of the DatabaseExecuter interface
class DatabaseExecuterImpl implements DatabaseExecuter
{
	@Override
	public void executeDatabase(String query) throws Exception
	{
		System.out.println("Going to execute Query: " + query);
	}
}

// Proxy class that controls access to the database execution
class DatabaseExecuterProxy implements DatabaseExecuter
{
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd)
	{
		if(name == "Admin" && passwd == "Admin@123")
		{
			ifAdmin = true; // Check if the user is an admin.
		}
		dbExecuter = new DatabaseExecuterImpl(); // Create an instance of the actual database executer.
	}

	@Override
	public void executeDatabase(String query) throws Exception
	{
		if(ifAdmin)
		{
			dbExecuter.executeDatabase(query); // If the user is an admin, execute the query directly.
		}
		else
		{
			if(query.equals("DELETE"))
			{
				throw new Exception("DELETE not allowed for non-admin user"); // Prevent non-admin users from executing DELETE queries.
			}
			else
			{
				dbExecuter.executeDatabase(query); // Execute other queries for non-admin users.
			}
		}
	}
}

public class ProxyPattern
{
	public static void main(String[] args) throws Exception
	{
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE"); // Try to execute a query with a misspelled command.

		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE"); // Try to execute a DELETE query as a non-admin user (will throw an exception).

		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE"); // Admin user executing a DELETE query (allowed).
	}
}
