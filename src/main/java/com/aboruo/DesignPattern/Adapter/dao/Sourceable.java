package com.aboruo.DesignPattern.Adapter.dao;
/**
 * 类名称：Sourceable
 * 类描述：接口的适配器模式 含有众多适配接口方法的接口
 * @author aboruo
 * @date 2016年7月22日 下午5:42:45
 */
public interface Sourceable {
	public void useMouse();
	public void useKeyboard();
	public void useScreen();
}
