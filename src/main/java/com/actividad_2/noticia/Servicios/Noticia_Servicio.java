/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.actividad_2.noticia.Servicios;

import Exception.MyException;
import com.actividad_2.noticia.Entidades.Noticia;
import com.actividad_2.noticia.Repositorios.Noticia_Repositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Noticia_Servicio {
    @Autowired
    private Noticia_Repositorio n_Repo;
    
    @Transactional
    public void CrearNoticia(String titulo, String cuerpo) throws MyException{
        
        Validar(titulo,cuerpo); 
        
        Noticia noticia = new Noticia(); 
        
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        
        n_Repo.save(noticia); 
        
    }
    
    public List<Noticia> ConsultarNoticias(){
        List<Noticia> noticias = new ArrayList();
        
        noticias = n_Repo.findAll();
        
        return noticias;
    }
    
    public void ModificarNoticia(String id, String titulo, String cuerpo) throws MyException{
        
        Validar(titulo,cuerpo); 
        
        Optional<Noticia> rta = n_Repo.findById(id); 
        
        if (rta.isPresent()) {
            
            Noticia noticia = rta.get(); 
            
            noticia.setCuerpo(cuerpo);
            noticia.setTitulo(titulo);
                 
            n_Repo.save(noticia);
        }
    }
    
    public void Validar(String titulo, String cuerpo) throws MyException{
        if (titulo == null || titulo.isEmpty()) {
            throw new MyException("El titulo no puede estar vacio");
        }
        
        if (cuerpo == null || cuerpo.isEmpty()) {
            throw new MyException("El cuerpo de la noticia no puede quedar vacio");
        }
    }
}
