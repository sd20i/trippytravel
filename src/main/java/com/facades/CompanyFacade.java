package com.facades;

import com.interfaces.ItravelCompany;
import com.concreteClasses.CompanyConcrete;
import com.trippy.entity.TravelCompany;
import javax.persistence.EntityManager;
import java.util.List;

public class CompanyFacade {
    private ItravelCompany company;

    public CompanyFacade(EntityManager em) {
        company = new CompanyConcrete(em);
    }

    public List<TravelCompany> ListCompanies(){
        return company.listCompanies();
    }

    public TravelCompany pickCompany(List<TravelCompany> companyList, int companyId){
        return company.pickCompany(companyList, companyId);
    }
}
