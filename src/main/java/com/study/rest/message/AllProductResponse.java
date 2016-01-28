package com.study.rest.message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimtung on 1/28/16.
 */
public class AllProductResponse {

    private int page = 0;
    private List<ProductItem> items = new ArrayList<>(0);

    public List<ProductItem> getItems() {
        return items;
    }

    public AllProductResponse setItems(List<ProductItem> items) {
        this.items = items;
        return this;
    }

    public int getPage() {
        return page;
    }

    public AllProductResponse setPage(int page) {
        this.page = page;
        return this;
    }

    public static class ProductItem {
        private long id;
        private String name;
        private String detail;
        private String type;

        public long getId() {
            return id;
        }

        public ProductItem setId(long id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public ProductItem setName(String name) {
            this.name = name;
            return this;
        }

        public String getDetail() {
            return detail;
        }

        public ProductItem setDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public String getType() {
            return type;
        }

        public ProductItem setType(String type) {
            this.type = type;
            return this;
        }

        public ProductItem(long id, String name, String detail, String type) {
            this.id = id;
            this.name = name;
            this.detail = detail;
            this.type = type;
        }

        public ProductItem() {
        }
    }

}
