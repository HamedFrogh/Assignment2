package decorator_design_pattern;

// 'Dress' interface defines the method to assemble the dress.
interface Dress
{
	public void assemble();
}

// 'BasicDress' class implements the 'Dress' interface with basic dress features.
class BasicDress implements Dress
{
	@Override
	public void assemble()
	{
		System.out.println("Basic Dress Features");
	}
}

// 'DressDecorator' class implements the 'Dress' interface and acts as the base decorator.
class DressDecorator implements Dress
{
	protected Dress dress;

	// Constructor for 'DressDecorator' that takes a 'Dress' object to decorate.
	public DressDecorator(Dress c)
	{
		this.dress = c;
	}

	@Override
	public void assemble()
	{
		this.dress.assemble();
	}
}

// 'CasualDress' class extends 'DressDecorator' to add casual dress features.
class CasualDress extends DressDecorator
{
	public CasualDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble(); // Call the parent's assemble method.
		System.out.println("Adding Casual Dress Features");
	}
}

// 'SportyDress' class extends 'DressDecorator' to add sporty dress features.
class SportyDress extends DressDecorator
{
	public SportyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble(); // Call the parent's assemble method.
		System.out.println("Adding Sporty Dress Features");
	}
}

// 'FancyDress' class extends 'DressDecorator' to add fancy dress features.
class FancyDress extends DressDecorator
{
	public FancyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble(); // Call the parent's assemble method.
		System.out.println("Adding Fancy Dress Features");
	}
}

public class DecoratorPattern
{
	public static void main(String[] args)
	{
		// Create and assemble different dress combinations.
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
