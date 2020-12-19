package com.interfaces;

/*
public interface IClient {
    Client getClientById(int id);
}*/


import com.trippy.entity.Client;

public abstract class IClient {
    public abstract Client getClientById(int id);
    public abstract boolean isNull();
}