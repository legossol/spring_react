package kr.legossol.api.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import kr.legossol.api.review.domain.Reply;
import kr.legossol.api.review.domain.ReviewFile;
import kr.legossol.api.review.domain.dto.ReplyDto;
import kr.legossol.api.review.domain.Review;
import kr.legossol.api.review.repository.ReplyRepository;
import kr.legossol.api.review.repository.ReviewFileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository repository;
//    private final  reviewFileRepository;

    @Transactional
    @Override
    public Long save(ReplyDto replyDto) {
        Reply replySave = dtoToEntity(replyDto);
//        ArrayList<MultipartFile> files = new ArrayList<>();
        repository.save(replySave);
//        if(files != null && files.size() > 0){
//            files.forEach(reviewFile -> {
//                repository.save(replySave);
//            });
//        }
        return replyDto.getRno();
    }

    @Override
    public List<ReplyDto> getList(Long reviewId) {
        List<Reply> result = repository.getRepliesByReviewOrderByReview(Review.builder().reviewId(reviewId).build());
        return result.stream().map(reply -> entityToDto(reply)).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDto replyDto) {
        Reply reply = dtoToEntity(replyDto);
        repository.save(reply);
    }


    @Override
    public void remove(Long rno) {

        repository.deleteById(rno);
    }
}
