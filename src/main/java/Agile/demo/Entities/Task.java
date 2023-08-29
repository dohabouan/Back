package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id

    private Integer id;
    private String description;
    private String Priority;

    public Task(Integer id, String description, String priority, Statut statut) {
        this.id = id;
        this.description = description;
        Priority = priority;
        this.statut = statut;
    }

    @Enumerated(value = EnumType.STRING)
    private Statut statut;

    @ManyToOne
    @JsonIgnore
    private Sprint sprint;

}




