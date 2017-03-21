package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import remote.RCall;

public class DynamicProxyFactory {
	
	
	
	public static Object getProxy(final Class classType,final String host,final int port){
		InvocationHandler handler=new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Connector connector=null;
				try {
					connector=new Connector(host, port);
					RCall rCall=new RCall(classType.getName(), method.getName(), method.getParameterTypes(), args);
					connector.send(rCall);
					rCall=(RCall)connector.recive();
					Object result=rCall.getResult();
					return result;
				} finally {
					if(connector!=null){
						connector.close();
					}
				}
			}
		};
		return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{classType}, handler);
	}

}
