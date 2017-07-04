package com.aboruo.constructor.master_worker;
/**
 * @author aboruo
 * @comment 任务类
 */
public class Task {
	private String id;
	private String name;
	public Task(String id,String name){
		this.id= id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;
	public String toString(){
		return this.name;
	}
}
