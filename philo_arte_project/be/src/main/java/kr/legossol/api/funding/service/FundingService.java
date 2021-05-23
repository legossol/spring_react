package kr.legossol.api.funding.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.domain.FundingFile;
import kr.legossol.api.funding.domain.FundingFileDto;

public interface FundingService {
   
    public Optional<Funding> findById(Long id);
    List<Funding> getAllFundings();
    default Funding dtoToEntity(FundingDto dto){
        Funding funding = Funding.builder()
                        .fundingId(dto.getFundingId())
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .goalPrice(dto.getGoalPrice())
                        .hashtag(dto.getHashtag())
                        .build();
                        return funding;
    }
    FundingDto getFundingById(long id);
    // public Page<Funding> getFundingPageList(Pageable pageable);
    //============fileservice below==============


    String detailRegister(FundingFileDto fundingFileDto);

    ArrayList<FundingFileDto> registerFile(List<MultipartFile> uploadFiles);

    String deleteFile(Long fundingFileId);

    public Page<FundingDto> findFundingPaging(Integer page, String title);

    List<FundingDto> searchPost(String keyword);

    Page<FundingDto> getAllPaging(Pageable pageable);

    Page<FundingDto> findPageByTitle(String title, Pageable pageable);

    List<FundingDto> getListPage(int page);
}
