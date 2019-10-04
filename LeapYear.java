import java.io.*;
class LeapYear
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a year:");
		int year = Integer.parseInt(br.readLine());
		if(year%400==0)
			System.out.println(year+" is Leap Year.");	
		else if(year%100==0)
			System.out.println(year+" is Not Leap Year.");
		else if(year%4==0)
			System.out.println(year+" is Leap Year.");
		else
			System.out.println(year+" is Not Leap Year.");
	}
}