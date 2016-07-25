package com.aboruo.DesignPattern.testclient;

import com.aboruo.DesignPattern.Adapter.dao.AdapterTargetable;
import com.aboruo.DesignPattern.Adapter.dao.Sourceable;
import com.aboruo.DesignPattern.Adapter.dao.impl.Adapter;
import com.aboruo.DesignPattern.Adapter.dao.impl.SourceSub1;
import com.aboruo.DesignPattern.Adapter.dao.impl.SourceSub2;
import com.aboruo.DesignPattern.Adapter.dao.impl.Wrapper;
import com.aboruo.DesignPattern.Adapter.entity.Source;

/**
 * 类名称：AdapterTest
 * 类描述：适配器模式  测试类
 * @author aboruo
 * @date 2016年7月22日 下午4:37:10
 */
public class AdapterTest {
	public static void main(String[] args){
		/** 类适配器模式 */
		AdapterTargetable adapterTargetable = new Adapter();
		adapterTargetable.originalMethod(); //新需求中的原有方法
		adapterTargetable.needNewMethod(); //新需求中新增的方法
		
		/** 对象适配器模式 */
		Source source = new Source();
		adapterTargetable = new Wrapper(source);
		adapterTargetable.originalMethod(); //新需求中的原有方法
		adapterTargetable.needNewMethod(); //新需求中新增的方法
		
		/** 接口适配器模式 */
		Sourceable sourceable = new SourceSub1();
		Sourceable sourceable2 = new SourceSub2();
		sourceable.useMouse();
		sourceable2.useKeyboard();
		/**
		 * 类的适配器模式：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
		 * 对象的适配器模式：当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
		 * 接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
		 */
	}
}
