package kodlama.io.devs.repositories;

import kodlama.io.devs.models.SubTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTechnologyRepository extends JpaRepository<SubTechnology, Integer> {
    SubTechnology findByName (String name);
}
