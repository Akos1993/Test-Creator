package com.akos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;

public class QuestionsDao implements Dao<String> {

    private EntityManager entityManager;

    @Override
    public List<String> getAll() {
        Query query = entityManager.createQuery("SELECT * FROM Test_Questions");
        return query.getResultList();
    }

    @Override
    public void save(String questions) {
        executeInsideTransaction(entityManager -> entityManager.persist(questions);
    }

    @Override
    public void update(String questions) {
        executeInsideTransaction(entityManager -> entityManager.merge(questions);
    }

    @Override
    public void delete(String questions) {
        executeInsideTransaction(entityManager -> entityManager.remove(questions));
    }

    public void updateID(int testID) {

    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
