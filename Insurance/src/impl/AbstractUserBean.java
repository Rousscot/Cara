package impl;


import remote.AbstractUserRemote;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AbstractUserBean implements AbstractUserRemote {
    @PersistenceContext(unitName = "Insurance-ejb")
    EntityManager persistance;

    public List<String> liste() {
        Query q = persistance.createNamedQuery("allUsers");
        try {
            return (List<String>) q.getResultList();
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public boolean login(String lastName, String password) {
        //TODO
        return true;
    }
}

