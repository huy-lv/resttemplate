package com.study.dao.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "maker")
public class Maker {

    @Id
    @SequenceGenerator(name = "maker_id_seq", sequenceName = "maker_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "maker_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "address", nullable = true)
    private String address;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "makers")
    private Set<Dealer> dealers = new HashSet<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(Set<Dealer> dealers) {
        this.dealers = dealers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
