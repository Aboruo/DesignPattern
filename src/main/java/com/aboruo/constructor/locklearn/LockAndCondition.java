package com.aboruo.constructor.locklearn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述: 
 * 类名称: LockAndCondition
 * @author aboruo
 * @date 2017年6月29日 下午9:10:21
 * @since 1.0.0
 */
public class LockAndCondition {
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	
	private void m1(){
		try {
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入m1方法......");
			c1.await();
			Thread.sleep(2000);
			System.out.println("当前线程：" + Thread.currentThread().getName() + "继续执行m1方法......");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	private void m2(){
		try {
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入m2方法......");
			c1.await();
			Thread.sleep(2000);
			System.out.println("当前线程：" + Thread.currentThread().getName() + "继续执行m2方法......");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	private void m3(){
		try {
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入m3方法......");
			c1.await();
			Thread.sleep(2000);
			System.out.println("当前线程：" + Thread.currentThread().getName() + "继续执行m3方法......");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	private void m4(){
		try {
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入m4方法......");
			Thread.sleep(1000);
			c1.signalAll();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "通知c1等待者继续执行......");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	private void m5(){
		try {
			lock.lock();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "进入m5方法......");
			Thread.sleep(1000);
			c2.signalAll();
			System.out.println("当前线程：" + Thread.currentThread().getName() + "通知c2等待者继续执行......");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	/**
	 * @Title: main
	 * @description: TODO
	 * @author: aboruo
	 * @return void
	 * @sine: 2017年6月29日 下午9:10:21
	 */
	public static void main(String[] args) throws Exception {
		final LockAndCondition lockAndCondition = new LockAndCondition();
		new Thread(new Runnable() {
			@Override
			public void run() {
				lockAndCondition.m1();
			}
		},"t1").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				lockAndCondition.m2();
			}
		},"t2").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				lockAndCondition.m3();
			}
		},"t3").start();
		Thread.sleep(2000);
		new Thread(new Runnable() {
			@Override
			public void run() {
				lockAndCondition.m4();
			}
		},"t4").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				lockAndCondition.m5();
			}
		},"t5").start();
	}

}
