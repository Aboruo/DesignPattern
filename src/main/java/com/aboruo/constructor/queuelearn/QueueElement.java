package com.aboruo.constructor.queuelearn;

public class QueueElement implements Comparable<QueueElement> {
	private int id;
	private String eleName;
	public QueueElement(int id,String eleName){
		this.id = id;
		this.eleName = eleName;
	}
	public QueueElement(){}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the eleName
	 */
	public String getEleName() {
		return eleName;
	}
	/**
	 * @param eleName the eleName to set
	 */
	public void setEleName(String eleName) {
		this.eleName = eleName;
	}
	@Override
	public int compareTo(QueueElement o) {
		return this.id > o.id ? 1 :( this.id < o.id ? -1 : 0);
	}
	public String toString(){
		return "id>" + this.id + ",name>" + this.eleName;
	}
}
