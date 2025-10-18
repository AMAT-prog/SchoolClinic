/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//for dispensing medicine in consultation
// StockException.java
public class StockException extends Exception {
    private final String itemName;
    private final int available;
    private final int requested;

    public StockException(String itemName, int available, int requested) {
        super(buildMessage(itemName, available, requested));
        this.itemName = itemName;
        this.available = available;
        this.requested = requested;
    }

    private static String buildMessage(String name, int available, int requested) {
        if (available <= 0)
            return "No stock available for " + name;
        if (requested > available)
            return "Insufficient stock for " + name +
                   " (available " + available + ", requested " + requested + ")";
        return "Invalid stock operation for " + name;
    }

    public String getItemName() { return itemName; }
    public int getAvailable()   { return available; }
    public int getRequested()   { return requested; }
}


