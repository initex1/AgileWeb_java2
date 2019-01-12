package lv.console.database.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class ORMRepository {

    @Autowired
    private SessionFactory session;

    protected Session session() {
        return session.getCurrentSession();
    }
}
