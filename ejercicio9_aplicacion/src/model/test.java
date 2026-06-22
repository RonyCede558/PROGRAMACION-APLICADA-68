package model;

import java.io.IOException;
import java.util.Date;

public class test {
	public void main(String[] args) {
		acountDAO adao= new acountDAO(new acount(
				12345678,100.5,1,0.0,new Date()
				));
		
		try {
			adao.writerAcount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
