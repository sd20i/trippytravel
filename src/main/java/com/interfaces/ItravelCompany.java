package com.interfaces;

import com.trippy.entity.TravelCompany;
import java.util.List;

public interface ItravelCompany {
    List<TravelCompany> listCompanies();
    TravelCompany pickCompany(List<TravelCompany> companyList, int companyId);
}