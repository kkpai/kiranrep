package com.message.processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.message.messagetypes.Sale;
import com.message.messagetypes.SaleAdjustment;
import com.message.messagetypes.Sales;
import com.message.store.MessageStore;
import com.message.superclass.Messageable;

public class MessageProcessor {
    public static void main(final String args[]) throws InterruptedException {

        displayMessages();
    }

    protected static void displayMessages() throws InterruptedException {
        final ArrayList<Messageable> messages = MessageStore.constructSalesMessages();
        final ArrayList<Sales> salesList = new ArrayList<Sales>();
        int count = 0;
        final Map<String, Integer> salesMap = new HashMap<String, Integer>();

        for(final Messageable message : messages) {
            final String productType = message.getProductType();
            if(message instanceof Sales) {
                int totalPrice = 0;
                if(!salesMap.isEmpty()) {
                    totalPrice = salesMap.get(productType);
                }
                final Sales sales = (Sales)message;
                totalPrice = totalPrice + sales.getSale().getPrice() * sales.getSaleOccurences();
                salesMap.put(productType, totalPrice);
                salesList.add(sales);
            }

            Thread.sleep(2000);
            System.out.println(message.getMessage());
            count++;

            if(count % 10 == 0) {
                System.out.println("logging report of sales of each product and total...");
                System.out.println(salesMap.toString());
                System.out.println("End of sales report");
            }

            if(count == 50) {
                System.out.println("pausing");
                System.out.println("logging report of adjustments to each sale type...");
                break;
            }
        } // end for

        displayAdjustedMessages(messages, salesList);

    }

    private static void displayAdjustedMessages(final ArrayList<Messageable> pMessages,
            final ArrayList<Sales> pSalesList) throws InterruptedException {
        int newPrice = 0;
        for(final Messageable message : pMessages) {
            if(message instanceof SaleAdjustment) {
                System.out.println(message.getMessage());
                int totalSalesPrice = 0;
                for(final Sales sales : pSalesList) {
                    newPrice = 0;
                    final int originalPrice = sales.getSale().getPrice();
                    if(message.getProductType().equals(sales.getProductType())) {
                        newPrice = adjustPrice(newPrice, message, sales);
                        sales.getSale().setPrice(newPrice);
                        System.out.println(sales.getMessage());
                        totalSalesPrice = totalSalesPrice + sales.getSalesPrice();
                    }
                    sales.getSale().setPrice(originalPrice);
                } // end for
                System.out.println("totalSalesPrice for this product = " + totalSalesPrice);

                final SaleAdjustment saleAdjustment = (SaleAdjustment)message;
                final Sale sale = saleAdjustment.getSale();
                sale.setPrice(newPrice);
            }

        } // end for

    }

    protected static int adjustPrice(int newPrice, final Messageable message, final Sales sales) {
        final SaleAdjustment adjustment = (SaleAdjustment)message;
        final Operator operator = adjustment.getOperator();
        final int operandPrice = adjustment.getOperandPrice();

        switch(operator) {
            case ADD:
                newPrice = sales.getSale().getPrice() + operandPrice;

            break;
            case SUBTRACT:
                newPrice = sales.getSale().getPrice() - operandPrice;
            break;
            case MULTIPLY:
                newPrice = sales.getSale().getPrice() * operandPrice;
            break;
            default:

        }
        return newPrice;
    }

}
