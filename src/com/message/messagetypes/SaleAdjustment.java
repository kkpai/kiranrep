package com.message.messagetypes;

import com.message.processing.Operator;
import com.message.superclass.MessageAdapter;

public class SaleAdjustment extends MessageAdapter {
    Sale sale;
    Operator operator;
    int operandPrice;

    public SaleAdjustment(final Sale pSale, final Operator pOperator, final int pOperandPrice) {
        super();
        this.sale = pSale;
        this.operator = pOperator;
        this.operandPrice = pOperandPrice;
    }

    @Override
    public String getMessage() {
        String operation = null;
        switch(this.operator) {
            case ADD:
                operation = "Add";
            break;
            case SUBTRACT:
                operation = "Subtract";
            break;
            case MULTIPLY:
                operation = "Multiply";
            break;
            default:

        }

        return operation + " " + this.operandPrice + "p " + this.sale.productType;
    }

    @Override
    public String getProductType() {
        return this.sale.productType;
    }

    @Override
    public Operator getOperator() {
        return this.operator;
    }

    @Override
    public int getOperandPrice() {
        return this.operandPrice;
    }

    @Override
    public Sale getSale() {
        return this.sale;
    }

}
