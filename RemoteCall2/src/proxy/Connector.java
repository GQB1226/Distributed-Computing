package proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
	private String host;
	private int port;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public Connector(){
		
	}
	public Connector(String host,int port) throws Exception{
		this.host=host;
		this.port=port;
		connect();
	}

	private void connect()  throws Exception{

		socket=new Socket(host, port);
		
		out=new ObjectOutputStream(socket.getOutputStream());
		in=new ObjectInputStream(socket.getInputStream());
	}
	public void send(Object object) throws IOException{
		out.writeObject(object);
	}
	public Object recive() throws ClassNotFoundException, IOException{
		return in.readObject();
	}
	public void close(){
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
