package kr.legossol.api.funding.domain;

import com.amazonaws.services.config.model.Source;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import kr.legossol.api.common.util.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class FundingDto {
    private Long fundingId;
    private String title;     
    private String content;
    private Long goalPrice;
    private int viewCnt;
    private String hashtag;

    // public Funding DtotoEntity(){
    //     return Funding.builder()
    //     .title(title)
    //     .content(content)
    //     .goalPrice(goalPrice)
    //     .hashtag(hashtag)
    //     .build();
    // }
    // public static FundingDto toDto(Funding funding){
    //     return FundingDto.builder()
    //     .title(funding.getTitle())
    //     .content(funding.getContent())
    //     .goalPrice(funding.getGoalPrice())
    //     .hashtag(funding.getHashtag())
    //     .build();
    // }

    // Entity -> Dto
    public static FundingDto toDto(Funding funding){
        return ModelMapperUtils.getModelMapper().map(funding, FundingDto.class);
    }
    // Entity -> Dto(Page)
    public static Page<FundingDto> of(Page<Funding> sourcePage){
        return sourcePage.map(FundingDto::toDto);
    }
   

    
}
