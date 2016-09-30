package com.aboruo.DesignPattern.iterator.dao;

public class ArrayTestUtil<T> implements Collection<T> {
	private T[] arrayTest;
	private int arrayIndex = 0;
	public ArrayTestUtil(T[] arrayTest){
		this.arrayTest = arrayTest;
		arrayIndex = arrayTest.length - 1;
	}
	/**
	 * @Title:iterator
	 * @Description:获取该容器的迭代器
	 * @author:aboruo
	 * @return Iterator<T>
	 * @date 2016年9月28日 下午2:23:00
	 */
	@Override
	public Iterator<T> iterator() {
		return new TestIterator(this);
	}

	/**
	 * @Title:add
	 * @Description:向容器中添加元素
	 * @author:aboruo
	 * @param t void
	 * @date 2016年9月28日 下午2:22:34
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(T t) {
		if(arrayIndex < (this.arrayTest.length - 1)){
			arrayTest[++arrayIndex] = t;
		}else{
			/** 数组已满 */
			T[] arrayTestNew = (T[]) new Object[2 * arrayIndex];
			System.arraycopy(arrayTest, 0, arrayTestNew, 0, arrayTest.length);
			arrayTest = arrayTestNew;
			arrayTest[++arrayIndex] = t;
		}
	}

	/**
	 * @Title:get
	 * @Description:从容器中获取某个位置的对象
	 * @author:aboruo
	 * @param index
	 * @return T
	 * @date 2016年9月28日 下午2:22:10
	 */
	@Override
	public T get(int index) {
		return index >= 0 && index < arrayTest.length ? arrayTest[index] : null;
	}

	/**
	 * @Title:remove
	 * @Description:从集合中删除元素
	 * @author:aboruo
	 * @param t void
	 * @date 2016年9月28日 下午2:20:07
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void remove(T t) {
		T[] arrayNew = (T[]) new Object[arrayIndex + 1];
		T tTmp = null;
		for(int i = 0,j = 0; i < arrayNew.length;i++,j++){
			tTmp = get(i);
			if(t.equals(tTmp)){
				arrayTest[i] = null;
				j--;
				continue;
			}
			arrayNew[j] = tTmp;
		}
		arrayTest = arrayNew;
	}
	/**
	 * 类名称：TestIterator
	 * 类描述：容器类的私有内部类，该容器的迭代器
	 * @author aboruo
	 * @date 2016年9月28日 下午2:20:58
	 */
	private class TestIterator implements Iterator<T> {
		private Collection<T> collection;
		private int index = -1;
		public TestIterator(Collection<T> collection){
			this.collection = collection;
		}

		@Override
		public boolean hasNext() {
			boolean retValue = index + 1 < collection.size() && collection.get(index + 1) != null;
			if(!retValue){
				index--;
				return retValue;
			}else{
				index++;
				return retValue;
			}
		}

		@Override
		public T next() {
			T object = collection.get(index);
			return object;
		}

		@Override
		public T first() {
			return collection.size() > 1 ? collection.get(0) : null;
		}
		@Override
		public T previous() {
			T object = null;
			object = (index - 1) >= 0 ? collection.get(--index) : null;
			return object;
		}

		@Override
		public boolean remove() {
			T object = collection.get(index);
			collection.remove(object);
			return true;
		}
		
	}
	@Override
	public int size() {
		return arrayTest.length;
	}
}
