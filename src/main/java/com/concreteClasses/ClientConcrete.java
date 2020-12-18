package com.concreteClasses;

import com.interfaces.IClient;
import com.trippy.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClientConcrete implements IClient {
    private EntityManager em;

    public ClientConcrete(EntityManager em) {
        this.em = em;
    }

    @Override
    public Client getClientById(int id) {
        Query queryClient = em.createQuery("SELECT c FROM Client c WHERE c.clientId =:clientId ");
        queryClient.setParameter("clientId", id);
        Client client = (Client) queryClient.getSingleResult();
        return client;
    }
}
