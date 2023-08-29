package Agile.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="backlog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Backlog {
    @Id

    private Integer id;
    private String description;
    private String priority;
    @OneToMany(mappedBy = "backlog")
    private List<UserStory> userStories;

    public Backlog(Integer id, String description, String priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }
}
