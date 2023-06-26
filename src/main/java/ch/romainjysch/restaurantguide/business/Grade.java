package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@ToString
@Entity
@Table(name = "NOTES")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTES")
    @SequenceGenerator(name = "SEQ_NOTES", sequenceName = "SEQ_NOTES", allocationSize = 1)
    @Column(name="numero", nullable = false, length = 10)
    private Integer id;

    @Column(name = "note", nullable = false, length = 3)
    private Integer note;

    @ManyToOne
    @JoinColumn(name = "fk_comm", nullable = false)
    private CompleteEvaluation completeEvaluation;

    @ManyToOne
    @JoinColumn(name = "fk_crit", nullable = false)
    private EvaluationCriteria evaluationCriteria;

    public Grade() {}

    public Grade(Integer note, CompleteEvaluation completeEvaluation,
                 EvaluationCriteria evaluationCriteria) {
        this.id = id;
        this.note = note;
        this.completeEvaluation = completeEvaluation;
        this.evaluationCriteria = evaluationCriteria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(id, grade.id);
    }

    @Override
    public int hashCode() {
        return 42;
    }

}
