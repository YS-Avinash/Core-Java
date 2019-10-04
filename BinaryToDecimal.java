import static java.lang.System.out;
class BinaryToDecimal
{
	public static void main(String[] args)
	{
		
		out.print("Enter Binary Number:");
		int x = new java.util.Scanner(System.in).nextInt();
		int sum = 0;
		for(int i=0;x!=0;i++){
			if((x%10)==1)	
				sum+=Math.pow(2,i);
			x/=10;
		}
		out.print("Decimal value is "+sum);
	}
}