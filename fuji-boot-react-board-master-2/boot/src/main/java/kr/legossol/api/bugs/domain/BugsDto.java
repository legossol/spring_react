package kr.legossol.api.bugs.domain;
import lombok.Data;
import org.springframework.stereotype.Component;
    
import javax.persistence.Column;
    
@Component
@Data
public class BugsDto {
    private Long bugsId;
    private String bugsNo;
    private String category;
    private String title;
    private String address;
}