public class CommandLineArgCount{
	public static void main(String[] args){
		if(args.length>0)
			System.out.print(String.join(",",args));
		else
			System.out.print("No Values");
			
	}
}