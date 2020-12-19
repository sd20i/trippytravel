package com.facades;

import com.concreteClasses.ClientConcrete;
import com.interfaces.IClient;
import com.trippy.entity.Client;

import javax.persistence.EntityManager;

public class ClientFacade {
    private IClient client;


    public ClientFacade(EntityManager em) {
        client = new ClientConcrete(em);
    }

    public Client getClient(int clientId){
        Client foundClient = client.getClientById(clientId);
        return foundClient;
    };

}
