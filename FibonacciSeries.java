import java.io.*;
class FibonacciSeries
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter n:");
		int n = Integer.parseInt(br.readLine());
		if(n<=0)
			System.out.println("Sorry! please enter +ve no. (>1).");
		else{
			int c,a=0,b=1;
			for(int i=0;i<n;i++){
				if(i==0)
					c=a;
				else if(i==1)
					c=b;
				else{
					c=a+b;
					a=b;
					b=c;
				}
			System.out.print(c+" ");
			}
		}
	}
}