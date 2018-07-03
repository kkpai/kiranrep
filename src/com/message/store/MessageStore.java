package com.message.store;

import java.util.ArrayList;

import com.message.messagetypes.Sale;
import com.message.messagetypes.SaleAdjustment;
import com.message.messagetypes.Sales;
import com.message.processing.Operator;
import com.message.superclass.Messageable;

public class MessageStore {

    public static ArrayList<Messageable> constructSalesMessages() {
        final ArrayList<Messageable> messages = new ArrayList<Messageable>();

        final Messageable appleSale = new Sale("apples", 10);
        messages.add(appleSale);

        final Messageable appleSaleOccurences = new Sales((Sale)appleSale, 15);
        messages.add(appleSaleOccurences);

        final Messageable appleSaleAdjustment = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment);

        final Messageable coconutSale = new Sale("coconuts", 40);
        messages.add(coconutSale);

        final Messageable appleSale1 = new Sale("apples", 10);
        messages.add(appleSale1);

        final Messageable appleSaleOccurences1 = new Sales((Sale)appleSale, 15);
        messages.add(appleSaleOccurences1);

        final Messageable appleSaleAdjustment1 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment1);

        final Messageable coconutSale1 = new Sale("coconuts", 40);
        messages.add(coconutSale1);

        final Messageable appleSale2 = new Sale("apples", 10);
        messages.add(appleSale2);

        final Messageable appleSaleOccurences2 = new Sales((Sale)appleSale, 15);
        messages.add(appleSaleOccurences2);

        final Messageable appleSaleAdjustment2 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment2);

        final Messageable coconutSale2 = new Sale("coconuts", 40);
        messages.add(coconutSale2);

        final Messageable appleSale3 = new Sale("apples", 10);
        messages.add(appleSale3);

        final Messageable appleSaleOccurences3 = new Sales((Sale)appleSale, 15);
        messages.add(appleSaleOccurences3);

        final Messageable appleSaleAdjustment3 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment3);

        final Messageable coconutSale3 = new Sale("coconuts", 40);
        messages.add(coconutSale3);

        final Messageable appleSale4 = new Sale("apples", 10);
        messages.add(appleSale4);

        final Messageable appleSaleOccurences4 = new Sales((Sale)appleSale, 15);
        messages.add(appleSaleOccurences4);

        final Messageable appleSaleAdjustment4 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment4);

        final Messageable coconutSale4 = new Sale("coconuts", 40);
        messages.add(coconutSale4);

        final Messageable appleSale5 = new Sale("apples", 10);
        messages.add(appleSale5);

        final Messageable appleSaleOccurences5 = new Sales((Sale)appleSale, 15);
        messages.add(appleSaleOccurences5);

        final Messageable appleSaleAdjustment5 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment5);

        final Messageable coconutSale5 = new Sale("coconuts", 50);
        messages.add(coconutSale5);

        final Messageable appleSale6 = new Sale("apples", 10);
        messages.add(appleSale6);

        final Messageable appleSaleOccurences6 = new Sales((Sale)appleSale, 16);
        messages.add(appleSaleOccurences6);

        final Messageable appleSaleAdjustment6 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment6);

        final Messageable coconutSale6 = new Sale("coconuts", 60);
        messages.add(coconutSale6);

        final Messageable appleSale7 = new Sale("apples", 10);
        messages.add(appleSale7);

        final Messageable appleSaleOccurences7 = new Sales((Sale)appleSale, 17);
        messages.add(appleSaleOccurences7);

        final Messageable appleSaleAdjustment7 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment7);

        final Messageable coconutSale7 = new Sale("coconuts", 70);
        messages.add(coconutSale7);
        final Messageable appleSale8 = new Sale("apples", 10);
        messages.add(appleSale8);

        final Messageable appleSaleOccurences8 = new Sales((Sale)appleSale, 18);
        messages.add(appleSaleOccurences8);

        final Messageable appleSaleAdjustment8 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment8);

        final Messageable coconutSale8 = new Sale("coconuts", 80);
        messages.add(coconutSale8);

        final Messageable appleSale9 = new Sale("apples", 10);
        messages.add(appleSale9);

        final Messageable appleSaleOccurences9 = new Sales((Sale)appleSale, 19);
        messages.add(appleSaleOccurences9);

        final Messageable appleSaleAdjustment9 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment9);

        final Messageable coconutSale9 = new Sale("coconuts", 90);
        messages.add(coconutSale9);

        final Messageable appleSale10 = new Sale("apples", 10);
        messages.add(appleSale10);

        final Messageable appleSaleOccurences10 = new Sales((Sale)appleSale, 10);
        messages.add(appleSaleOccurences10);

        final Messageable appleSaleAdjustment10 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment10);

        final Messageable coconutSale10 = new Sale("coconuts", 40);
        messages.add(coconutSale10);

        final Messageable appleSale11 = new Sale("apples", 11);
        messages.add(appleSale11);

        final Messageable appleSaleOccurences11 = new Sales((Sale)appleSale, 20);
        messages.add(appleSaleOccurences11);

        final Messageable appleSaleAdjustment11 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment11);

        final Messageable coconutSale11 = new Sale("coconuts", 40);
        messages.add(coconutSale11);

        final Messageable appleSale12 = new Sale("apples", 12);
        messages.add(appleSale12);

        final Messageable appleSaleOccurences12 = new Sales((Sale)appleSale, 12);
        messages.add(appleSaleOccurences12);

        final Messageable appleSaleAdjustment12 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment12);

        final Messageable coconutSale12 = new Sale("coconuts", 40);
        messages.add(coconutSale12);

        final Messageable appleSale13 = new Sale("apples", 13);
        messages.add(appleSale13);

        final Messageable appleSaleOccurences13 = new Sales((Sale)appleSale, 10);
        messages.add(appleSaleOccurences13);

        final Messageable appleSaleAdjustment13 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment13);

        final Messageable coconutSale13 = new Sale("coconuts", 40);
        messages.add(coconutSale13);

        final Messageable appleSale14 = new Sale("apples", 10);
        messages.add(appleSale14);

        final Messageable appleSaleOccurences14 = new Sales((Sale)appleSale, 10);
        messages.add(appleSaleOccurences14);

        final Messageable appleSaleAdjustment14 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment14);

        final Messageable coconutSale14 = new Sale("coconuts", 40);
        messages.add(coconutSale14);

        final Messageable appleSale15 = new Sale("apples", 15);
        messages.add(appleSale15);

        final Messageable appleSaleOccurences15 = new Sales((Sale)appleSale, 10);
        messages.add(appleSaleOccurences15);

        final Messageable appleSaleAdjustment15 = new SaleAdjustment((Sale)appleSale, Operator.ADD, 20);
        messages.add(appleSaleAdjustment15);

        final Messageable coconutSale15 = new Sale("coconuts", 40);
        messages.add(coconutSale15);

        return messages;
    }

}
