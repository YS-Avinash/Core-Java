import java.util.Scanner;
import java.sql.SQLException;
public class InsertDepartment{
	public static void main(String[] ar){		
		Modal modal = Modal.getInstance();
		String oracleURL = "jdbc:oracle:thin:@localhost:1521:";
		String oracleUSER = "demo";
		String oraclePWD = "test";
		try{
			modal.connectOracle(oracleURL,oracleUSER,oraclePWD);
			if(modal.getConnectionStatus()){
				Scanner sc = new Scanner(System.in);
				Integer deptno;
				String dname;
				String loc;
				System.out.print("enter deptno:");
				deptno = new Integer(sc.nextLine());
				System.out.print("enter dname:");
				dname = sc.nextLine();			
				System.out.print("enter loc:");
				loc = sc.nextLine();
				if(deptno<100 && deptno>0){
					Dept dept = new Dept(deptno,dname,loc);
					modal.insertDepartment(dept);
				}else
					System.out.println("deptno should be two digit!");
			}
			modal.closeConnection();
		}catch(NumberFormatException|ClassNotFoundException|SQLException e){
			System.out.println(e);
		}
	}
}