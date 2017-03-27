package repository;


import java.sql.*;
import java.util.Date;
import sql.MyConnectionPool;
import java.text.SimpleDateFormat;

	public class ModelVehicle {
	
		java.sql.Connection connect1 = null;
 		
		    private String numMat;
		    private String model;
		    private String mark;
		    private String vehicle_type;
		    private int numPlace;
		    private String date_entrance;
		    private String date_wayout;
		    

		    public ModelVehicle(){
		    	
		    	MyConnectionPool myConnectionPool = new MyConnectionPool();
		 		connect1 = myConnectionPool.getConnectionFromPool();
				
		    }
		    
			

			
	 public int insert(String answer1, String answer2, int answer3bis) throws ClassNotFoundException , SQLException {
				 
				 try {
				
				 Statement stmt = connect1.createStatement( );
				 String sql = "insert into vehicule_depot(numMat, date_entrance, numPlace) VALUES ('"+answer1+"','"+answer2+"','"+answer3bis+"')";
				 int n= stmt.executeUpdate(sql);
				 stmt.close();
				 return n;
				 }
				 finally { //if (connect1 != null)
				 //connect1.close(); 
				 }
				 
	}
	public String select(String numMat) throws ClassNotFoundException , SQLException {
				
				 try {
				 
				 Statement stmt = connect1.createStatement( );
				 ResultSet rs = stmt.executeQuery("select vehicule.numMat, vehicule_depot.numMat, model, mark, vehicle_type, numPlace, date_entrance, date_wayout from vehicule, vehicule_depot where vehicule.numMat = vehicule_depot.numMat and vehicule_depot.numMat ='"+numMat+"'");
				 String result="";
				 while (rs.next()) {
					 String model = rs.getString("model");
					 String mark = rs.getString("mark");
					 String vehicle_type = rs.getString("vehicle_type");
					 int numPlace = rs.getInt("numPlace");
					 String numMatr = rs.getString("numMat");
					 String date_entrance = rs.getString("date_entrance");
					 String date_wayout = rs.getString("date_wayout");
					 result =" numero immatriculation : "+numMat+"\r\n" + " type de vehicule : "+vehicle_type+"\r\n"+" model : "+model+"\r\n"+ " mark : "+mark+"\r\n"+ " numero place : "+numPlace+"\r\n"+ " date entree : "+date_entrance+"\r\n"+" date sortie : "+date_wayout;
					 
					}
				 rs.close();
				 stmt.close();
				 return result;
				}
				 finally { //if (connect1 != null)
				 //connect1.close(); 
				 }
				
				 
	}
			 
			 public int delete(String numMat) throws ClassNotFoundException , SQLException {
				 
				 
				 try {
				 
				 Statement stmt = connect1.createStatement( );
				 String sql ="delete from vehicule_depot where numMat='"+numMat+"'";
				 int n= stmt.executeUpdate(sql);
				 stmt.close();
				 return n;
				 }
				 finally { //if (connect1 != null)
				 //connect1.close(); 
				 }
				 
			 }
			
			
			 public int update(String numMat) throws ClassNotFoundException , SQLException {
				 
				 
				 try {
				 
				 Statement stmt = connect1.createStatement( );
				 SimpleDateFormat formater = null;
				 Date aujourdhui = new Date();
				 formater = new SimpleDateFormat("yy-MM-dd");
				 String date_sort= formater.format(aujourdhui);
				 String sql ="update vehicule_depot set date_wayout ='"+date_sort+"' where numMat='"+numMat+"'";
				 int n= stmt.executeUpdate(sql);
				 stmt.close();
				 return n;
				 }
				 finally { //if (connect != null)
				 //connect.close(); 
				 }
				 
			 }

public boolean log(String name, String pwd) throws ClassNotFoundException , SQLException {
	boolean istrue=false;
				 
				 
				 try {
				 
				 Statement stmt = connect1.createStatement( );
				 ResultSet rs = stmt.executeQuery("select login, password from reparateur where login='"+name+"' and password='"+pwd+"'");
				 String result="";
				 
				while (rs.next()) {
					String n = rs.getString("login");
					String m = rs.getString("password");
					 if(n=="" || m==""){
						 istrue = false;
							 	 
						 }
					 else istrue = true;
					}
			
				 rs.close();
				 stmt.close();
				 return istrue;
				 }
				 finally { //if (connect1 != null)
					 //connect1.close(); 
				 }
				
				 
	}



			public String getNumMat() {
				return numMat;
			}




			public String getmodel() {
				return model;
			}




			public String getmark() {
				return mark;
			}




			public String getvehicle_type() {
				return vehicle_type;
			}




			public int getNumPlace() {
				return numPlace;
			}




			public String getdate_entrance() {
				return date_entrance;
			}




			public String getdate_wayout() {
				return date_wayout;
			}




			public void setNumMat(String numMat) {
				this.numMat = numMat;
			}




			public void setmodel(String model) {
				this.model = model;
			}




			public void setmark(String mark) {
				this.mark = mark;
			}




			public void setvehicle_type(String vehicle_type) {
				this.vehicle_type = vehicle_type;
			}




			public void setNumPlace(int numPlace) {
				this.numPlace = numPlace;
			}




			public void setdate_entrance(String date_entrance) {
				this.date_entrance = date_entrance;
			}




			public void setdate_wayout(String date_wayout) {
				this.date_wayout = date_wayout;
			}
			 
	

	}



