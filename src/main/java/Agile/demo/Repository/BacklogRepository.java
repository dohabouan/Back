package Agile.demo.Repository;

import Agile.demo.Entities.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog,Integer> {
}
