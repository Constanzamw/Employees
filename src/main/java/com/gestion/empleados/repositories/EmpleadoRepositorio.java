package com.gestion.empleados.repositories;

// import org.springframework.data.jpa.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.models.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> { //le paso la entidad que es Empleado y el tipo de id que es Long
    
}
