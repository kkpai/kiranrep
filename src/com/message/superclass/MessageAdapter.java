package com.message.superclass;

import com.message.messagetypes.Sale;
import com.message.processing.Operator;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPrice(final int pPrice) {
        // TODO Auto-generated method stub

    }

    @Override
    public Operator getOperator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getOperandPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

}
