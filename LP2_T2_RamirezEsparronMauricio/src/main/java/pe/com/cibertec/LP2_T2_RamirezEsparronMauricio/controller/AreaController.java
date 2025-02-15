package pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity.AreaEntity;
import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.service.AreaService;

import java.util.List;
@Controller
@RequestMapping("/area") // Cambia aquí
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/")
	public String home(Model model) {
		List<AreaEntity> listaAreas = areaService.buscarAreas();
		model.addAttribute("lista_area", listaAreas);
		return "listar_areas";
	}
	
	@GetMapping("/registrar_area")
	public String mostrarRegistrarArea(Model model) {
		model.addAttribute("area", new AreaEntity());
		return "registrar_area";
	}
	
	@PostMapping("/registrar_area")
	public String registrarArea(@ModelAttribute("area") AreaEntity area, Model model) {
		areaService.crearArea(area);
		return "redirect:/area/"; 
	}
	
	@GetMapping("/detalle_area/{id}")
	public String verDetalle(Model model, @PathVariable("id") Integer id) {
		AreaEntity area = areaService.buscarAreaPorId(id);
		model.addAttribute("area", area);
		return "detalle_area";
	}

	@GetMapping("/delete/{id}")
	public String deleteArea(Model model, @PathVariable("id") Integer id) {
		areaService.eliminarArea(id);
		return "redirect:/area/"; 
	}
	
	@GetMapping("/editar_area/{id}")
	public String mostrarActualizar(@PathVariable("id") Integer id, Model model) {
		AreaEntity area = areaService.buscarAreaPorId(id);
		model.addAttribute("area", area);
		return "editar_area";
	}
	
	@PostMapping("/editar_area/{id}")
	public String actualizarArea(@PathVariable("id") int id, @ModelAttribute("area") AreaEntity area, Model model) {
	    try {
	        // Actualizar el área en el servicio, pasando el ID y el objeto de área
	        areaService.actualizarArea(id, area);
	        return "redirect:/area/"; // Redirige a la lista de áreas después de la actualización
	    } catch (Exception e) {
	        model.addAttribute("error", "No se pudo actualizar el área. Intente nuevamente.");
	        return "error"; // Redirige a la página de error si hay una excepción
	    }
	}
}
