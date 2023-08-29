package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="livraison")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Release {
    @Id

    private Integer id;
    private Date date;
    private String notes;

    public Release(Integer id, Date date, String notes) {
        this.id = id;
        this.date = date;
        this.notes = notes;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sprint")
    @JsonIgnore
    private Sprint sprint;
    @OneToMany(mappedBy = "releases")

    private List<Feedback> feedbacks;
}