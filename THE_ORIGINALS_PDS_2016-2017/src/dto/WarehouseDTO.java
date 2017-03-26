package dto;

public class WarehouseDTO{
	
	private int id_warehouse; //auto increment
	private String name;
	private int volum;
	private String adress;
	private int numTel;
	private String login_director;
	
	public WarehouseDTO(){
		this.id_warehouse=id_warehouse;
		this.name=name;
		this.adress=adress;
		this.volum=volum;
		this.numTel=numTel;
		this.login_director=login_director;
	}
	
	public WarehouseDTO(int iw,String nm,int vol,String ad,int nT,String lg){
		this.id_warehouse=iw;
		this.name=nm;
		this.adress=ad;
		this.volum=vol;
		this.numTel=nT;
		this.login_director=lg;
	}
	
	public int getId_warehouse() {
		return id_warehouse;
	}
	public void setId_warehouse(int id_warehouse) {
		this.id_warehouse = id_warehouse;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getVolum() {
		return volum;
	}
	public void setVolum(int volum) {
		this.volum = volum;
	}
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	
	public String getLogin_director() {
		return login_director;
	}
	public void setLogin_director(String login_director) {
		this.login_director = login_director;
	}
	
	@Override
	public String toString() {
		return "WarehouseDTO [id_warehouse=" + id_warehouse + ", name=" + name + ", volum=" + volum + ", adress="
				+ adress + ", numTel=" + numTel + ", login_director=" + login_director + "]";
	}
}
