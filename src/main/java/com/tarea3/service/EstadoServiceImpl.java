
package com.tarea3.service;

import Estado.EstadoDao;
import com.tarea3.domain.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class EstadoServiceImpl implements EstadoService{

    //se crea en tiempo de ejecucion si no se ha creado, no requiere new
    @Autowired
    private EstadoDao EstadoDao;
    
    @Override
    @Transactional(readOnly = true)
    
    public List<Estado> getEstados() {
        return (List<Estado>) EstadoDao.findAll();
    }

    @Override
    public void save(Estado estado) {
        EstadoDao.save(estado);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
}
