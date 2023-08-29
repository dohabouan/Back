package Agile.demo.Entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("PO")
@Data
@NoArgsConstructor

public class ProductOwner extends Collaborator{
    public ProductOwner(Long id, String nom, String email) {
        super(id, nom, email);
    }
}
