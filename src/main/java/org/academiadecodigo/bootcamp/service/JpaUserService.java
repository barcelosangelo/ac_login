package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class JpaUserService implements UserService {


    private EntityManagerFactory emf;


    public JpaUserService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public void addUser(User user) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {

            {
                if (em != null) {
                    em.close();
                }
            }

        }

    }

    @Override
    public User findByName(String username) {

        EntityManager em = emf.createEntityManager();

        try {

            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);

            Root<User> root = criteriaQuery.from(User.class);

            criteriaQuery.select(root);

            criteriaQuery.where(builder.equal(root.get("username"), username));

            return em.createQuery(criteriaQuery).getSingleResult();

        } finally {
            if (em != null) {
                em.close();
            }
            return null;
        }

    }

    @Override
    public int count() {
        return 0;
    }
}
