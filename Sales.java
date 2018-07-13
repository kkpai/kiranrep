package com.message.messagetypes;

import com.message.superclass.MessageAdapter;

public class Sales extends MessageAdapter {
    private final Sale sale;
    private final int saleOccurences;

    public Sales(final Sale pSale, final int pSaleOccurences) {
        super();
        this.sale = pSale;
        this.saleOccurences = pSaleOccurences;
    }

    @Override
    public Sale getSale() {
        return this.sale;
    }

    @Override
    public String getMessage() {
        return this.saleOccurences + " sales of " + this.sale.getMessage();
    }

    @Override
    public String getProductType() {
        return this.sale.productType;
    }

    @Override
    public int getPrice() {
        return this.sale.price;
    }

    @Override
    public int getSaleOccurences() {
        return this.saleOccurences;
    }

    @Override
    public int getSalesPrice() {
        return getPrice() * getSaleOccurences();
    }

}
