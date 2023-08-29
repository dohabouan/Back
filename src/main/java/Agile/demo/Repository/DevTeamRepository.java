package Agile.demo.Repository;

import Agile.demo.Entities.DevTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevTeamRepository extends JpaRepository<DevTeam,Long> {
}
