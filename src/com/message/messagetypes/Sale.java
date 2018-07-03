package com.message.messagetypes;

import com.message.superclass.MessageAdapter;

public class Sale extends MessageAdapter {
    String productType;
    int price;

    @Override
    public void setPrice(final int pPrice) {
        this.price = pPrice;
    }

    public Sale(final String pProductType, final int pPrice) {
        super();
        this.productType = pProductType;
        this.price = pPrice;
    }

    @Override
    public String getMessage() {
        return this.productType + " at " + this.price + "p each";
    }

    @Override
    public String getProductType() {
        return this.productType;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

}
