package kr.or.blog.reply.service;

import java.util.List;

import kr.or.blog.entities.Reply;

public interface ReplyService {
    
    /**
     * 해당 게시글의 댓글을 가져온다
     * @param reply - 검색 정보가 담긴 reply entity
     * @return replyList
     */
    public List<Reply> getReplys(Reply reply);
    
    /**
     * 댓글을 등록한다
     * @param reply - 삽입할 정보가 담긴 reply entity
     */
    public void insertReply(Reply reply);

    /**
     * 댓글을 수정한다
     * @param reply - 수정할 정보가 담긴 reply entity
     */
    public void updateReply(Reply reply);

    /**
     * 댓글을 삭제한다
     * @param reply - 삭제할 정보가 담긴 reply entity
     */
    public void deleteReply(Reply reply);
}