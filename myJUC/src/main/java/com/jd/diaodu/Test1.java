package com.jd.diaodu;

public class Test1 {
	public static void main(String[] args) {
//		DiaoDu dd = new DiaoDu();
		DiaoDu2 dd = new DiaoDu2();
		new Thread(()-> {
			while(true){
					dd.AA();
			}

		}).start();

		new Thread(()-> {
			while(true){
				dd.BB();
			}

		}).start();
		new Thread(()-> {
			while(true){
				dd.CC();
			}

		}).start();
	}
}
