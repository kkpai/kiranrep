package com.message.superclass;

import com.message.messagetypes.Sale;
import com.message.processing.Operator;

public interface Messageable {
    String getMessage();

    String getProductType();

    int getPrice();

    int getSaleOccurences();

    int getSalesPrice();

    Sale getSale();

    void setPrice(int pPrice);

    Operator getOperator();

    int getOperandPrice();
}
