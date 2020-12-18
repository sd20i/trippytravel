package com.concreteClasses;

import com.interfaces.ItravelCompany;
import com.trippy.entity.TravelCompany;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CompanyConcrete implements ItravelCompany {

    @Override
    public List<TravelCompany> listCompanies(EntityManager em) {
        List companyList;
        Query queryCompany = em.createQuery("SELECT c FROM TravelCompany c");
        companyList = queryCompany.getResultList();
        return companyList;
    }

    @Override
    public TravelCompany pickCompany(List<TravelCompany> companyList, int companyId) {
        return companyList.get(companyId);
    }
}
