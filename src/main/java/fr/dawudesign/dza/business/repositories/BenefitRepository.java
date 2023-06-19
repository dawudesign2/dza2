package fr.dawudesign.dza.business.repositories;

import fr.dawudesign.dza.business.entities.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {
}
