import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class Modal{
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement psmt = null;

	private static Modal modal= null;
	
	private boolean connectionStatus = false;

	private Modal(){}

	public static Modal getInstance(){
		if(modal==null)
			modal = new Modal();
		return modal;
	}
	
	public void connectOracle(String url,String user,String pwd)throws ClassNotFoundException,SQLException{
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url,user,pwd);
		connectionStatus = true;
	}
	public void connectMySQL(String url,String user,String pwd,String db)throws ClassNotFoundException,SQLException{
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+"/"+db,user,pwd);
		connectionStatus = true;
	}
	public void connectDerby(String url,String user,String pwd,String db)throws ClassNotFoundException,SQLException{
		String driver = "org.apache.derby.jdbc.ClientDriver";
		Class.forName(driver);
		conn = DriverManager.getConnection(url+"/"+db,user,pwd);
		connectionStatus = true;
	}
	public void closeConnection()throws SQLException{
		if(conn!=null)
			conn.close();
		connectionStatus = false;
	}
	public void insertDepartment(Dept dept){
		if(connectionStatus){
			Integer deptno = dept.getDeptno();
			String dname = dept.getDname();
			String loc = dept.getLoc();
			try{
				psmt = conn.prepareStatement("insert into dept values(?,?,?)");
				psmt.setInt(1,deptno);
				psmt.setString(2,dname);
				psmt.setString(3,loc);
				psmt.executeUpdate();
				System.out.println("row inserted successfully!");
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}finally{
				if(psmt!=null){
					try{
						psmt.close();
						psmt = null;
					}catch(SQLException e){
						System.out.println(e);
					}
				}
			}
		}else
			System.out.println("no connection established, try after connection!");
	}
	public List<Dept> getDepartments(){
		List<Dept> departments = new ArrayList<Dept>();
		if(connectionStatus){
			try{
				st = conn.createStatement();
				rs = st.executeQuery("select * from dept order by deptno");
				while(rs.next()){
					Dept d = new Dept();
					d.setDeptno(rs.getInt(1));							d.setDname(rs.getString(2));
					d.setLoc(rs.getString(3));
					departments.add(d);
				}
			}catch(SQLException e){
			}finally{
				if(rs!=null){
					try{
						rs.close();
					}catch(SQLException e){
						System.out.println(e);
					}
				}
				if(st!=null){
					try{
						st.close();
					}catch(SQLException e){
						System.out.println(e);
					}
				}
			}
		}else
			System.out.println("no connection established, try after connection!");	
		return departments;	
	}		
				

	public boolean getConnectionStatus(){
		return connectionStatus;
	}
	public Dept getDepartmentByDeptno(int deptno){
		Dept dept = null;
		List<Dept> departments = getDepartments();
		for(Dept d : departments){
			if(d.getDeptno()==deptno){
				dept = d;
				break;
			}
		}
		return dept;
	}
	public void updateDepartment(Dept dept){
		if(connectionStatus){
			Integer deptno = dept.getDeptno();
			String dname = dept.getDname();
			String loc = dept.getLoc();
			Dept d = getDepartmentByDeptno(deptno);
			if(d == null)
				System.out.println("department with deptno("+deptno+") is not existing!");
			else{
				try{
					psmt = conn.prepareStatement("update dept set dname=?,loc=? where deptno=?");
					psmt.setInt(3,deptno);
					psmt.setString(1,dname);
					psmt.setString(2,loc);
					psmt.executeUpdate();
					System.out.println("1 row updated!");
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}finally{
					if(psmt!=null){
						try{
							psmt.close();
							psmt = null;
						}catch(SQLException e){
							System.out.println(e);
						}
					}
				}
			}
		}else
			System.out.println("no connection established, try after connection!");
	}
}	