package com.vaneks.crud.repository.jdbc;

import com.vaneks.crud.utils.HibernateSession;
import com.vaneks.crud.model.Developer;
import com.vaneks.crud.repository.DeveloperRepository;
import org.hibernate.Session;
import java.util.List;


public class JdbcDeveloperRepositoryImpl implements DeveloperRepository {

    @Override
    public List<Developer> getAll() {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        List<Developer> developers = session.createQuery("FROM Developer ").list();
        session.getTransaction().commit();
        return developers;
    }

    @Override
    public Developer getById(Long id) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, id);
        session.getTransaction().commit();
        return developer;
    }

    @Override
    public Developer save(Developer developer) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.save(developer);
        session.getTransaction().commit();
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.update(developer);
        session.getTransaction().commit();
        return developer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        Developer developer = (Developer) session.get(Developer.class, id);
        session.delete(developer);
        session.getTransaction().commit();
    }
}
