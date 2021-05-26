package kr.legossol.api.review.domain.dto;

import lombok.*;
import org.springframework.stereotype.Component;
import kr.legossol.api.review.domain.Review;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewFileDto {

    private Long reviewFileId;
    private String uuid;
    private String imgName;
    private String path;
    private Review review;
//
//    public String getImageURL(){
//        try{
//            return URLEncoder.encode(path+"/"+uuid+"_"+imgName,"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }
//
//    public String getThumbnailURL(){
//        try{
//            return URLEncoder.encode(path+"/s_"+uuid+"_"+imgName,"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }
}
