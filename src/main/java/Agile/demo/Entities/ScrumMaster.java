package Agile.demo.Entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("SM")
@Data
@NoArgsConstructor

public class ScrumMaster extends Collaborator{
    public ScrumMaster(Long id, String nom, String email) {
        super(id, nom, email);
    }
}
