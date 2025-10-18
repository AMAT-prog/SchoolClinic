/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

public class RxRow {
    private int itemId;           // inventory.item_id
    private String itemName;      // inventory.item_name
    private String unit;          // e.g., "tabs", "mL"
    private int qty;              // dispensed quantity

    public RxRow(int itemId, String itemName, String unit, int qty) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unit = unit;
        this.qty = qty;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public String getUnit() { return unit; }
    public int getQty() { return qty; }
    public void setQty(int q) { this.qty = q; }

    @Override
    public String toString() {
        return itemName + " (" + qty + " " + unit + ")";
    }
}

