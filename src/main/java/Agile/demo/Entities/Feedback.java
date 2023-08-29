package Agile.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="feedbacks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id

    private Integer id;
    private String description;
    private Date date;
    private String author;

    public Feedback(Integer id, String description, Date date, String author) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.author = author;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Release releases;


}
