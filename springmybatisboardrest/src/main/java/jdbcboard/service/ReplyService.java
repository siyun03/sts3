package jdbcboard.service;

import java.util.List;

import jdbcboard.model.Reply;

public interface ReplyService {
	
	default List<Reply> selectReply(int aid) { return null; }
	
	default Reply getReply(int rid) { return null; }
	
	default int insertReply(Reply reply) { return 0; }
	
	default int updateReply(Reply reply) { return 0; }
	
	default int deleteReply(int rid) { return 0; }	

}
