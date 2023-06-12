package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Table(name = "COMMENTAIRES")
public class CompleteEvaluation extends Evaluation {

    @Column(name = "COMMENTAIRE", nullable = false)
    @Lob
    private String comment;

    @Column(name = "NOM_UTILISATEUR", nullable = false, length = 100)
    private String username;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "completeEvaluation")
    private Set<Grade> grades;

    public void addGrade(Grade grade) {
        this.getGrades().add(grade);
        grade.setCompleteEvaluation(this);
    }

}
