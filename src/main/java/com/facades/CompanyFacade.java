package com.facades;

import com.interfaces.ItravelCompany;
import com.concreteClasses.CompanyConcrete;
import com.trippy.entity.TravelCompany;
import javax.persistence.EntityManager;
import java.util.List;

public class CompanyFacade {
    private ItravelCompany company;

    public CompanyFacade() {
        company = new CompanyConcrete();
    }

    public List<TravelCompany> ListCompanies(EntityManager em){
        return company.listCompanies(em);
    }

    public TravelCompany pickCompany(List<TravelCompany> companyList, int companyId){
        return company.pickCompany(companyList, companyId);
    }
}
