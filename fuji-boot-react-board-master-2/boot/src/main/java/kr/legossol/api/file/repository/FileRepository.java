package kr.legossol.api.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.legossol.api.file.domain.FileVo;

@Repository
public interface FileRepository extends JpaRepository<FileVo, Long> {
}
