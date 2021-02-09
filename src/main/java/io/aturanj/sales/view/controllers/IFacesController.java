package io.aturanj.sales.view.controllers;

import java.util.List;

public interface IFacesController<T> {

//    public void create(T entity);
//
//    public void edit(T entity);
//
//    public void remove(T entity);
//
//    public T find(Object id);
    public List<T> findAll();
}
