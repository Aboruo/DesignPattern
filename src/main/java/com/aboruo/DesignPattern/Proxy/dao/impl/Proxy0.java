package com.aboruo.DesignPattern.Proxy.dao.impl;

import com.aboruo.DesignPattern.Proxy.dao.UserActionDao;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
/**
 * 类名称：Proxy0
 * 类描述：jdk的proxy生成的动态代理类
 * @author aboruo
 * @date 2016年7月29日 上午10:48:24
 */
public final class Proxy0 extends Proxy implements UserActionDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3133205835277657819L;
	private static Method m1;
	private static Method m3;
	private static Method m0;
	private static Method m2;

	public Proxy0(InvocationHandler paramInvocationHandler) throws Exception {
		super(paramInvocationHandler);
	}

	public final boolean equals(Object paramObject) {
		try {
			return ((Boolean) this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
		} catch (Error localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final void userOpenFile(String paramString) {
		try {
			this.h.invoke(this, m3, new Object[] { paramString });
			return;
		} catch (Error localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final int hashCode() {
		try {
			return ((Integer) this.h.invoke(this, m0, null)).intValue();
		} catch (Error localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	public final String toString() {
		try {
			return (String) this.h.invoke(this, m2, null);
		} catch (Error localError) {
			throw localError;
		} catch (Throwable localThrowable) {
			throw new UndeclaredThrowableException(localThrowable);
		}
	}

	static {
		try {
			m1 = Class.forName("java.lang.Object").getMethod("equals",
					new Class[] { Class.forName("java.lang.Object") });
			m3 = Class.forName("com.aboruo.DesignPattern.Proxy.dao.UserActionDao").getMethod("userOpenFile",
					new Class[] { Class.forName("java.lang.String") });
			m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
			m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
		} catch (NoSuchMethodException localNoSuchMethodException) {
			throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
		} catch (ClassNotFoundException localClassNotFoundException) {
			throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
		}
	}
}