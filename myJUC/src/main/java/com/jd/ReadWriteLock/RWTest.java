package com.jd.ReadWriteLock;

public class RWTest<pri> {

	public static void main(String[] args) {
		ReadWrite rw = new ReadWrite();
		for (int i = 0; i < 20; i++) {

			new Thread(()-> {

				while(true){
					rw.read();
				}
			},"read" + i).start();
		}
		new Thread(()-> {
			while(true){
				rw.write();
			}
		},"write").start();
	}
}
