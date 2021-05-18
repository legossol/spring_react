package kr.legossol.api.testreact.service;

import kr.legossol.api.testreact.dto.PerformanceDTO;
import kr.legossol.api.testreact.dto.PicturesDTO;
import kr.legossol.api.testreact.entity.Performance;
import kr.legossol.api.testreact.entity.Pictures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface PerformanceService {

    Long register(PerformanceDTO performanceDTO);


    default Performance dtoToEntity(PerformanceDTO dto){


        Performance entity = Performance.builder()
                .pno(dto.getPno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();

        return entity;
    }

    default Pictures dtoToEntityPictures(PicturesDTO dto){

        Pictures picture = Pictures.builder()
                .pnum(dto.getPnum())
                .fname(dto.getFname())
                .uuid(dto.getUuid())
                .first(dto.isFirst())
                .build();
        return picture;
    }

}
