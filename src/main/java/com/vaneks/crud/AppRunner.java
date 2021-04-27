package com.vaneks.crud;

import com.vaneks.crud.utils.HibernateSession;
import com.vaneks.crud.view.MainView;
import java.sql.SQLException;

public class AppRunner {
    public static void main(String[] args) throws SQLException {
        HibernateSession.getSession();
        MainView mainView = new MainView();
        mainView.showMainMenu();
        HibernateSession.getSession().close();
    }
}
