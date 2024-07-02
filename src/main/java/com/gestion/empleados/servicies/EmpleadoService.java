package com.gestion.empleados.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.empleados.models.Empleado;
import com.gestion.empleados.repositories.EmpleadoRepositorio;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    // Obtener todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepositorio.findAll();
    }

    // Obtener un empleado por ID
    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
        return empleadoRepositorio.findById(id);
    }

    // Guardar un nuevo empleado
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);  //con ese metodo save tambien puedo hacer modificaciones en postman, 
    }

    // Actualizar un empleado
    public Empleado actualizarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    // Eliminar un empleado por ID
    public boolean eliminarEmpleado(Long id) {
        try {
            empleadoRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
