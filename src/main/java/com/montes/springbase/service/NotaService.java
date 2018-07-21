package com.montes.springbase.service;

import java.util.List;

import com.montes.springbase.bean.NotaBean;;

public interface NotaService {
	
	public abstract List<NotaBean> listar();

	public abstract NotaBean adicionar(NotaBean nota);

	public abstract boolean eliminar(int id);

	public abstract NotaBean actualizar(NotaBean nota);
	
	public abstract NotaBean buscarPorId(int id);
	
	public abstract List<NotaBean> buscarNotasPorNombre(String nombre);
	
}
