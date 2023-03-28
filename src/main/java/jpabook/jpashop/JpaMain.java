package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] arg){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //persistence.xml에 있는 unit-name 적기 = 즉, 데이터베이스명
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김슬하");

            em.persist(book);

            tx.commit();


        }catch (Exception e){
            System.out.println(e);
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
