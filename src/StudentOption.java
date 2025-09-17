/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class StudentOption {
    private final int id;
    private final String display;

    //StudentOption
    public StudentOption(int id, String display) {
        this.id = id;
        this.display = display;
    }
    public int getId() { return id; }
    public String getDisplay() { return display; }
    @Override public String toString() { return display; } // shown in ComboBox
    
}




