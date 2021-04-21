package com.akos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class QuestionsDao implements Dao<Questions> {

    private EntityManager entityManager;

    @Override
    public List<Questions> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM e");
        return query.getResultList();
    }

    @Override
    public void save(Questions questions) {
        entityManager.persist(questions);
    }

    @Override
    public void update(Questions questions) {
        entityManager.merge(questions);
    }

    @Override
    public void delete(Questions questions) {
        entityManager.remove(questions);
    }
}
