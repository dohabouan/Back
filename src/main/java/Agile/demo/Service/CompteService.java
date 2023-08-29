package Agile.demo.Service;

import Agile.demo.Entities.Compte;
import jakarta.mail.MessagingException;

import java.util.List;

public interface CompteService {
    public Compte saveCompte(Compte compte) throws MessagingException;

    public List<Compte> getAllComptes();

    public Compte updateCompte(Compte compte);

    public List<Compte> getAllProductOwners();

    public List<Compte> getAllScrumMasters();

    public List<Compte> findCompte(String Login);

    public void restartCompte(Long id) throws MessagingException;

    public boolean login(String Login, String password);

    public void deleteCompte(Long id);
    public Compte findById(Long id);

    public List<Compte> CompteWithNoUser();

}
