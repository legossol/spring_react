package kr.legossol.api.artist.service;

import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.artist.domain.ArtistDto;
import kr.legossol.api.artist.repository.ArtistRepository;
import kr.legossol.api.common.service.AbstractService;
import kr.legossol.api.security.domain.SecurityProvider;
import kr.legossol.api.security.exception.SecurityRuntimeException;
import kr.legossol.api.artist.domain.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl extends AbstractService<Artist> implements ArtistService {

    private final ArtistRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final ModelMapper modelMapper;

    @Override
    public String signup(Artist artist) {
        if (!repository.existsByName(artist.getUsername())) {
            artist.setPassword(passwordEncoder.encode(artist.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER_ROLES);
            artist.setRoles(list);
            repository.save(artist);
            return provider.createToken(artist.getUsername(), artist.getRoles());
        } else {
            throw new SecurityRuntimeException("Artist Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ArtistDto signin(Artist artist) {

        try {
            ArtistDto artistDto = modelMapper.map(artist, ArtistDto.class);
            artistDto.setToken((passwordEncoder.matches(artist.getPassword(),
                    repository.findByName(artist.getUsername()).get().getPassword()))
                            ? provider.createToken(artist.getUsername(),
                                    repository.findByName(artist.getUsername()).get().getRoles())
                            : "WRONG_PASSWORD");

            return artistDto;
        } catch (Exception e) {
            throw new SecurityRuntimeException("Invalid Artist-Username / Password supplied",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }

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
    public Optional<Artist> getOne(Long id) {
        return Optional.empty();
    }

    @Override
    public String delete(Artist artist) {
        repository.delete(artist);
        return (repository.findById(artist.getArtistId()).orElse(null) == null) ? "Delete Succes" : "Delete Failed";
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public String save(Artist artist) {
        return null;
    }

    // @Override
    // public Optional<Artist> findById(Long artistId) {
    // return repository.findById(artistId);
    // }

    @Override
    public List<Artist> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public Artist findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}