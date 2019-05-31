package com.jd.all;

public class ProConSSS {

	public static void main(String[] args) {
		Resources r = new Resources();

		new Thread(()->{
			while(true){
				r.conl();
			}
		},"one ======>").start();


		new Thread(()->{
			while(true){
				r.conl();
			}
		},"two ======>").start();
		new Thread(()->{
			while(true){
				r.prol();
			}
		},"one ======>").start();
		new Thread(()->{
			while(true){
				r.prol();
			}
		},"two ======>").start();
	}

}
