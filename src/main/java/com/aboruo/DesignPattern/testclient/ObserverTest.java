package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Observer.dao.Monitored;
import com.aboruo.DesignPattern.Observer.dao.abs.impl.MyMonitored;
import com.aboruo.DesignPattern.Observer.dao.impl.ObserverA;
import com.aboruo.DesignPattern.Observer.dao.impl.ObserverB;

public class ObserverTest {

	public static void main(String[] args) {
		Monitored monitored = new MyMonitored();
		monitored.add(new ObserverA());
		monitored.add(new ObserverB());
		
		monitored.operate();
	}

}
