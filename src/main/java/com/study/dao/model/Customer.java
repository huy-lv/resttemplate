package com.study.dao.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "phone", nullable = true)
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Bill> bills =  new HashSet<>(0);

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        return phone != null ? phone.equals(customer.phone) : customer.phone == null;

    }
}
