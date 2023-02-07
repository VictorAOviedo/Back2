package com.portfolio.victor.service;

import com.portfolio.victor.entity.Skills;
import com.portfolio.victor.repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    @Autowired
    ISkillsRepository iSkillsRepository;
    
    public List<Skills> list(){
        return iSkillsRepository.findAll ();
    }
    
    public Optional<Skills>getOne (int id){
        return iSkillsRepository.findById(id);
    }
    
    public Optional<Skills>getByNombreSkills(String nombreSkills){
        return iSkillsRepository.findByNombreSkills(nombreSkills);
    }
    
    public void save(Skills skills){
        iSkillsRepository.save(skills);
    }
    
    public void delete(int id){
        iSkillsRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iSkillsRepository.existsById(id);
    }
    
    public boolean existsByNombreSkills(String nombreSkills){
        return iSkillsRepository.existsByNombreSkills(nombreSkills);
    }   
}
