package com.portfolio.victor.repository;

import com.portfolio.victor.entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto> findByNombrePro (String nombrePro);
    public boolean existsByNombrePro (String nombrePro);
}
