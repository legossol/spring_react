package kr.legossol.api.funding.domain;

import lombok.*;

import javax.persistence.*;

import kr.legossol.api.common.util.ModelMapperUtils;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="funding_files")
public class FundingFile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funding_file_id")
    private Long fundingFileId;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "fname")
    private String fname;
    @Column(name="file_title")
    private String fileTitle;
    @Column(name = "dup")
    private boolean dup;

    @ManyToOne
    private Funding funding;

    public void confirmFunding(Funding funding){
        this.funding = funding;
    }
    public void saveFileTitle(FundingFileDto fundingFileDto){
        this.fileTitle = fundingFileDto.getFileTitle();
    }

    public static FundingFile of(FundingFileDto fundingFileDto){
        return ModelMapperUtils.getModelMapper().map(fundingFileDto, FundingFile.class);
    }
    
}
