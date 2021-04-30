package kr.legossol.api.exhibition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.legossol.api.exhibition.domain.Exhibition;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
}
