package com.study.dao.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/18/16
 */
@Entity
@Table(name = "dealer")
public class Dealer {
    @Id
    @SequenceGenerator(name = "dealer_id_seq", sequenceName = "dealer_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "address", nullable = true)
    private String address;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<Inventory> inventories = new HashSet<>(0);

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<Staff> staffs = new HashSet<>(0);

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<Bill> bills = new HashSet<>(0);

    @ManyToMany()
    @JoinTable(name = "maker_dealer",
            joinColumns = {@JoinColumn(name = "dealer_id")},
            inverseJoinColumns = {@JoinColumn(name = "maker_id")}
    )
    private Set<Maker> makers = new HashSet<>(0);

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<Promotion> promotions = new HashSet<>(0);

    @OneToMany(mappedBy = "id.dealer", cascade = CascadeType.ALL)
    private Set<Product.Price> prices = new HashSet<>(0);


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Set<Maker> getMakers() {
        return makers;
    }

    public void setMakers(Set<Maker> makers) {
        this.makers = makers;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Set<Product.Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Product.Price> prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dealer dealer = (Dealer) o;

        if (id != dealer.id) return false;
        if (name != null ? !name.equals(dealer.name) : dealer.name != null) return false;
        if (phone != null ? !phone.equals(dealer.phone) : dealer.phone != null) return false;
        return address != null ? address.equals(dealer.address) : dealer.address == null;

    }
}
