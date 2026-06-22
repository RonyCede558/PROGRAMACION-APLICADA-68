package controller;

public class subprocessAcounts extends Thread{
	private mgAcount mga;

	public subprocessAcounts(mgAcount mga) {
		super();
		this.mga = mga;
	}
	
	public void run() {
		try {
			sleep(1000);
			mga.createAcount();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
