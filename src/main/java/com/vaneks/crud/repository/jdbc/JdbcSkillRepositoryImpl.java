package com.vaneks.crud.repository.jdbc;

import com.vaneks.crud.model.Skill;
import com.vaneks.crud.repository.SkillRepository;
import com.vaneks.crud.utils.HibernateSession;
import org.hibernate.Session;
import java.util.List;

public class JdbcSkillRepositoryImpl implements SkillRepository {

    @Override
    public List<Skill> getAll() {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        List<Skill> skills = session.createQuery("FROM Skill").list();
        session.getTransaction().commit();
        return skills;
    }

    @Override
    public Skill getById(Long id) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        Skill skill = (Skill) session.get(Skill.class, id);
        session.getTransaction().commit();
        return skill;
    }

    @Override
    public Skill save(Skill skill) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.save(skill);
        session.getTransaction().commit();
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        session.update(skill);
        session.getTransaction().commit();
        return skill;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateSession.getSession();
        session.beginTransaction();
        Skill skill = (Skill) session.get(Skill.class, id);
        session.delete(skill);
        session.getTransaction().commit();
    }
}
