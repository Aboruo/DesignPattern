package com.aboruo.DesignPattern.Composite.entity;

import java.util.Vector;

public class PersonNode {
	/** 姓名 */
	private String name;
	/** 性别 */
	private String sexy;
	/** 年龄 */
	private int age;
	/** 孩子 */
	private Vector<PersonNode> children = new Vector<PersonNode>();
	public Vector<PersonNode> getChildren() {
		return children;
	}
	public void setChildren(Vector<PersonNode> children) {
		this.children = children;
	}
	/** 父母 */
	private Vector<PersonNode> parents = new Vector<PersonNode>();
	/**
	 * @Title:addChildren
	 * @Description:添加孩子
	 * @author:aboruo
	 * @param personNode void
	 * @date 2016年8月12日 下午4:11:23
	 */
	public void addChildren(PersonNode personNode){
		this.children.add(personNode);
	}
	/**
	 * @Title:removeChildren
	 * @Description:删除孩子
	 * @author:aboruo
	 * @param personNode void
	 * @date 2016年8月12日 下午4:13:56
	 */
	public void removeChildren(PersonNode personNode){
		this.children.remove(personNode);
	}
	/**
	 * @Title:addParent
	 * @Description:添加父节点
	 * @author:aboruo
	 * @param personNode void
	 * @date 2016年8月12日 下午4:15:26
	 */
	public void addParent(PersonNode personNode){
		this.parents.add(personNode);
	}
	/**
	 * @Title:removeParent
	 * @Description:删除父节点
	 * @author:aboruo
	 * @param personNode void
	 * @date 2016年8月12日 下午4:16:39
	 */
	public void removeParent(PersonNode personNode){
		this.parents.remove(personNode);
	}
	public Vector<PersonNode> getParents() {
		return parents;
	}
	public void setParents(Vector<PersonNode> parents) {
		this.parents = parents;
	}
	public PersonNode(){}
	public PersonNode(String name,String sexy,int age){
		super();
		this.name = name;
		this.sexy = sexy;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSexy() {
		return sexy;
	}
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return this.name;
	}
}
