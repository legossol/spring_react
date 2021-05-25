package kr.legossol.api.artist.service;

import kr.legossol.api.artist.domain.Artist;
import kr.legossol.api.artist.domain.ArtistDto;

public interface ArtistService {
    String signup(Artist artist);

    ArtistDto signin(Artist artist);

    // List<Artist> findAll();
    void deleteById(Long artistId);

}