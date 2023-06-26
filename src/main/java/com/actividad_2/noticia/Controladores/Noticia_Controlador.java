/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.actividad_2.noticia.Controladores;

import Exception.MyException;
import com.actividad_2.noticia.Servicios.Noticia_Servicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticia")//localhost:8080/noticia
public class Noticia_Controlador {
    
    private Noticia_Servicio not_Servic; 
    
    @GetMapping("/inicio")//localhost:8080/noticia/inicio
    public String inicio(){
        return "inicio.html";
    }
    
    @GetMapping("/ingresar")//localhost:8080/noticia/ingresar
    public String ingresarnoticia(){
        return "noticia_form.html";
    }
    
    @PostMapping("/ingreso")//localhost:8080/noticia/ingreso
    public String ingresonoticia(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap modelo){
        
        try {
            not_Servic.CrearNoticia(titulo, cuerpo);
            modelo.put("exito", "Exito! La noticia ha sido cargada correctamente!!");
            
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            System.out.println("estoy aca");
            return "noticia_form.html";
        }
     
        
        return "inicio.html";
        
    } 
    
}
