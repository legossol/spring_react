package kr.legossol.api.testreact.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.legossol.api.testreact.dto.PerformanceDTO;
import kr.legossol.api.testreact.dto.PicturesDTO;
import kr.legossol.api.testreact.entity.Performance;
import kr.legossol.api.testreact.entity.Pictures;
import kr.legossol.api.testreact.repository.PerformanceRepository;
import kr.legossol.api.testreact.repository.PicturesRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService{


    private final PerformanceRepository performanceRepository;
    private final PicturesRepository picturesRepository;

    @Transactional
    @Override
    public Long register(PerformanceDTO performanceDTO) {

        Performance performance = dtoToEntity(performanceDTO);

        //save
        performanceRepository.save(performance);

        ArrayList<PicturesDTO> pictures = performanceDTO.getPictures();

        if(pictures != null && pictures.size() > 0) {

            pictures.forEach(picturesDTO -> {
                Pictures pic = dtoToEntityPictures(picturesDTO);
                pic.confirmPerformance(performance);
                picturesRepository.save(pic);
            });
        }
        return performance.getPno();
    }
}











