package com.portfolio.victor.repository;

import com.portfolio.victor.entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByNombreSkills (String nombreSkills);
    public boolean existsByNombreSkills (String nombreSkills);   
}
