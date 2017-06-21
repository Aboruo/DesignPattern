package com.aboruo.constructor.learnvolatile;

public class RunThread extends Thread {
	private boolean isRunning = true;
//	private  volatile boolean isRunning = true;
	public void setIsRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	public void run(){
		System.out.println("进入run方法");
		while(isRunning){
			//..
		}
		System.out.println("线程停止...");
	}
	public static void main(String[] args) throws InterruptedException{
		RunThread rt = new RunThread();
		rt.start();
		Thread.sleep(3000);
		rt.setIsRunning(false);
		System.out.println("isRunning的值已被设置了false");
		Thread.sleep(1000);
		System.out.println(rt.isRunning);
	}

}
