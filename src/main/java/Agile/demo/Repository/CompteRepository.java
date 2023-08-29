package Agile.demo.Repository;

import Agile.demo.Entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {

    public Compte findCompteByLogin(String login);
    public List<Compte> findCompteByLoginContaining(String login);
    @Query("select c.password from Compte c where c.login =:login")
    public String findPasswordByLogin(String login);
    public List<Compte> findAllByCollaboratorIsNull();
}


