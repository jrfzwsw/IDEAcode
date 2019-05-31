package com.jd.all;

public class ProCon {

	public static void main(String[] args) {
		Resources r = new Resources();
		new Thread(()-> {

			while (true){
				r.pors();
			}
		},"pro +++++++++++").start();
		new Thread(() -> {
			while (true){
				r.cons();
			}

		},"con ------------").start();
	}
}
