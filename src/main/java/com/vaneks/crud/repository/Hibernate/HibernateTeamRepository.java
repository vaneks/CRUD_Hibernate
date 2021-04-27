package com.vaneks.crud.repository.Hibernate;

import com.vaneks.crud.model.Team;
import com.vaneks.crud.repository.TeamRepository;
import com.vaneks.crud.utils.HibernateSession;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateTeamRepository implements TeamRepository {

    @Override
    public void deleteAll() {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        String hql = "DELETE Team WHERE teamStatus = 'DELETED'";
        Query query = session.createQuery(hql);
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public List<Team> getAll() {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        List<Team> teams = session.createQuery("FROM Team").list();
        session.getTransaction().commit();
        return teams;
    }

    @Override
    public Team getById(Long id) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        Team team = (Team) session.get(Team.class, id);
        session.getTransaction().commit();
        return team;
    }

    @Override
    public Team save(Team team) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.save(team);
        session.getTransaction().commit();
        return team;
    }

    @Override
    public Team update(Team team) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.merge(team);
        session.getTransaction().commit();
        return team;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        String hql = "UPDATE Team SET teamStatus = 'DELETED' WHERE id =: id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
        session.getTransaction().commit();
    }
}
