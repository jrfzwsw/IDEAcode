package com.jd.all;

public class AABBCC {
	public static void main(String[] args) {
		Resources r = new Resources();
		new Thread(()->{
			while (true){
				r.AA();
			}
		}).start();


		new Thread(()->{
			while (true){
				r.BB();
			}
		}).start();
		new Thread(()->{
			while (true){
				r.CC();
			}
		}).start();
	}
}
