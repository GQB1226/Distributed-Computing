package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import remote.*;


/**
 * �����������ķ�ʽ����client��server֮���ͨ�ţ���Ҫ���͵���Ϣͨ��RemoteCall��װ
 * @author GQB1226
 *
 */
public class Client {
	
	final static String HOST="127.0.0.1";
	final static int PORT=6666;
	
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket(HOST, PORT);
		ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
		RCall rCall=new RCall("ReplyService", "getReply", new Class[]{String.class}, new Object[]{"hello"});
		out.writeObject(rCall);
		rCall=(RCall)in.readObject();
		System.out.println(rCall.getResult());
		in.close();
		out.close();
		socket.close();
		
		
	}

}
