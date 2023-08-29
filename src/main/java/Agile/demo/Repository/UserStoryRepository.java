package Agile.demo.Repository;

import Agile.demo.Entities.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory,Integer> {
}
