package edu.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.idat.pe.model.*;

@Repository
public interface DelegadoRepository extends JpaRepository<Delegado, Integer> {

}
