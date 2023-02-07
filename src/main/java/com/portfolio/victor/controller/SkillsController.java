package com.portfolio.victor.controller;

import com.portfolio.victor.dto.DtoSkills;
import com.portfolio.victor.entity.Skills;
import com.portfolio.victor.security.controller.Mensaje;
import com.portfolio.victor.service.SkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "https://portfoliovao.web.app")
public class SkillsController {
    @Autowired
    SkillsService skillsService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.BAD_REQUEST);
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills){
        if(StringUtils.isBlank(dtoSkills.getNombreSkills()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillsService.existsByNombreSkills(dtoSkills.getNombreSkills()))
            return new ResponseEntity(new Mensaje("El skills ya existe"), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtoSkills.getNombreSkills(), dtoSkills.getImagenSkills(), dtoSkills.getPorcentajeSkills(), dtoSkills.getColorPrimarioSkills(), dtoSkills.getColorSecundarioSkills());
        skillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("Skills agregada"), HttpStatus.OK);       
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(skillsService.existsByNombreSkills(dtoSkills.getNombreSkills()) && skillsService.getByNombreSkills(dtoSkills.getNombreSkills()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La skills ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoSkills.getNombreSkills()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skills skills = skillsService.getOne(id).get();
        skills.setNombreSkills(dtoSkills.getNombreSkills());
        skills.setImagenSkills(dtoSkills.getImagenSkills());
        skills.setPorcentajeSkills(dtoSkills.getPorcentajeSkills());
        skills.setColorPrimarioSkills(dtoSkills.getColorPrimarioSkills());
        skills.setColorSecundarioSkills(dtoSkills.getColorSecundarioSkills());
        
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skills actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);       
    }   
}
