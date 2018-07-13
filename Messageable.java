package com.message.superclass;

import com.message.main.Operator;
import com.message.messagetypes.Sale;

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
