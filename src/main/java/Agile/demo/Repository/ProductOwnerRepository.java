package Agile.demo.Repository;

import Agile.demo.Entities.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ProductOwnerRepository extends JpaRepository<ProductOwner,Long> {

}
