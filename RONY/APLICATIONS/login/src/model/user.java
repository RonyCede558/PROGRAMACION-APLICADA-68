package model;

import libreria_generica.generic;

public class user {
	private generic<String,?>dt_u;
	public user(String user, String psw) {
		this.dt_u=new generic(user,psw);
	}
	
	public String user() {
		return dt_u.getAttributeT1();
	}
	
	public String getPsw() {
		return dt_u.getAttributeT2();
	}
}
