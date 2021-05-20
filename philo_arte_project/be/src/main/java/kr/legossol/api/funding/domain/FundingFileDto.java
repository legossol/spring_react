package kr.legossol.api.funding.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FundingFileDto {
    private Long pnum;

    private String uuid;

    private String fname;
    
    private String fileTitle;

    private boolean first;

}
