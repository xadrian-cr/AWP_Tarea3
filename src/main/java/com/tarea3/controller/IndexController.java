/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea3.controller;

import com.tarea3.domain.Estado;
import com.tarea3.service.EstadoService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author adria
 */
@Controller
@Slf4j
public class IndexController {
    
    //se crea en tiempo de ejecucion si no se ha creado, no requiere new
    @Autowired
    private EstadoService estadoService;
    
    @GetMapping("/")
    public String page(Model model) {
        log.info("ahora se usa arquitectura MVC");

        //lee todo el clientedao y se devuelve como una arraylist 
        var estados = estadoService.getEstados();
        model.addAttribute("estados", estados);
        
        return "index";
    }
    
    @GetMapping("/nuevoEstado")
    public String nuevoEstado(Estado estado){
        return "modificarEstado";
    }
    
    @PostMapping("/guardarEstado")
    public String guardarEstado(Estado estado){
        estadoService.save(estado);
        return "redirect:/";
    }
    
    @GetMapping("/modificarEstado/{idEstado}")
    public String modificarEstado(Estado estado, Model model){
        estado = estadoService.getEstado(estado);
        model.addAttribute("estado",estado);
        return "modificarEstado";
    }
    
    @GetMapping("/eliminarEstado/{idEstado}")
    public String eliminarEstado(Estado estado){
        estadoService.delete(estado);
        return "redirect:/";
    }
}