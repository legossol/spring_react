package kr.legossol.api.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.legossol.api.artist.domain.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}