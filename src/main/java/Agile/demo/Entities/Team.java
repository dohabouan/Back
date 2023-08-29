package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id

    private Integer id;

    public Team(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Collaborator> collaborators;
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<UserStory> userStories;
    @OneToMany(mappedBy = "team")
    private List<Project> projects;
}
