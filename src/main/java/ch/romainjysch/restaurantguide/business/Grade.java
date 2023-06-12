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
    @Column(name="NUMERO", nullable = false)
    private Integer id;

    @Column(name = "NOTE", nullable = false)
    private Integer note;

    @ManyToOne
    @JoinColumn(name = "FK_COMM")
    private CompleteEvaluation completeEvaluation;

    @ManyToOne
    @JoinColumn(name = "FK_CRIT")
    private EvaluationCriteria evaluationCriteria;

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
