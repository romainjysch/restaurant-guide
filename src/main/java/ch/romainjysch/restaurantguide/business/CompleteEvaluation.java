package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "COMMENTAIRES")
public class CompleteEvaluation extends Evaluation {

    @Column(name = "commentaire", nullable = false)
    @Lob
    private String comment;

    @Column(name = "nom_utilisateur", nullable = false, length = 100)
    private String username;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "completeEvaluation", fetch = FetchType.EAGER)
    private Set<Grade> grades;

    public CompleteEvaluation() {}

    public CompleteEvaluation(Integer id, LocalDate visitDate, Restaurant restaurant, String comment,
                              String username) {
        super(id, visitDate, restaurant);
        this.comment = comment;
        this.username = username;
        this.grades = new HashSet<>();
    }

    public void addGrade(Grade grade) {
        this.getGrades().add(grade);
        grade.setCompleteEvaluation(this);
    }

}
