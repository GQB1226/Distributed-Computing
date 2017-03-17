package server;


/**
 * 
 * @author GQB1226
 *
 */
public class ReplyServiceImpl implements ReplyService {

	@Override
	public String getReply(String msg) {
		return "Server recived:"+msg;
	}

}
