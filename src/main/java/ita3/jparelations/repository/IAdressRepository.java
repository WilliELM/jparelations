package ita3.jparelations.repository;

import ita3.jparelations.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdressRepository extends JpaRepository<Adress,Long> {
}
