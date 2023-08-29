package Agile.demo.Controller;

import Agile.demo.Entities.Compte;
import Agile.demo.Service.CollaboratorService;
import Agile.demo.Service.CompteService;
import Agile.demo.Service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping( "/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private CollaboratorService collaboratorService;



    @PostMapping(path="/save")
    public Compte saveCompte(@RequestBody Compte compte) throws MessagingException {
        return compteService.saveCompte(compte);
    }
    @GetMapping(path = "/all")
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @PutMapping(path = "/update")
    public Compte updateCompte(Compte compte) {
        return compteService.updateCompte(compte);
    }

    @GetMapping(path="/owners")
    public List<Compte> getAllProductOwners() {
        return compteService.getAllProductOwners();
    }

    @GetMapping(path="/masters")
    public List<Compte> getAllScrumMasters() {
        return compteService.getAllScrumMasters();
    }

    @GetMapping(path = "/find/{login}")
    public List<Compte> findCompte(@PathVariable String login) {
        return compteService.findCompte(login);
    }

    @PostMapping(path="/restart/{id}")
    public void restartCompte(@PathVariable Long id) throws MessagingException {
        compteService.restartCompte(id);
    }
    @PostMapping(path = "/connecter/{login}/{password}")
    public boolean login(@PathVariable String Login,@PathVariable String password) {
        return compteService.login(Login, password);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteService.deleteCompte(id);
    }

    @GetMapping(path = "/findid/{id}")
    public Compte findById(@PathVariable Long id) {
        return compteService.findById(id);
    }

    @GetMapping(path = "/NoUser")
    public List<Compte> CompteWithNoUser() {
        return compteService.CompteWithNoUser();
    }
}

