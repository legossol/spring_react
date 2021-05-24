package kr.legossol.api.funding.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
import kr.legossol.api.funding.domain.FundingFile;
@Repository
public interface FundingRepository extends JpaRepository<Funding,Long>{
    /*======================================only Entity========================================*/
    //findAll
    @Query("SELECT f FROM Funding f ORDER BY f.fundingId asc")
    List<Funding> getAllFundings();
    @Query("SELECT f FROM Funding f WHERE f.fundingId = :fundingId")
    List<Funding> getOneFunding(Long id);
    //글제목 검색 찾기
    @Query("SELECT f FROM Funding f WHERE f.title LIKE %:title%")
    List<Funding> searchFundingsByTitle(@Param("title") String titleWord);
    //글내용 검색 찾기
    @Query("SELECT f FROM Funding f WHERE f.content LIKE %:index%")
    List<Funding> searchFundingByContent(@Param("index") String contentWord);
    //
    @Query("SELECT f FROM Funding f WHERE f.hashtag LIKE %:hashtag%")
    List<Funding> searchFundingByHashtag(@Param("hashtag") String hashtagName);
 
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
    //페이징 리스트
    @Query("SELECT f FROM Funding f ORDER BY f.fundingId desc")
    Page<Funding> getRecent(Pageable pageable);
    

    @Query(value = "SELECT f FROM Funding f WHERE f.title LIKE %:title% OR f.content LIKE %:content% ORDER BY f.fundingId desc",
           countQuery =  "SELECT COUNT(f.fundingId) FROM Funding f WHERE f.title LIKE %:title% OR f.content LIKE %:content%")
    Page<Funding> searchIndex(@Param("title")String title,@Param("content") String content, Pageable pageable);
    
}
