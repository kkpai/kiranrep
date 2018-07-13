package com.message.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.message.main.Operator;
import com.message.messagetypes.Sale;
import com.message.messagetypes.SaleAdjustment;
import com.message.messagetypes.Sales;
import com.message.superclass.Messageable;

public class MessageStoreReader {

    public static void main(final String[] args) {
        final MessageStoreReader messageStoreReader = new MessageStoreReader();
        try {
            messageStoreReader.constructSalesMessages();
        } catch(final IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private ArrayList<Messageable> constructSalesMessages() throws IOException {
        final ArrayList<Messageable> messages = new ArrayList<Messageable>();
        final String fileName = "/home/atg/WorkSpace/Practice/src/com/message/store/MessageStore.txt";
        final BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = in.readLine()) != null) {
            System.out.println(line);
            final Messageable message = createMessage(line);
            messages.add(message);
        }
        in.close();
        return messages;
    }

    public Messageable createMessage(final String line) {
        final String[] data = line.split(" ");
        final int messageType = Integer.parseInt(data[0]);
        Messageable message = null;

        switch(messageType) {
            case 1:
                message = createSale(new String[] { data[1], data[2] });
            break;
            case 2:
                final int occurences = Integer.parseInt(data[1]);
                final Messageable fruitSale = createSale(new String[] { data[2], data[3] });
                message = new Sales((Sale)fruitSale, occurences);
            break;
            case 3:
                final Messageable fruitSaleAdjusted = createSale(new String[] { data[3], data[4] });
                message = new SaleAdjustment((Sale)fruitSaleAdjusted, Operator.ADD, new Integer(data[2]));
            break;
            default:
                System.out.println("Invalid value");
        }

        return message;
    }

    private static Messageable createSale(final String[] data) {
        Messageable message;
        final String fruit = data[0];
        final int costInPence = Integer.parseInt(data[1]);
        message = new Sale(fruit, costInPence);
        return message;
    }
}
