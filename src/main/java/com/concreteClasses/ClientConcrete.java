package com.concreteClasses;

import com.interfaces.IClient;
import com.trippy.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClientConcrete extends IClient {
    private EntityManager em;

    public ClientConcrete(EntityManager em) {
        this.em = em;
    }

    @Override
    public Client getClientById(int id) {
        try{
            Query queryClient = em.createQuery("SELECT c FROM Client c WHERE c.clientId =:clientId ");
            queryClient.setParameter("clientId", id);
            Client client = (Client) queryClient.getSingleResult();
            return client;
        }catch(Exception ex){
            return new NoClient().getClientById(id);
        }
    }

    @Override
    public boolean isNull() {
        return false;
    }
}

class NoClient extends IClient {

    @Override
    public Client getClientById(int id) {
        System.out.println("No client was found by id " + id);
        return null;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
