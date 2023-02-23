package com.example.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.data.model.ListaCompra;

@Repository
public interface ListaCompraRepository extends CrudRepository<ListaCompra, Long> {

}
