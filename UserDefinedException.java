class UserDefinedException extends Exception
{
	static int accNo[] = {101,102,103,104,105};
	static String names[] = {"mahi","kuli","cheeku","viru","pandu"};
	static double bal[] = {5132.12,1001.54,2013.4,991.32,3000.12};
	UserDefinedException(){super("Poor Balance");}
	UserDefinedException(String msg){super(msg);}
	public static void main(String[] args)
	{
		try{
			for(int i=0;i<5;i++){
				System.out.println("Acc No.: "+UserDefinedException.accNo[i]+" Name : "+UserDefinedException.names[i]+" Balance : "+UserDefinedException.bal[i]);
				if(UserDefinedException.bal[i]<1000)
					throw new UserDefinedException();//("Balance amount avails less than 1000.");
			}
		}catch(UserDefinedException obj){
			obj.printStackTrace();
		}
	}
}
