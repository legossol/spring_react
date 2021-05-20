package kr.legossol.api.artist.service;

import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.artist.domain.ArtistDto;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    String signup(Artist artist);

    ArtistDto signin(Artist artist);

    // List<Artist> findAll();
    void deleteById(Long artistId);

}