package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="sprint")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {
    @Id

    private Integer id;
    private String description;
    private Date startdate;
    private Date enddate;

    public Sprint(Integer id, String description, Date startdate, Date enddate, Statut statut) {
        this.id = id;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
        this.statut = statut;
    }

    @Enumerated(value = EnumType.STRING)
    private Statut statut;
    @ManyToOne
    @JsonIgnore
    private UserStory userStory;
    @OneToMany(mappedBy ="sprint" )
    private List<Task>tasks;
    @OneToMany(mappedBy = "sprint")
    @JsonIgnore
    private List<Release> releases;

}
