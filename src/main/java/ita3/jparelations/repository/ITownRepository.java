package ita3.jparelations.repository;

import ita3.jparelations.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITownRepository extends JpaRepository<Town,Long> {
}
