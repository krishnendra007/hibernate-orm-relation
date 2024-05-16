package learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // Setting data in database 
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Laptop laptop = new Laptop();
        laptop.setLid(45);
        laptop.setLname("dell");

        Student s =new Student();
        s.setMarks(95);
        s.setName("krish");
        s.setRollno(1);
        //s.setLaptop(laptop);
        s.getLaptop().add(laptop);
        laptop.getStudent().add(s);

        session.persist(laptop);
        session.persist(s);

        tx.commit();

    



       

    }
}
