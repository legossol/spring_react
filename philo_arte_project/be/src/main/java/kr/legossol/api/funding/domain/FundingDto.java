package kr.legossol.api.funding.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import kr.legossol.api.common.util.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FundingDto {
    private Long fundingId;
    private String title;     
    private String content;
    private Long goalPrice;
    private Long artistId;
    private int viewCnt;
    private String hashtag;

    // private int page;
    // private int recordsPerPage;
    // private int size;
    // private String type;
    // private String keyword;

    private ArrayList<FundingFileDto> pictures;

    // Entity -> Dto
    public static FundingDto toDto(Funding funding){
        return ModelMapperUtils.getModelMapper().map(funding, FundingDto.class);
    }
    // Entity -> Dto(Page)
    public static Page<FundingDto> toDtoPage(Page<Funding> sourcePage){
        return sourcePage.map(FundingDto::toDto);
    }

    public static FundingDto toDto(List<Funding> funding) {
        return ModelMapperUtils.getModelMapper().map(funding, FundingDto.class);
    }
    public static FundingDto toDtoList(List<Funding> sendIt) {
        return  ModelMapperUtils.getModelMapper().map(sendIt, FundingDto.class)
    }
    

    
}
