package kr.or.blog.reply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.or.blog.entities.Reply;
import kr.or.blog.reply.repository.ReplyRepository;
import kr.or.blog.reply.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository replyRepository;
    /**
     * 해당 게시글의 댓글을 가져온다
     * @param reply - 검색 정보가 담긴 reply entity
     * @return replyList
     */
    public List<Reply> getReplys(Reply reply){
        List<Reply> replyList = replyRepository.findReplyByBoardSeq(reply.getBoardSeq());
        return replyList;
    }
    
    /**
     * 댓글을 등록한다
     * @param reply - 삽입할 정보가 담긴 reply entity
     */
    public void insertReply(Reply reply){
        replyRepository.save(reply);
    }

    /**
     * 댓글을 수정한다
     * @param reply - 수정할 정보가 담긴 reply entity
     */
    public void updateReply(Reply reply){
        replyRepository.save(reply);
    }

    /**
     * 댓글을 삭제한다
     * @param reply - 삭제할 정보가 담긴 reply entity
     */
    public void deleteReply(Reply reply){
        reply.setRecSts("D");
        replyRepository.save(reply);
    }

}