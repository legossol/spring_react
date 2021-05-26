package kr.legossol.api.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.review.domain.Reply;
import kr.legossol.api.review.domain.Review;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("select a from Reply a order by a.rno desc")
    List<Reply> replyFindAll();

    @Modifying
    @Query("Update Reply a set a.text = :text where a.rno = :rno")
    int replyUpdate(@Param("rno") Long rno, @Param("text") String text);

    // 리뷰 삭제 시 댓글 삭제
    @Modifying
    @Query("DELETE FROM Reply rp where rp.review.reviewId = :reviewId ")
    void replyDelete(@Param("reviewId") Long reviewId);


    List<Reply> getRepliesByReviewOrderByReview(Review review);
}
