package io.aturanj.sales.service;

import java.util.List;

public interface ISalesService<T> {

    public void create(T entity);

    public void edit(T entity);

    public void remove(T entity);

    public T find(Object id);

    public List<T> findAll();
}
