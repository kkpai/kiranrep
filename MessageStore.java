package com.message.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.message.main.Operator;
import com.message.messagetypes.Sale;
import com.message.messagetypes.SaleAdjustment;
import com.message.messagetypes.Sales;
import com.message.superclass.Messageable;

public class MessageStore {

    public List<Messageable> constructSalesMessages() {

        final String MESSAGE_STORE_FILE;
        FileReader fileReader = null;
        try {
            final String CURRENT_DIRECTORY = new File(".").getCanonicalPath();
            MESSAGE_STORE_FILE = CURRENT_DIRECTORY + "/src/com/message/store/MessageStore.txt";
            fileReader = new FileReader(new File(MESSAGE_STORE_FILE));
        } catch(final IOException ioe) {
            ioe.printStackTrace();
        }
        final ArrayList<Messageable> messages = new ArrayList<Messageable>();

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);

                // processing the line ....
                final Messageable message = createMessage(line);
                messages.add(message);

            }
        } catch(final FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(final IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }

                if(fileReader != null) {
                    fileReader.close();
                }

            } catch(final IOException ioException) {
                ioException.printStackTrace();
            }
        }

        return messages;
    }

    public static Messageable createMessage(final String line) {
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
                final Messageable fruitSaleAdjusted = createSale(new String[] { data[3], "10" });
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
