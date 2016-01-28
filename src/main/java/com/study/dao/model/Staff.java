package com.study.dao.model;

import javax.persistence.*;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @SequenceGenerator(name = "staff_id_seq", sequenceName = "staff_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "dealer_id", referencedColumnName = "id", nullable = false)
    private Dealer dealer;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "active", nullable = false)
    private boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
