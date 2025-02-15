package pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.service;

import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity.EmpleadoEntity;

import java.util.List;

public interface EmpleadosService {
    List<EmpleadoEntity> buscarEmpleados();
    void crearEmpleado(EmpleadoEntity empleado);
    EmpleadoEntity buscarEmpleadoPorDni(String dni);
    List<EmpleadoEntity> buscarEmpleadosPorArea(Integer areaId);
    void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity);
    void eliminarEmpleado(String dni);
    List<EmpleadoEntity> buscarEmpleadosPorNombre(String nombre);
    List<EmpleadoEntity> buscarEmpleadosPorApellido(String apellido);
}
