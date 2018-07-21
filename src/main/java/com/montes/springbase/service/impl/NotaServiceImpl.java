package com.montes.springbase.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.montes.springbase.bean.NotaBean;
import com.montes.springbase.converter.NotaConverter;
import com.montes.springbase.entity.NotaEntity;
import com.montes.springbase.repository.NotaRepository;
import com.montes.springbase.service.NotaService;

@Service("notaService")
public class NotaServiceImpl implements NotaService {
	
	@Autowired
	@Qualifier("notaRepository")
	private NotaRepository notaRepository;

	@Autowired
	@Qualifier("notaConverter")
	private NotaConverter notaConverter;


	@Override
	public List<NotaBean> listar() {
		List<NotaEntity> notasEntity = notaRepository.findAll();
		List<NotaBean> notasBean=new ArrayList<>();
		for(NotaEntity nota: notasEntity) {
			notasBean.add(notaConverter.entityToBean(nota));
		}
		return notasBean;
	}

	@Override
	public NotaBean adicionar(NotaBean notaBean) {
		try {
			NotaEntity notaEntity=notaRepository.save(notaConverter.beanToEntity(notaBean));
			return notaConverter.entityToBean(notaEntity);
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public boolean eliminar(int id) {
		try {
			NotaEntity nota=notaRepository.findById(id);
			notaRepository.delete(nota);
			return true;
		}catch(Exception ex){
			return false;
		}

	}
	

	@Override
	public NotaBean actualizar(NotaBean notaBean) {
		try {
			NotaEntity notaEntity = notaRepository.findById(notaBean.getId());
			if (notaEntity != null) {
				notaBean.setCreated(notaEntity.getCreated());
				notaEntity=notaRepository.save(notaConverter.beanToEntity(notaBean));
				return notaConverter.entityToBean(notaEntity);
			}
			return null;			
		}catch(Exception ex){
			return null;
		}
	}
	
	@Override
	public NotaBean buscarPorId(int id) {
		try {
			NotaEntity notaEntity=notaRepository.findById(id);
			return notaConverter.entityToBean(notaEntity);
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public List<NotaBean> buscarNotasPorNombre(String nombre) {
		List<NotaEntity> notasEntity = notaRepository.findByNotasNombre(nombre);
		List<NotaBean> notasBean=new ArrayList<>();
		for(NotaEntity nota: notasEntity) {
			notasBean.add(notaConverter.entityToBean(nota));
		}
		return notasBean;
	}

}
