import java.sql.SQLException;
import java.util.List;
public class ShowDepartments{
	public static void main(String[] ar){
		Modal modal = Modal.getInstance();
		String oracleURL = "jdbc:oracle:thin:@localhost:1521:";
		String oracleUSER = "demo";
		String oraclePWD = "test";
		try{
			modal.connectOracle(oracleURL,oracleUSER,oraclePWD);
			if(modal.getConnectionStatus()){
				List<Dept> departments = modal.getDepartments();
				if(departments.size()==0)
					System.out.println("no rows selected!");
				else{
					System.out.println("*** Table Dept Info ***");							departments.stream().forEach((dept)->{
						System.out.println(dept);
					});
				}	
			}
			modal.closeConnection();
		}catch(ClassNotFoundException|SQLException e){
			System.out.println(e);
		}
			
	}
}
		