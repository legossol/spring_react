package kr.legossol.api.funding.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import com.amazonaws.services.codestarconnections.model.ResourceNotFoundException;

import org.joda.time.DateTime;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.common.util.ModelMapperUtils;
import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
import kr.legossol.api.funding.domain.FundingFile;
import kr.legossol.api.funding.domain.FundingFileDto;
import kr.legossol.api.funding.repository.FundingFileRepository;
import kr.legossol.api.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@Service
@Log4j2
@RequiredArgsConstructor
public class FundingServiceImpl extends AbstractService<FundingDto> implements FundingService{

    private final FundingRepository repository;
    private final FundingFileRepository frepo;

    @Override
    public List<FundingDto> findAll() {

        return null;
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FundingDto> getOne(long id) {
        // Funding postRequest = Funding.of(fundingDto)
        return null;
    }

    @Override
    public String delete(FundingDto postDto) {
        Funding funding = Funding.of(postDto);
        repository.delete(funding);

        return (repository.findById(funding.getFundingId()) == null) ? "Delete Success" : "Delete Failed";
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Boolean existsById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteById(long id) {

        repository.deleteById(id);
    }

    


    @Override
    @Transactional
    public String save(FundingDto requestDto) {
        Funding toEntityRequest = Funding.of(requestDto);
        toEntityRequest.saveRequest(requestDto);
        return (repository.save(toEntityRequest)!= null) ? "success" : "Fail";
    }
    

    @Transactional
    @Override
    public List<Funding> getAllFundings() {
                        
        return repository.getAllFundings();
    }
    
    @Override
    public FundingDto getFundingById(long id) {
        Funding funding = repository.findById(id).orElseThrow(IllegalArgumentException::new);
        FundingDto dto = FundingDto.toDto(funding);
        return dto;
    }

    @Override
    public Optional<Funding> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String detailRegister(FundingFileDto fundingFileDto) {
        FundingFile fundingFile = FundingFile.of(fundingFileDto);
        fundingFile.saveFileTitle(fundingFileDto);
        return (frepo.save(fundingFile) != null) ? "FileTitle save Success" : "FileTitle save Failed";
    }
    @Value("${shop.legossol.upload.path}")
    private String uploadPath;

    @Transactional
    @Override
    public ArrayList<FundingFileDto> registerFile(List<MultipartFile> uploadFiles) {
        ArrayList<FundingFileDto> resultDtoList = new ArrayList<>();
        for (MultipartFile uploadFile : uploadFiles) {

            String ofname = uploadFile.getOriginalFilename();
            int idx = ofname.lastIndexOf(".");
            String ofheader = ofname.substring(0, idx);
            String ext = ofname.substring(idx);
            String uuid = UUID.randomUUID().toString();
            StringBuilder sb = new StringBuilder();
            sb.append(uploadPath).append(ofheader).append("_").append(uuid).append(ext);
            String saveName = sb.toString();
            log.info("file upload name : " + saveName);
            Path savePath = Paths.get(saveName);
            try {
                uploadFile.transferTo(savePath);
                String thumbnailSaveName = uploadPath + "s_" + uuid + ofname;
                Thumbnails.of(new File(saveName)).size(100, 100).outputFormat("jpg").toFile(thumbnailSaveName);
                Thumbnails.of(new File(saveName)).scale(1)
                        .watermark(Positions.BOTTOM_CENTER, ImageIO.read(new File(uploadPath + "watermark.png")), 0.5f)
                        .toFile(new File(uploadPath + "w_" + uuid + ofname));
                FundingFileDto fundingFileDto = FundingFileDto.builder().uuid(uuid).fname(saveName).build();
                resultDtoList.add(fundingFileDto);
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultDtoList;
    }

    @Override
    public String deleteFile(Long fundingFileId) {
        frepo.deleteById(fundingFileId);
        return (frepo.findById(fundingFileId) == null) ? "Delete Success" : "Delete Failed";
    }
    /**===========================about page=========================*/
    @Override //확정 list
    public List<FundingDto> getListAllpage(Pageable pageable) {
        // pageable = PageRequest.of(, 6);
        return repository.findAll(pageable).stream().map(Funding->ModelMapperUtils.getModelMapper()
        .map(Funding, FundingDto.class)).collect(Collectors.toList());
    }

    @Override//비확정 search
    public Page<FundingDto> searchInPage(String title, String content, Pageable pageable) {
        // pageable = PageRequest.of(1, 6);
        return  FundingDto.toDtoPage(repository.searchIndex(title, content, pageable)); 
    }

    @Override
    public List<FundingDto> searchPost(Pageable pageable, String content, String keyword) {
        // pageable = PageRequest.of(1, 6);
        
        return repository.searchIndex(keyword, content,  pageable).stream().map(Funding->ModelMapperUtils.getModelMapper()
        .map(Funding, FundingDto.class)).collect(Collectors.toList());
    }
    //키워드 한방으로 제목+내용 검색
    @Override
    public Page<FundingDto> searchTitleAndContent(Pageable pageable, String title) {
        // pageable = PageRequest.of(1, 6);
        Page<Funding> find = repository.searchIndex(title, title, pageable);

        Page<FundingDto> result = FundingDto.toDtoPage(find);

        return result;
    }
    

}
