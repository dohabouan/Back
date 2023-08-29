package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="projet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id

    private Integer id;
    private Date startDate;
    private Date endDate;

    public Project(Integer id, Date startDate, Date endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Team team;



}
