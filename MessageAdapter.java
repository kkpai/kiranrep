package com.message.superclass;

import com.message.main.Operator;
import com.message.messagetypes.Sale;

public class MessageAdapter implements Messageable {

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String getProductType() {
        return null;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getSaleOccurences() {
        return 0;
    }

    @Override
    public int getSalesPrice() {
        return 0;
    }

    @Override
    public Sale getSale() {
        return null;
    }

    @Override
    public void setPrice(final int pPrice) {
        // default implementation . to be overridden by subclasses
    }

    @Override
    public Operator getOperator() {
        return null;
    }

    @Override
    public int getOperandPrice() {
        return 0;
    }

}
