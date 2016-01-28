package com.study.dao.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @SequenceGenerator(name = "promotion_id_seq", sequenceName = "promotion_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotion_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "dealer_id", referencedColumnName = "id", nullable = false)
    private Dealer dealer;

    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @ManyToMany()
    @JoinTable(name = "promotion_product",
            joinColumns = {@JoinColumn(name = "promotion_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private Set<Product> products = new HashSet<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
