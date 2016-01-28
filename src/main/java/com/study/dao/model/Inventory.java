package com.study.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @SequenceGenerator(name = "inventory_id_seq", sequenceName = "inventory_seq_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_id_seq")
    @Column(name = "inventory_id", nullable = false, unique = true)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "dealer_id", referencedColumnName = "id")
    private Dealer dealer;

    @OneToMany(mappedBy = "id.inventory", cascade = CascadeType.ALL)
    private Set<ProductInInventory> products = new HashSet<>(0);

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

    public Set<ProductInInventory> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductInInventory> products) {
        this.products = products;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Entity
    @Table(name = "inventory_product")
    @AssociationOverrides({
            @AssociationOverride(name = "id.product", joinColumns = @JoinColumn(name = "product_id")),
            @AssociationOverride(name = "id.inventory", joinColumns = @JoinColumn(name = "inventory_id"))
    })
    public static class ProductInInventory {

        @EmbeddedId
        private Id id;

        @Column(name = "quantity")
        private int quantity;

        @Embeddable
        public static class Id implements Serializable {
            @ManyToOne
            private Product product;

            @ManyToOne
            private Inventory inventory;
        }
    }

}
