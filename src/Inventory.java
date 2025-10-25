/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.time.LocalDate;
import javafx.beans.property.*;
import javafx.beans.property.*;

public class Inventory {
    private final IntegerProperty itemId = new SimpleIntegerProperty();
    private final StringProperty itemName = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final IntegerProperty quantity = new SimpleIntegerProperty();
    private final StringProperty unit = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> expiryDate = new SimpleObjectProperty<>();
    private final StringProperty status = new SimpleStringProperty();
    private final IntegerProperty totalUsed    = new SimpleIntegerProperty();
    private final IntegerProperty balanceStock = new SimpleIntegerProperty();


    public Inventory(int itemId, String itemName, String type, int quantity,int used, int balance,
                     String unit, LocalDate expiryDate, String status) {
        setItemId(itemId);
        setItemName(itemName);
        setType(type);
        setQuantity(quantity);
        setUnit(unit);
        setExpiryDate(expiryDate);
        setStatus(status);
        // defaults if not supplied
        setTotalUsed(used);
        setBalanceStock(balance);
    }
    
    
    // Optional convenience constructor for “picker rows”
    public Inventory(int itemId, String itemName, String unit, int balanceStock) {
        setItemId(itemId);
        setItemName(itemName);
        setUnit(unit);
        setBalanceStock(balanceStock);
    }
   
    // getters (JavaFX-style) + properties
    public int getItemId() { return itemId.get(); }
    public void setItemId(int v) { itemId.set(v); }
    public IntegerProperty itemIdProperty() { return itemId; }

    public String getItemName() { return itemName.get(); }
    public void setItemName(String v) { itemName.set(v); }
    public StringProperty itemNameProperty() { return itemName; }

    public String getType() { return type.get(); }
    public void setType(String v) { type.set(v); }
    public StringProperty typeProperty() { return type; }

    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int v) { quantity.set(v); }
    public IntegerProperty quantityProperty() { return quantity; }

    public String getUnit() { return unit.get(); }
    public void setUnit(String v) { unit.set(v); }
    public StringProperty unitProperty() { return unit; }

    public LocalDate getExpiryDate() { return expiryDate.get(); }
    public void setExpiryDate(LocalDate v) { expiryDate.set(v); }
    public ObjectProperty<LocalDate> expiryDateProperty() { return expiryDate; }

    public String getStatus() { return status.get(); }
    public void setStatus(String v) { status.set(v); }
    public StringProperty statusProperty() { return status; }
    
     // additional getters + properties (for adding consultation)
    public int getTotalUsed() { return totalUsed.get(); }
    public void setTotalUsed(int v) { totalUsed.set(v); }
    public IntegerProperty totalUsedProperty() { return totalUsed; }

    public int getBalanceStock() { return balanceStock.get(); }
    public void setBalanceStock(int v) { balanceStock.set(v); }
    public IntegerProperty balanceStockProperty() { return balanceStock; }

    // Optional: nice toString for picker lists
    @Override public String toString() {
        String name = getItemName() == null ? "" : getItemName();
        String u    = getUnit() == null ? "" : getUnit();
        return name + (u.isEmpty() ? "" : " (" + u + ")");
    }
    
    
}

