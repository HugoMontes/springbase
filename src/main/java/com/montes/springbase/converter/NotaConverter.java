package com.montes.springbase.converter;

import org.springframework.stereotype.Component;

import com.montes.springbase.bean.NotaBean;
import com.montes.springbase.entity.NotaEntity;

@Component("notaConverter")
public class NotaConverter {

	// Transforma de un Entity a un model
	public NotaBean entityToBean(NotaEntity notaEntity) {
		NotaBean notaBean = new NotaBean();
		notaBean.setId(notaEntity.getId());
		notaBean.setNombre(notaEntity.getNombre());
		notaBean.setTitulo(notaEntity.getTitulo());
		notaBean.setContenido(notaEntity.getContenido());
		notaBean.setCreated(notaEntity.getCreated());
		notaBean.setUpdated(notaEntity.getUpdated());
		return notaBean;
	}

	// Transforma de un Model a un Entity
	public NotaEntity beanToEntity(NotaBean notaBean) {
		NotaEntity notaEntity = new NotaEntity();
		notaEntity.setId(notaBean.getId());
		notaEntity.setNombre(notaBean.getNombre());
		notaEntity.setTitulo(notaBean.getTitulo());
		notaEntity.setContenido(notaBean.getContenido());
		notaEntity.setCreated(notaBean.getCreated());
		return notaEntity;
	}

}
