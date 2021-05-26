package kr.legossol.api.review.service;

import org.springframework.web.multipart.MultipartFile;
import kr.legossol.api.common.util.ModelMapperUtils;
import kr.legossol.api.review.domain.ReviewFile;
import kr.legossol.api.review.domain.dto.ReviewFileDto;

import java.util.ArrayList;
import java.util.List;

public interface ReviewFileService {
    ArrayList<ReviewFileDto> saveFile(List<MultipartFile> uploadFiles);
    void reviewFileDelete(Long reviewFileId);

    default ReviewFile dtoToEntity(ReviewFileDto reviewFileDto){
        ReviewFile reviewFile = ModelMapperUtils.getModelMapper().map(reviewFileDto, ReviewFile.class);

        return reviewFile;
    }

    default ReviewFileDto entityToDto(ReviewFile reviewFile){
        ReviewFileDto reviewFileDto = ModelMapperUtils.getModelMapper().map(reviewFile, ReviewFileDto.class);

        return reviewFileDto;
    }
}
