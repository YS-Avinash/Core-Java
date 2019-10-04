class ConstructorOverLoading
{
	public ConstructorOverLoading(){
		System.out.println("Hello!");
	}
	public ConstructorOverLoading(String name){
		System.out.println("Hello "+name);
	}

	public static void main(String[] args)
	{
		ConstructorOverLoading cd1 = new ConstructorOverLoading();
		ConstructorOverLoading cd2 = new ConstructorOverLoading("Avinash");
	}
}