package com.ejemplo.dao;

import java.util.List;

public interface GenericDAO<T> {
    T encontrarPorId(Long id);
    List<T> encontrarTodos();
    void guardar(T entidad);
    void actualizar(T entidad);
    void eliminar(T entidad);
}
