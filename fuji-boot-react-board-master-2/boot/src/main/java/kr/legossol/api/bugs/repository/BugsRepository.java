package kr.legossol.api.bugs.repository;

import kr.legossol.api.bugs.domain.Bugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BugsRepository extends JpaRepository<Bugs, Long> {
    public Bugs findByBugsNo(String bugsNo);
    public List<Bugs> bugsFindALl();
}