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
    /*======================================only Entity========================================*/
    //findAll
    @Query("SELECT f FROM Funding f ORDER BY f.fundingId asc")
    List<Funding> getAllFundings();
    //글제목 검색 찾기
    @Query("SELECT f FROM Funding f WHERE f.title LIKE %:title%")
    List<Funding> searchFundingsByTitle(@Param("title") String title);

    // @Query("SELECT f FROM Funding f WHERE f.writer = :writer ORDER BY f.fundingId ")
    // List<Funding> findFundings(String writer,Sort sort);

    // @Modifying
    // @Query("UPDATE Funding f SET f.title = :title ")
    // int updateById(@Param("") String title);
    /*======================================bined with artist========================================*/
    //아티스트고유ID검색하여 작성글 찾기
    @EntityGraph(attributePaths = {"artist"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT f FROM Funding f WHERE f.artist.artistId = :artistId")
    List<Funding> searchAllListByArtistId(@Param("artistId") Long i);
    //아티스트고유ID검색하여 작성글 내용 빼고 찾기
    @EntityGraph(attributePaths = {"artist"}, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT f.title,f.goalPrice,f.viewCnt,f.hashtag FROM Funding f WHERE f.artist.artistId = :artistId")
    List<Funding> searchFundingByArtistId(@Param("artistId") Long i);

    
    /*=======================================page===================================================*/
    // @Query("SELECT f FROM Funding f WHERE f.title ORDER BY f.fundingId DESC")
    // Page<Funding> getAllFundingInPage(Pageable pageable);
    // @Query("SELECT f FROM Funding f WHERE f.hashtag = '음식' ORDER BY f.fundingId DESC")
    // Page<Funding> findAllUsingHashtag(Pageable pageable);
}
