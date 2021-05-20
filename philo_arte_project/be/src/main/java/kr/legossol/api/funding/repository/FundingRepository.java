package kr.legossol.api.funding.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.legossol.api.funding.domain.Funding;
import kr.legossol.api.funding.domain.FundingDto;
@Repository
public interface FundingRepository extends JpaRepository<Funding,Long>{
    // @EntityGraph(attributePaths = {"artist"}, type = EntityGraph.EntityGraphType.FETCH)
    // @Query("SELECT f FROM Funding f join m.artist a WHERE a.artistId=:artistId")
    // List<Funding> resultAllListByArtistId();

    @Query("SELECT f FROM Funding f WHERE f.hashtag = :hashtag")
    List<Funding> findAllByHashtag(String name);
    
    // @Query("SELECT f FROM Funding f JOIN f.artist a WHERE a.artistId =:artistId ")
    // List<Funding> findFundingsByArtistId(Long id);


    // @Query("SELECT f FROM Funding f WHERE f.writer = :writer ORDER BY f.fundingId ")
    // List<Funding> findFundings(String writer,Sort sort);

    // @Query("SELECT f FROM Funding f ORDER BY f.fundingId ")
    // List<Funding> getAllFundings();

    // @Query(value = "SELECT * FROM Funding ORDER BY id", countQuery = "SELECT count(*) FROM Funding")
    // Page<Funding> findAllFundingsWithPage(Pageable  pageable);

    // @Query("SELECT f FROM Funding f WHERE f.fundingId = :fundingId")
    // Optional<Funding> findByFundingId(long id);

    // @Modifying
    // @Query("UPDATE Funding f SET f.title = :title ")
    // int updateById(@Param("") String title);

    // @Query("SELECT f.title FROM Funding f ORDER BY f.fundingId desc")
    // Page<Funding> findAllFundingTitleWithPage(Pageable pageable);
    
    // @Query("INSERT INTO Fundings VALUES (title, content, goalPrice, hashtag")
    // int makeOne(String title,String content, String goalprice, String hashtag);
    // @Query("INSERT INTO FUNDINGS VALUES (title,content,goalPrice,hashtag")
    // int saveFunding(FundingDto dto);
    
}
