package com.montes.springbase.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.montes.springbase.bean.NotaBean;
import com.montes.springbase.service.NotaService;
import com.montes.springbase.util.JsonResult;

@RestController
@RequestMapping("/nota")
public class NotaController {

	private static final Log LOGGER = LogFactory.getLog(NotaController.class);

	@Autowired
	@Qualifier("notaService")
	private NotaService notaService;

	@GetMapping("/listar")
	public List<NotaBean> listarNotas() {
		LOGGER.info("METHOD: listarNotas()");
		return notaService.listar();
	}

	@PostMapping("/adicionar")
	public NotaBean agregarNota(@RequestBody @Valid NotaBean nota) {
		LOGGER.info("METHOD: agregarNota() | PARAMS: " + nota);
		return notaService.adicionar(nota);
	}

	@PostMapping("/modificar")
	public NotaBean modificarNota(@RequestBody @Valid NotaBean nota) {
		LOGGER.info("METHOD: modificarNota() | PARAMS: " + nota);
		NotaBean notaBean=notaService.actualizar(nota);
		if(notaBean==null) {
			
		}
		return notaBean;
	}
	
	@GetMapping("/eliminar/{id}")
	public JsonResult eliminarNotas(@PathVariable("id") int id) {
		LOGGER.info("METHOD: eliminarNotas()");
		JsonResult result= new JsonResult();
		if(notaService.eliminar(id)) {
			result.setStatus(200);
			result.setMessage("El registro fue eliminado");
		}else {
			throw new SecurityException("No se encuentra el registro con id " + id);
		}
		return result;
	}

	@GetMapping("/buscar/nombre/{nombre}")
	public List<NotaBean> buscarNotas(@PathVariable("nombre") String nombre) {
		LOGGER.info("METHOD: buscarNotas()");
		return notaService.buscarNotasPorNombre(nombre);
	}

}
