package Agile.demo.Service;

import Agile.demo.Entities.Collaborator;
import Agile.demo.Entities.ProductOwner;
import Agile.demo.Entities.ScrumMaster;
import Agile.demo.Repository.CollaboratorRepository;

import Agile.demo.Repository.ProductOwnerRepository;
import Agile.demo.Repository.ScrumMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {
    private CollaboratorRepository collaboratorRepository;
    @Autowired
    private ProductOwnerRepository productOwnerRepository;
    @Autowired
    private ScrumMasterRepository scrumMasterRepository;

    public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }


    @Override
    public Collaborator create(Collaborator collaborator) {
        return collaboratorRepository.save(collaborator);
    }

    @Override
    public Collaborator findById(Long id) {
        return collaboratorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Collaborator not found"));
    }

    @Override
    public void delete(Long id) {
        Collaborator collaborator=collaboratorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Collaborator not found"));
        collaboratorRepository.delete(collaborator);

    }

    @Override
    public Collaborator update(Long id, Collaborator updatedCollaborator){
        Collaborator collaborator1=collaboratorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Collaborator not found"));
        collaborator1.setId(updatedCollaborator.getId());
        collaborator1.setNom(updatedCollaborator.getNom());
        collaborator1.setTeam(updatedCollaborator.getTeam());
        collaborator1.setEmail(updatedCollaborator.getEmail());
        return collaboratorRepository.save(collaborator1);
    }

    @Override
    public List<Collaborator> findAll() {
        return collaboratorRepository.findAll();
    }

    @Override
    public List<ProductOwner> allProductOwner() {
        return productOwnerRepository.findAll();
    }

    @Override
    public List<ScrumMaster> allScrumMaster() {
        return scrumMasterRepository.findAll();
    }


}
