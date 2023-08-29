package Agile.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
    @Id

    private Long id;
    private String login;
    private String password;
    @OneToOne
    private Collaborator collaborator;


    public Compte(Long id, String login, String password) {
        this.id = id;
        login = login;
        this.password = password;
    }
}

