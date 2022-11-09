package kodlama.io.devs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="sub_technologies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="technology_id")
    private Technology technology;
}
