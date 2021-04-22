package com.vaneks.crud;

import com.vaneks.crud.model.Skill;
import com.vaneks.crud.utils.JdbcUtils;
import com.vaneks.crud.view.MainView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class AppRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) throws SQLException {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Skill skill = new Skill();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        session.q
        transaction.commit();
        session.close();

        MainView mainView = new MainView();
        JdbcUtils.getJdbcUtils();
        mainView.showMainMenu();
        JdbcUtils.getConnection().close();
    }
}
