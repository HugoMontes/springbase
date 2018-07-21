package com.montes.springbase.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.montes.springbase.entity.NotaEntity;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Serializable> {

	// Busca por id
	public abstract NotaEntity findById(int id);

	// Busca por titulo
	public abstract List<NotaEntity> findByTitulo(String titulo);

	// Busca por nombre y titulo
	public abstract NotaEntity findByNombreAndTitulo(String nombre, String titulo);

	// Busca por nombre y id
	public abstract NotaEntity findByNombreAndId(String nombre, int id);
	
	@Query("select n from NotaEntity n where n.nombre = :nombre")
	public abstract List<NotaEntity> findByNotasNombre(@Param("nombre") String nombre);
}
