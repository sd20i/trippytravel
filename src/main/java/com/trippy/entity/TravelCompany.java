package com.trippy.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "company")
public class TravelCompany implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyId;

    @Column(name="companyName")
    private String companyName;

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "TravelCompany{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
