package com.jd.all;

public class RWLock {
	public static void main(String[] args) {

		Resources r = new Resources();

		for (int i = 0; i <54; i++) {
				new Thread(()->{
					while(true){
						r.read();
					}
				},"read ========>" + i).start();
		}

		new Thread(()-> {
			while (true){
				r.write();
			}
		},"write =============>").start();
	}

}
