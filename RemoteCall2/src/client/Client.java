package client;

import proxy.DynamicProxyFactory;
import server.ReplyService;

public class Client {
	private final static String HOST="127.0.0.1";
	private final static int PORT=6666;
	
	public static void main(String[] args) {
		ReplyService service=(ReplyService)DynamicProxyFactory.getProxy(ReplyService.class, HOST, PORT);
		System.out.println(service.getReply("hello"));
	}

}
