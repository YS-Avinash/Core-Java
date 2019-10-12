public class Dept{
	private Integer deptno;
	private String dname;
	private String loc;

	public Dept(){}

	public Dept(Integer deptno){
		this.deptno = deptno;
	}
	public Dept(Integer deptno,String dname,String loc){
		this.deptno = deptno;
		this.dname  = dname;
		this.loc    = loc;
	}
	public void setDeptno(Integer deptno){
		this.deptno = deptno;
	}
	public void setDname(String dname){
		this.dname = dname;
	}
	public void setLoc(String loc){
		this.loc = loc;
	}
	public String toString(){
		String dept;
		int pad = 15;
		dept=deptno+"  ";
		String name=dname;
		for(;name.length()<=pad;)
			name+=" ";
		String l=loc;
		for(;l.length()<=pad;)
			l+=" ";
		dept+=name+"  ";
		dept+=l;
		return dept;
	}
	public Integer getDeptno(){return deptno;}
	public String getDname(){return dname;}
	public String getLoc(){return loc;}
}
	