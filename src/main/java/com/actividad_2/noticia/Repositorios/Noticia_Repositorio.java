/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.actividad_2.noticia.Repositorios;

import com.actividad_2.noticia.Entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Noticia_Repositorio extends JpaRepository<Noticia, String> {
    
}
