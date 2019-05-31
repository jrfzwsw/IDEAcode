package com.jd.conditiionlock;

public class ConditionTest {
	public static void main(String[] args) {
		Resource resource = new Resource();

		new Thread(()->{
			while(true){
				resource.add();
			}
		},"one+++").start();

		new Thread(()->{
			while(true){
				resource.add();
			}
		},"        two+++").start();
		new Thread(()->{
			while(true){
				resource.sub();
			}
		},"one----").start();
		new Thread(()->{
			while(true){
				resource.sub();
			}
		},"       two---").start();

	}
}
