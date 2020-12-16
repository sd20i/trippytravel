package com.travelcompany;

import com.trippy.entity.TravelCompany;
import javax.persistence.EntityManager;
import java.util.List;

public interface ItravelCompany {
    List<TravelCompany> listCompanies(EntityManager em);
    TravelCompany pickCompany(List<TravelCompany> companyList, int companyId);
}