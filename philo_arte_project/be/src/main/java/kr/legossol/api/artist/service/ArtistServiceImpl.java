package kr.legossol.api.artist.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.artist.domain.ArtistDto;
import kr.legossol.api.artist.domain.Role;
import kr.legossol.api.artist.repository.ArtistRepository;
import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.security.domain.SecurityProvider;
import kr.legossol.api.security.exception.SecurityRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Log4j2
@RequiredArgsConstructor
@Service
public class ArtistServiceImpl extends AbstractService<Artist> implements ArtistService {

    private final ArtistRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;

    @Override
    public String signup(ArtistDto artistDto) {

        if(!repository.existsByUsername(artistDto.getUsername())){
            Artist entity = dtoEntity(artistDto);
            repository.saveAndFlush(entity);
            ArtistDto entityDto = entityDto(entity);
            entityDto.setPassword(passwordEncoder.encode(entityDto.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER_ROLES);
            entity.changeRoles(list);
            return provider.createToken(entityDto.getUsername(), entity.getRoles());
        } else {
            throw new SecurityRuntimeException("Artist Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @Override
    public ArtistDto signin(ArtistDto artistDto) {
        log.info("이건?2222222222222");
        try {
            Artist entity = dtoEntity(artistDto);
            log.info("::::::::::: 변환 ::::::::::::: " );
            log.info("entity.getUsername() :::::: " + entity.getUsername());
            log.info("entity.getPassword() :::::: " + entity.getPassword());

            repository.signin(entity.getUsername(), entity.getPassword());
            log.info("entity.getUsername() ::::::::::::: " + entity.getUsername());
            log.info("entity.getPassword() ::::::::::::: " + entity.getPassword());


            ArtistDto entityDto = entityDto(entity);
            log.info("entityDto :::::::::::: " + entityDto);
            // 인코더 수정하기
            String Token = (
                    (passwordEncoder.matches(entity.getPassword(), repository.findByUsername(entity.getUsername()).get().getPassword())
                    ) ?
                            provider.createToken(entity.getUsername(), repository.findByUsername(entity.getUsername()).get().getRoles())
                            : "WRONG_PASSWORD");

            entityDto.setToken(Token);
            log.info("=====================================");
            log.info("=====================================");
            log.info("entityDto 인코더 변환?::::: " + entityDto);
            log.info("Token 인코더 변환?::::: " + Token);
            log.info("=====================================");
            log.info("=====================================");
            log.info("다왔나?");
            return entityDto;
//            return null;
        } catch (Exception e){
            throw new SecurityRuntimeException("Invalid Artist-Username / Password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @Override
    public List<Artist> getAllData() {
        return repository.getAllData();
    }

    @Override
    public void deleteById(Long artistId) {
        repository.deleteById(artistId);
    }


    @Override
    public Long count() {
        return repository.count();
    }


    @Override
    public String delete(Artist artist) {
        repository.delete(artist);
        return repository.findById(artist.getArtistId()).orElse(null) == null ? "success" : "fail";
    }

    @Override
    public void deleteAll() {

    }




    @Override
    public String save(Artist artist) {

        return (repository.save(artist) != null) ? "success" : "fail" ;
    }

    @Override
    public Artist findById(Long artistId) {

        Artist artist = repository.findById(artistId).orElseThrow();

        return artist;
    }



    @Override
    public List<Artist> findAll() {
        return repository.getAllData();
    }

    @Override
    public ArtistDto updateById(ArtistDto artistDto) {
        Artist entity = dtoEntity(artistDto);
        repository.save(entity);
        ArtistDto dtoEntity = entityDto(entity);
        return dtoEntity;
    }

    @Override
    public Long register(ArtistDto artistDto) {

        log.info("DTO ===============");
        log.info(artistDto);

        Artist entity = dtoEntity(artistDto);
        log.info("entity ::::::::::::::");
        log.info(entity);

        repository.save(entity);

        return null;

    }


    @Override
    public Optional<Artist> getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Boolean existsById(long id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        
    }

}
