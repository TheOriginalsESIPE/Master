package dto;

<<<<<<< HEAD

=======
>>>>>>> 835007e46af7dc4575eb85f9a21231f2be84fdc1
public class RepairerDTO{
	
	private String login, password, firstname, lastname, adress;
	private int numTel;
	
	public RepairerDTO(){
		this.login=login;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.adress=adress;
		this.numTel=numTel;
	}
	
	public RepairerDTO(String lo,String psw,String fn,String ln,String ad,int nT){
		this.login=lo;
		this.password=psw;
		this.firstname=fn;
		this.lastname=ln;
		this.adress=ad;
		this.numTel=nT;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
<<<<<<< HEAD
=======

	@Override
	public String toString() {
		return "RepairerDTO [login=" + login + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", adress=" + adress + ", numTel=" + numTel + "]";
	}
	
	
>>>>>>> 835007e46af7dc4575eb85f9a21231f2be84fdc1
}