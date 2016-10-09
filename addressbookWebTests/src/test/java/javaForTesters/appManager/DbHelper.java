package javaForTesters.appManager;

import javaForTesters.model.AccountCreation;
import javaForTesters.model.Accounts;
import javaForTesters.model.GroupData;
import javaForTesters.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * Created by Антон on 09.10.2016.
 */
public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper(){
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }
  public Groups groups(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GroupData" ).list();
    for (GroupData group : result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
    return new Groups(result);

  }
  public Accounts accounts(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<AccountCreation> result = session.createQuery( "from AccountCreation where deprecated = '0000-00-00' ").list();
    for (AccountCreation contact : result) {
      System.out.println(contact);
    }
    session.getTransaction().commit();
    session.close();
    return new Accounts(result);
  }
  }
