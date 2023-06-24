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
@Table(name = "CRITERES_EVALUATION")
@NamedQuery(name = "EvaluationCriteria.researchAll", query = "select ec from EvaluationCriteria ec")
public class EvaluationCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CRITERES_EVALUATION")
    @SequenceGenerator(name = "SEQ_CRITERES_EVALUATION", sequenceName = "SEQ_CRITERES_EVALUATION", allocationSize = 1)
    @Column(name="NUMERO", nullable = false)
    private Integer id;

    @Column(name = "NOM", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "DESCRIPTION", length = 512)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationCriteria that = (EvaluationCriteria) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
