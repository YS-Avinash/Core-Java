class ConsDemo
{
	public static ConsDemo obj = null;
	private ConsDemo()
	{
		System.out.println("Private Constructor");
	}
	public static ConsDemo initiateObject()
	{
		if(obj==null)
		{
			obj=new ConsDemo();
			return obj;
		}
		return obj;
	}
}
class PrivateConstructorDemo
{
	public static void main(String[] args)
	{
		ConsDemo object = null;
		object = ConsDemo.initiateObject();
		ConsDemo obj=ConsDemo.initiateObject();
		ConsDemo obj1=ConsDemo.initiateObject();	
	}
}
	
		