package com.aboruo.DesignPattern.testclient;

public class TestThread extends Thread {
	private static String data = "Data：";
	public static void main(String[] args){
		TestThread testThread = new TestThread();
		testThread.calc(data);
		System.out.println(data);
	}
	public void calc(String s){
		s += "=";
		start();
	}
}
