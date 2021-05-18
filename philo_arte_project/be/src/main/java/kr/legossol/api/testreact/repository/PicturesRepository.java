package kr.legossol.api.testreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.legossol.api.testreact.entity.Pictures;

public interface PicturesRepository extends JpaRepository<Pictures, Long> {
}
