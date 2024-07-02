package com.gestion.empleados.controllers;
//SOLICITUDES HTTP
// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.gestion.empleados.repositories.EmpleadoRepositorio;
import com.gestion.empleados.servicies.EmpleadoService;
import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.models.Empleado;

@RestController // va a ser una api rest
@RequestMapping(value = "/api/v1/")

public class EmpleadoControlador {

    @Autowired // para que se instancie automáticamente
    private EmpleadoService empleadoService;
/* 
private EmpleadoService empleadoService tiene el propósito de declarar una dependencia en el servicio EmpleadoService. 
Esta dependencia es inyectada automáticamente por Spring gracias a la anotación @Autowired. 
 */


    // Obtener todos los empleados
    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados() {
        return empleadoService.obtenerTodosLosEmpleados();
    }

    // Obtener un empleado por ID
    @GetMapping("/empleados/{id}")
    public Optional<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        return empleadoService.obtenerEmpleadoPorId(id);
    }

    // Crear un nuevo empleado
    @PostMapping("/empleados")
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
        // return this.usuarioService.guardarUsuario(usuario); 
    }

    // Actualizar un empleado existente
    // @PutMapping("/empleados/{id}")
    // public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetalles) {
    //     Empleado empleado = empleadoService.obtenerEmpleadoPorId(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con ID: " + id));
    //     empleado.setNombre(empleadoDetalles.getNombre());
    //     empleado.setApellido(empleadoDetalles.getApellido());
    //     empleado.setEmail(empleadoDetalles.getEmail());
    //     return empleadoService.actualizarEmpleado(empleado);
    // }

    // Eliminar un empleado
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean empleadoExiste = empleadoService.obtenerEmpleadoPorId(id).isPresent();
        if (!empleadoExiste) {
            throw new ResourceNotFoundException("Empleado no encontrado con ID: " + id);
        }
        
        boolean ok = empleadoService.eliminarEmpleado(id);
        if (ok) {
            return "Se eliminó el empleado con id " + id;
        } else {
            return "No se pudo eliminar el empleado con id " + id;
        }
    }
}
//     public String eliminarPorId(@PathVariable("id") Long id){
//      boolean ok = this.empleadoService.eliminarEmpleado(id);
//      if (ok){
//         return "Se eliminó el usuario con id " + id;
//     } else {
//         return "No se pudo eliminar el usuario con id " + id;
//     }
// }
//}




//

// public class EmpleadoControlador {

//     @Autowired //para que se instancie automaticamente
//     private EmpleadoRepositorio repositorio;

//     // para indicarle que cuando llegue una peticiond etipo GET ejecute este flujo obetener usuario
//     @GetMapping("/empleados")
//     public List<Empleado> listarTodosLosEmpleados() {
//         return repositorio.findAll();
//     }
   


// }