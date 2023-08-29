package Agile.demo.Service;

import Agile.demo.Entities.Backlog;
import Agile.demo.Entities.Collaborator;
import Agile.demo.Entities.ProductOwner;
import Agile.demo.Entities.ScrumMaster;

import java.util.List;

public interface CollaboratorService {

    Collaborator create (Collaborator collaborator);
    Collaborator findById(Long id);
    void delete(Long id);
    Collaborator update( Long id,Collaborator updatedCollaborator);
    List<Collaborator> findAll();
    List<ProductOwner> allProductOwner();
    List<ScrumMaster> allScrumMaster();

}
