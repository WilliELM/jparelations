package ita3.jparelations.repository;

import ita3.jparelations.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICitizenRepository extends JpaRepository<Citizen,Long> {
    List<Citizen> findByTownName(String townName);
    List<Citizen> findByTownId(Long townId);


}
