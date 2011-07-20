package com.george.jpa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Generic DAO based on http://blog.caelum.com.br/customizando-a-producao-de-dependencias-no-cdi/
 * 
 * @author george
 * 
 * @param <T>
 */
public class DAO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Class<T> classe;
    private final EntityManager em;

    public DAO(Class<T> classe, EntityManager entityManager) {
        this.em = entityManager;
        this.classe = classe;
    }

    public void adiciona(T obj) {
        em.persist(obj);
    }

    public void remove(T obj) {
        em.remove(obj);
    }

    public void atualiza(T obj) {
        em.merge(obj);
    }

    public List<T> listaTodos() {
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.from(classe);
        return em.createQuery(query).getResultList();
    }

    public T buscaPorId(Long id) {
        return em.find(classe, id);
    }
}