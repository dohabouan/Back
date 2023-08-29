package Agile.demo.Service;

import Agile.demo.Entities.Collaborator;
import Agile.demo.Entities.Compte;
import Agile.demo.Entities.ProductOwner;
import Agile.demo.Entities.ScrumMaster;
import Agile.demo.Repository.CollaboratorRepository;
import Agile.demo.Repository.CompteRepository;
import Agile.demo.Repository.ProductOwnerRepository;
import Agile.demo.Repository.ScrumMasterRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CompteServiceImpl implements CompteService{
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private ProductOwnerRepository productOwnerRepository;
    @Autowired
    private ScrumMasterRepository scrumMasterRepository;
    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public Compte saveCompte(Compte compte) throws MessagingException {
        String password=initialePassword();
        if(compteRepository.findCompteByLogin(compte.getLogin())==null) {
            if (productOwnerRepository.findById(compte.getId()).isPresent()){
               ProductOwner productOwner = productOwnerRepository.findById(compte.getId()).get();
                emailSenderService.SendEmail(productOwner.getEmail(), "Welcome your password is :" + password, "Votre compte est pret !");
                return compteRepository.save(new Compte(null, compte.getLogin(), password, productOwner));
            } else {
                ScrumMaster scrumMaster = scrumMasterRepository.findById(compte.getId()).get();
                emailSenderService.SendEmail(scrumMaster.getEmail(), "Welcome your password is :" + password, "Votre compte est pret !");
                return compteRepository.save(new Compte(null, compte.getLogin(), password, scrumMaster));
            }
        }
        else
            return null;
    }

    @Override
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    @Override
    public Compte updateCompte(Compte compte) {
        Compte result =compteRepository.findById(compte.getId()).get();
        Collaborator collaborator=result.getCollaborator();
        collaboratorRepository.save(compte.getCollaborator());
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> getAllProductOwners() {
        List<Compte> comptes= new ArrayList<>();
        for (ProductOwner productOwner : productOwnerRepository.findAll()) {
            comptes.add(productOwner.getCompte());
        }
        return comptes;
    }


    @Override
    public List<Compte> getAllScrumMasters() {
        List<Compte> comptes = new ArrayList<>();
        for (ScrumMaster scrumMaster :scrumMasterRepository.findAll()) {
            comptes.add(scrumMaster.getCompte());
        }
        return comptes;
    }

    @Override
    public List<Compte> findCompte(String Login) {
        List<Compte> result =compteRepository.findCompteByLoginContaining(Login);
        return result;
    }

    @Override
    public void restartCompte(Long id) throws MessagingException {
        Compte c=compteRepository.findById(id).get();
        System.out.println(c.getLogin());
        String password=initialePassword();
        c.setPassword(password);
        emailSenderService.SendEmail(c.getLogin(),"Welcome your password is :"+password,"Votre compte est pret !");
        compteRepository.save(c);


    }

    @Override
    public boolean login(String login, String password) {
        return password.equals(compteRepository.findPasswordByLogin(login));
    }
    private String initialePassword(){
        String characteres="ABCDEFGHIJKLMNOPQRSTUVWXYZ@#";
        String randomString="";
        int length=8;
        Random rand=new Random();

        char[] password=new char[length];
        for (int i=0;i<length;i++){
            password[i]=characteres.charAt(rand.nextInt(characteres.length()));

        }
        for (int i=0;i<password.length;i++)
        {
            randomString+=password[i];
        }

        return randomString;
    }


    @Override
    public void deleteCompte(Long id) {
        Compte compte=compteRepository.findById(id).get();
        if(compte!=null){
            compteRepository.delete(compte);
        }
    }


    @Override
    public Compte findById(Long id) {
        return compteRepository.findById(id).get();
    }

    @Override
    public List<Compte> CompteWithNoUser() {
        return compteRepository.findAllByCollaboratorIsNull();
    }
}
