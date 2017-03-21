package server;


/**
 * 具体实现类
 * @author GQB1226
 *
 */
public class ReplyServiceImpl implements ReplyService{

	@Override
	public String getReply(String msg) {
		// TODO Auto-generated method stub
		return "Server recived"+msg;
	}


	

}
