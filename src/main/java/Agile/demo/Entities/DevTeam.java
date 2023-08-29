package Agile.demo.Entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@DiscriminatorValue("DevTeam")
@Data
@NoArgsConstructor

public class DevTeam extends Collaborator {
    public DevTeam(Long id, String nom, String email) {
        super(id, nom, email);
    }
}
