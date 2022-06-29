package com.tarea3.service;

import com.tarea3.dao.EstadoDao;
import com.tarea3.domain.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class EstadoServiceImpl implements EstadoService{

    //se crea en tiempo de ejecucion si no se ha creado, no requiere new
    @Autowired
    private EstadoDao estadoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Estado> getEstados(){
        return (List<Estado>) estadoDao.findAll();
    }
    
    @Override
    public void save (Estado estado){
        estadoDao.save(estado);
    }
    
    @Override
    public void delete (Estado estado){
        estadoDao.delete(estado);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Estado getEstado(Estado estado){
        return estadoDao.findById(estado.getIdEstado()).orElse(null);
    }
}
