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

public class InventoryTool {
    private final IntegerProperty toolId = new SimpleIntegerProperty();
    private final StringProperty  toolCode = new SimpleStringProperty();
    private final StringProperty  itemName = new SimpleStringProperty();
    private final StringProperty  category = new SimpleStringProperty();
    private final IntegerProperty quantity = new SimpleIntegerProperty();
    private final StringProperty  unit     = new SimpleStringProperty();
    private final StringProperty  location = new SimpleStringProperty();
    private final StringProperty  status   = new SimpleStringProperty();
    private final StringProperty  remarks  = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> acquiredOn = new SimpleObjectProperty<>();
    private final ObjectProperty<java.math.BigDecimal> purchaseCost = new SimpleObjectProperty<>();

    public InventoryTool(int id, String code, String name, String category,
                         int qty, String unit, String location, String status,
                         String remarks, LocalDate acquiredOn, java.math.BigDecimal cost) {
        setToolId(id); setToolCode(code); setItemName(name); setCategory(category);
        setQuantity(qty); setUnit(unit); setLocation(location); setStatus(status);
        setRemarks(remarks); setAcquiredOn(acquiredOn); setPurchaseCost(cost);
    }

    // Minimal ctor for table-only rows
    public InventoryTool(int id, String code, String name, String category,
                         int qty, String unit, String location, String status, String remarks) {
        this(id, code, name, category, qty, unit, location, status, remarks, null, null);
    }

    // getters / setters / properties
    public int getToolId() { return toolId.get(); }
    public void setToolId(int v) { toolId.set(v); }
    public IntegerProperty toolIdProperty() { return toolId; }

    public String getToolCode() { return toolCode.get(); }
    public void setToolCode(String v) { toolCode.set(v); }
    public StringProperty toolCodeProperty() { return toolCode; }

    public String getItemName() { return itemName.get(); }
    public void setItemName(String v) { itemName.set(v); }
    public StringProperty itemNameProperty() { return itemName; }

    public String getCategory() { return category.get(); }
    public void setCategory(String v) { category.set(v); }
    public StringProperty categoryProperty() { return category; }

    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int v) { quantity.set(v); }
    public IntegerProperty quantityProperty() { return quantity; }

    public String getUnit() { return unit.get(); }
    public void setUnit(String v) { unit.set(v); }
    public StringProperty unitProperty() { return unit; }

    public String getLocation() { return location.get(); }
    public void setLocation(String v) { location.set(v); }
    public StringProperty locationProperty() { return location; }

    public String getStatus() { return status.get(); }
    public void setStatus(String v) { status.set(v); }
    public StringProperty statusProperty() { return status; }

    public String getRemarks() { return remarks.get(); }
    public void setRemarks(String v) { remarks.set(v); }
    public StringProperty remarksProperty() { return remarks; }

    public LocalDate getAcquiredOn() { return acquiredOn.get(); }
    public void setAcquiredOn(LocalDate v) { acquiredOn.set(v); }
    public ObjectProperty<LocalDate> acquiredOnProperty() { return acquiredOn; }

    public java.math.BigDecimal getPurchaseCost() { return purchaseCost.get(); }
    public void setPurchaseCost(java.math.BigDecimal v) { purchaseCost.set(v); }
    public ObjectProperty<java.math.BigDecimal> purchaseCostProperty() { return purchaseCost; }
}

