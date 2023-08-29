package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COLLAB",discriminatorType = DiscriminatorType.STRING,length = 10)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include =JsonTypeInfo.As.PROPERTY,property = "type")

@JsonSubTypes({
        @JsonSubTypes.Type(name="PO",value = ProductOwner.class),
        @JsonSubTypes.Type(name = "SM",value = ScrumMaster.class),
        @JsonSubTypes.Type(name ="DevTeam",value = DevTeam.class)
})
@Table(name="collaborator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Collaborator {
    @Id

    private Long id;
    private String nom;
    private String email;
    @ManyToOne
    @JsonIgnore
    private Team team;
    @OneToOne(mappedBy = "collaborator",fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Compte compte;


    public Collaborator(Long id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }
}
