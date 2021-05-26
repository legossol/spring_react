package kr.legossol.simpletodo.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.legossol.simpletodo.v1.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
