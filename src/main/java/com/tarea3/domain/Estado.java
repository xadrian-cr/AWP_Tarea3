/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tarea3.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author adria
 */

@Data
@Entity
@Table(name="estado")
public class Estado implements Serializable {
    
    //Para utilizarlo en la generacion de la llave primaria autoincremental 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idEstado;
    
    String pais;
    String cantidadProvincias;
    String capital;
    String poblacion;

    public Estado() {
    }

    public Estado(String pais, String cantidadProvincias, String capital, String poblacion) {
        this.pais = pais;
        this.cantidadProvincias = cantidadProvincias;
        this.capital = capital;
        this.poblacion = poblacion;
    }
}
