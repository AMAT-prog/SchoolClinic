/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.time.LocalDate;

public class MedUsageRow {
    public final String item;
    public final Integer totalUsed;
    public final Integer balance;
    public final LocalDate expiry;

    public MedUsageRow(String item, Integer totalUsed, Integer balance, LocalDate expiry) {
        this.item = item; this.totalUsed = totalUsed; this.balance = balance; this.expiry = expiry;
    }
    public String getItem() { return item; }
    public Integer getTotalUsed() { return totalUsed; }
    public Integer getBalance() { return balance; }
    public LocalDate getExpiry() { return expiry; }
}

