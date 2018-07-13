package com.message.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.message.messagetypes.Sale;
import com.message.messagetypes.SaleAdjustment;
import com.message.messagetypes.Sales;
import com.message.store.MessageStore;
import com.message.superclass.Messageable;

public class SalesMessageAppLauncher {

    private SalesMessageAppLauncher() {
    }

    public static void main(final String[] args) throws InterruptedException {
        final SalesMessageAppLauncher salesMessageAppLauncher = new SalesMessageAppLauncher();
        salesMessageAppLauncher.displayMessages();
    }

    protected void displayMessages() {
        final MessageStore messageStore = new MessageStore();
        final List<Messageable> messages = messageStore.constructSalesMessages();

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

            try {
                Thread.sleep(875);
            } catch(final InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
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

    private static void displayAdjustedMessages(final List<Messageable> pMessages, final ArrayList<Sales> pSalesList) {
        for(final Messageable message : pMessages) {
            if(message instanceof SaleAdjustment) {
                processSalesAdjustment(pSalesList, message);
            }
        } // end for

    }

    protected static int processSalesAdjustment(final ArrayList<Sales> pSalesList, final Messageable message) {
        System.out.println(message.getMessage());
        int totalSalesPrice = 0;
        int newPrice = 0;
        for(final Sales sales : pSalesList) {
            if(message.getProductType().equals(sales.getProductType())) {
                newPrice = adjustPrice(message, sales);
                sales.getSale().setPrice(newPrice);
                System.out.println(sales.getMessage());
                totalSalesPrice = totalSalesPrice + sales.getSalesPrice();
            }
        } // end for
        System.out.println("totalSalesPrice for this product = " + totalSalesPrice);

        final SaleAdjustment saleAdjustment = (SaleAdjustment)message;
        final Sale sale = saleAdjustment.getSale();
        sale.setPrice(newPrice);
        return newPrice;
    }

    protected static int adjustPrice(final Messageable message, final Sales sales) {
        final SaleAdjustment adjustment = (SaleAdjustment)message;
        final Operator operator = adjustment.getOperator();
        final int operandPrice = adjustment.getOperandPrice();

        int newPrice = 0;
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
