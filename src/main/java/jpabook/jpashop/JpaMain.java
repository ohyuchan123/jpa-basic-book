package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        //등록
        try {
            ts.commit();//ts(transaction)을 commit하는 시점에 영속성 컨테스트가 db에 들어가게 된다.
        }catch (Exception e){
            ts.rollback();
        }finally {
            //code
            em.close();
        }
        emf.close();
    }
}
