package kr.legossol.api.testreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.legossol.api.testreact.entity.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {


}
