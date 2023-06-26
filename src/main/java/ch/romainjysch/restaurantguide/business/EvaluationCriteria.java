package ch.romainjysch.restaurantguide.business;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CRITERES_EVALUATION")
@NamedQuery(name = "EvaluationCriteria.researchAll", query = "select ec from EvaluationCriteria ec")
public class EvaluationCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CRITERES_EVALUATION")
    @SequenceGenerator(name = "SEQ_CRITERES_EVALUATION", sequenceName = "SEQ_CRITERES_EVALUATION", allocationSize = 1)
    @Column(name="numero", nullable = false, length = 10)
    private Integer id;

    @Column(name = "nom", unique = true, nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 512)
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

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
