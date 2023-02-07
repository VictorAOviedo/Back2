package com.portfolio.victor.service;

import com.portfolio.victor.entity.Proyecto;
import com.portfolio.victor.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    IProyectoRepository iProyectoRepository;
    
    public List<Proyecto> list(){
        return iProyectoRepository.findAll ();
    }
    
    public Optional<Proyecto>getOne (int id){
        return iProyectoRepository.findById(id);
    }
    
    public Optional<Proyecto>getByNombrePro(String nombrePro){
        return iProyectoRepository.findByNombrePro(nombrePro);
    }
    
    public void save(Proyecto pro){
        iProyectoRepository.save(pro);
    }
    
    public void delete(int id){
        iProyectoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyectoRepository.existsById(id);
    }
    
    public boolean existsByNombrePro(String nombrePro){
        return iProyectoRepository.existsByNombrePro(nombrePro);
    }  
}