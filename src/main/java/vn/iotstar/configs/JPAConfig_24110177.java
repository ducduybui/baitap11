package vn.iotstar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig_24110177 {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("unitjpa");
    
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}