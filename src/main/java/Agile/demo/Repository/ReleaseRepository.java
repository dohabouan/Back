package Agile.demo.Repository;



import Agile.demo.Entities.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Release,Integer> {
}
