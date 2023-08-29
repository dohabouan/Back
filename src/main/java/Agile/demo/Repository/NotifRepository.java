package Agile.demo.Repository;

import Agile.demo.Entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotifRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByReadFalseOrderByCreatedAtDesc();
}
