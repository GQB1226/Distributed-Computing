package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import remote.RCall;
import server.ReplyServiceImpl;
import server.ReplyService;

public class Server {
	
	final static int PORT=6666;
	static Map<String, Object> map=new HashMap<>();
	
	public static void main(String[] args) throws Exception{
		map.put("ReplyService", new ReplyServiceImpl());
		ServerSocket serverSocket=new ServerSocket(PORT);
		System.out.println("Listering on port:"+PORT);
		while(true){
			Socket client=serverSocket.accept();
			ObjectInputStream in=new ObjectInputStream(client.getInputStream());
			ObjectOutputStream out=new ObjectOutputStream(client.getOutputStream());
			RCall rc=(RCall)in.readObject();
			System.out.println(rc);
			deal(rc);
			out.writeObject(rc);
			in.close();
			out.close();
			client.close();
		}

		
	}

	private static void deal(RCall rc) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object result=null;
		String className=rc.getClassName();
		String methodName=rc.getMethodName();
		Object[] params=rc.getParams();
		System.out.println(className);
		
		try {
			
			Class classType=Class.forName("server."+className);//forName是包名+类名！！！
			Class[] paramsTypes=rc.getParamTypes();
			Method method=classType.getMethod(methodName, paramsTypes);
			result=method.invoke(map.get(className), params);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rc.setResult(result);
		
		
		
	}

}
