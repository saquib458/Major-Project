package com.Ecommerce.Backend.Application.entities;


import javax.persistence.*;

@Entity
public class Seller {

    @Id
    @Column(name ="user_id")
    private long id;

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
}
