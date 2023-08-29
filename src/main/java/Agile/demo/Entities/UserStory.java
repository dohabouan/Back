package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="userstory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStory {
    @Id

    private Integer id;
    private String description;

    public UserStory(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Team team;
    @OneToMany(mappedBy = "userStory")
    private List<Sprint> sprints;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Backlog backlog;
}
