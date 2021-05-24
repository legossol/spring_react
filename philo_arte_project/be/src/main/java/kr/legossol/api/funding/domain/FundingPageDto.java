package kr.legossol.api.funding.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class FundingPageDto {
    // 현재 페이지
    private int page;
    //페이지당 글 갯수
    private int PerPage;
    //하단 페이지 표시 수
    private int size;

      

    public int getStartPage(){
        return (page -1) * PerPage;
    }
    //기본 생성자
    public FundingPageDto(){
        this.page = 1;
        this.PerPage = 6;
        this.size = 10;
    }
    //--검색--below--
    private String type;
    private String keyword;


   

    public Pageable getPageable(Sort sort){   
        return PageRequest.of(page -1, size, sort);
    }
    
}
