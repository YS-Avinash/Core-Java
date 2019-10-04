import java.util.Scanner;
class ElectricityBil
{
	public static void main(String[] args)
	{
		System.out.print("Enter Units Consumed:");
		int units = new Scanner(System.in).nextInt();
		double sum=0;
		if(units<=100)
			sum=units*1;
		else if(units<=200)
			sum=(units-100)*2+100;
		else if(units<=300)
			sum=(units-200)*3+200+100;
		else if(units<=500)
			sum=(units-300)*4+100+200+300;
		else
			sum=(units-500)*5+100+200+300+800;
		
		System.out.println("----------------------");
		System.out.println("Electricity Bill");
		System.out.println("----------------------");
		System.out.println("Units charge : "+sum);
		System.out.println("Meter charge : 50");		
		double tax = 0.1 *sum;
		System.out.println("Tax          : "+tax);
		sum=sum+tax+50;
		System.out.println("----------------------");
		System.out.println("Total        : "+sum);
	}
}
		
		