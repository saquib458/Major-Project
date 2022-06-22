package com.Ecommerce.Backend.Application.entities;


import com.Ecommerce.Backend.Application.dtoClasses.SellerDetailsDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Seller {

    @Id
    @Column(name ="user_id")
    private long id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name ="user_id")
    private User user;



    private String gst;

    private String company_name;

    private String company_contact;

    public Seller() {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_contact() {
        return company_contact;
    }

    public void setCompany_contact(String company_contact) {
        this.company_contact = company_contact;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", gst='" + gst + '\'' +
                ", company_name='" + company_name + '\'' +
                ", company_contact='" + company_contact + '\'' +
                '}';
    }

    public SellerDetailsDto list()
 {

    SellerDetailsDto sellerDetail=new SellerDetailsDto();

    sellerDetail.setId(this.getUser().getId());
    sellerDetail.setName(this.getUser().getFirstName()+" "+this.getUser().getLastName());
    sellerDetail.setEmail(this.getUser().getEmail());
    sellerDetail.setIs_active(this.getUser().getIs_Active());
    sellerDetail.setCompany_name(this.getUser().getSeller().getCompany_name());
    sellerDetail.setAddress(this.getUser().getAddresses());
    sellerDetail.setCompany_contact(this.getUser().getSeller().getCompany_contact());

    return sellerDetail;
    }
}
