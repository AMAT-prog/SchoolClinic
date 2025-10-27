
import java.time.LocalDateTime;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
//public class Notification {
//    private final IntegerProperty notificationId = new SimpleIntegerProperty();
//    private final StringProperty  kind     = new SimpleStringProperty();   // inventory/calendar/system
//    private final StringProperty  title    = new SimpleStringProperty();
//    private final StringProperty  body     = new SimpleStringProperty();
//    private final StringProperty  severity = new SimpleStringProperty();   // info/warning/danger
//    private final BooleanProperty read     = new SimpleBooleanProperty(false);
//    private final StringProperty  relatedType = new SimpleStringProperty();
//    private final IntegerProperty relatedId   = new SimpleIntegerProperty();
//    private final ObjectProperty<LocalDateTime> dueAt = new SimpleObjectProperty<>();
//    private final ObjectProperty<LocalDateTime> createdAt = new SimpleObjectProperty<>();
//
//    public Notification(int id, String kind, String title, String body, String severity, boolean isRead,
//                        String relatedType, Integer relatedId,
//                        LocalDateTime dueAt, LocalDateTime createdAt) {
//        setNotificationId(id); setKind(kind); setTitle(title); setBody(body);
//        setSeverity(severity); setRead(isRead);
//        setRelatedType(relatedType); setRelatedId(relatedId == null ? 0 : relatedId);
//        setDueAt(dueAt); setCreatedAt(createdAt);
//    }
//    // getters/setters/properties...
//    public int getNotificationId(){ return notificationId.get(); }
//    public void setNotificationId(int v){ notificationId.set(v); }
//    public IntegerProperty notificationIdProperty(){ return notificationId; }
//    public String getKind(){ return kind.get(); }
//    public void setKind(String v){ kind.set(v); }
//    public StringProperty kindProperty(){ return kind; }
//    public String getTitle(){ return title.get(); }
//    public void setTitle(String v){ title.set(v); }
//    public StringProperty titleProperty(){ return title; }
//    public String getBody(){ return body.get(); }
//    public void setBody(String v){ body.set(v); }
//    public StringProperty bodyProperty(){ return body; }
//    public String getSeverity(){ return severity.get(); }
//    public void setSeverity(String v){ severity.set(v); }
//    public StringProperty severityProperty(){ return severity; }
//    public boolean isRead(){ return read.get(); }
//    public void setRead(boolean v){ read.set(v); }
//    public BooleanProperty readProperty(){ return read; }
//    public String getRelatedType(){ return relatedType.get(); }
//    public void setRelatedType(String v){ relatedType.set(v); }
//    public StringProperty relatedTypeProperty(){ return relatedType; }
//    public int getRelatedId(){ return relatedId.get(); }
//    public void setRelatedId(int v){ relatedId.set(v); }
//    public IntegerProperty relatedIdProperty(){ return relatedId; }
//    public LocalDateTime getDueAt(){ return dueAt.get(); }
//    public void setDueAt(LocalDateTime v){ dueAt.set(v); }
//    public ObjectProperty<LocalDateTime> dueAtProperty(){ return dueAt; }
//    public LocalDateTime getCreatedAt(){ return createdAt.get(); }
//    public void setCreatedAt(LocalDateTime v){ createdAt.set(v); }
//    public ObjectProperty<LocalDateTime> createdAtProperty(){ return createdAt; }
//}

//
//public class Notification {
//    public enum Severity { INFO, WARNING, DANGER }
//    public enum Type { INVENTORY, EVENT }  // event = calendar/tasks, inventory = stock/expiry
//
//    private final int id;
//    private final StringProperty title = new SimpleStringProperty();
//    private final StringProperty body  = new SimpleStringProperty();
//    private final ObjectProperty<Severity> severity = new SimpleObjectProperty<>(Severity.INFO);
//    private final ObjectProperty<Type>     type     = new SimpleObjectProperty<>(Type.EVENT);
//    private final ObjectProperty<LocalDateTime> createdAt = new SimpleObjectProperty<>(LocalDateTime.now());
//    private final BooleanProperty read = new SimpleBooleanProperty(false);
//
//    public Notification(int id, String title, String body, Severity sev, Type type, LocalDateTime ts, boolean read) {
//        this.id = id;
//        setTitle(title); setBody(body); setSeverity(sev); setType(type); setCreatedAt(ts); setRead(read);
//    }
//
//    public int getId() { return id; }
//    public String getTitle() { return title.get(); }
//    public void setTitle(String v) { title.set(v); }
//    public StringProperty titleProperty() { return title; }
//
//    public String getBody() { return body.get(); }
//    public void setBody(String v) { body.set(v); }
//    public StringProperty bodyProperty() { return body; }
//
//    public Severity getSeverity() { return severity.get(); }
//    public void setSeverity(Severity v) { severity.set(v); }
//    public ObjectProperty<Severity> severityProperty() { return severity; }
//
//    public Type getType() { return type.get(); }
//    public void setType(Type v) { type.set(v); }
//    public ObjectProperty<Type> typeProperty() { return type; }
//
//    public LocalDateTime getCreatedAt() { return createdAt.get(); }
//    public void setCreatedAt(LocalDateTime v) { createdAt.set(v); }
//    public ObjectProperty<LocalDateTime> createdAtProperty() { return createdAt; }
//
//    public boolean isRead() { return read.get(); }
//    public void setRead(boolean v) { read.set(v); }
//    public BooleanProperty readProperty() { return read; }
//}

import javafx.beans.property.*;
import java.time.LocalDateTime;

public class Notification {
    public enum Severity { INFO, WARNING, DANGER }
    public enum Type { INVENTORY, EVENT, SYSTEM }

    private final int id;                               // notification_id
    private final StringProperty  kind    = new SimpleStringProperty();  // free-form kind (e.g., "stock", "expiry")
    private final StringProperty  title   = new SimpleStringProperty();
    private final StringProperty  body    = new SimpleStringProperty();
    private final ObjectProperty<Severity> severity = new SimpleObjectProperty<>(Severity.INFO);
    private final BooleanProperty read     = new SimpleBooleanProperty(false);

    private final ObjectProperty<Type> relatedType = new SimpleObjectProperty<>(Type.SYSTEM);
    private final ObjectProperty<Integer> relatedId = new SimpleObjectProperty<>(null);

    private final ObjectProperty<LocalDateTime> dueAt     = new SimpleObjectProperty<>(null);
    private final ObjectProperty<LocalDateTime> createdAt = new SimpleObjectProperty<>(LocalDateTime.now());

    // --- Full constructor to match your SELECT columns ---
    public Notification(int id,
                        String kind,
                        String title,
                        String body,
                        Severity severity,
                        boolean isRead,
                        Type relatedType,
                        Integer relatedId,
                        LocalDateTime dueAt,
                        LocalDateTime createdAt) {
        this.id = id;
        setKind(kind);
        setTitle(title);
        setBody(body);
        setSeverity(severity);
        setRead(isRead);
        setRelatedType(relatedType);
        setRelatedId(relatedId);
        setDueAt(dueAt);
        setCreatedAt(createdAt);
    }

    // --- Convenience constructor (keep if you already used it elsewhere) ---
    public Notification(int id, String title, String body,
                        Severity severity, Type type,
                        LocalDateTime createdAt, boolean read) {
        this(id, null, title, body, severity, read, type, null, null, createdAt);
    }

    // --- Safe enum parsing from DB strings ---
    public static Severity parseSeverity(String s) {
        if (s == null) return Severity.INFO;
        try { return Severity.valueOf(s.trim().toUpperCase()); }
        catch (IllegalArgumentException e) { return Severity.INFO; }
    }

    public static Type parseType(String s) {
        if (s == null) return Type.SYSTEM;
        switch (s.trim().toUpperCase()) {
            case "INVENTORY": return Type.INVENTORY;
            case "EVENT":     return Type.EVENT;
            default:          return Type.SYSTEM;
        }
    }

    /** Use dueAt if present; otherwise createdAt — handy for sorting. */
    public LocalDateTime getEffectiveAt() {
        return (getDueAt() != null) ? getDueAt() : getCreatedAt();
    }

    // --- getters / properties ---
    public int getId() { return id; }

    public String getKind() { return kind.get(); }
    public void setKind(String v) { kind.set(v); }
    public StringProperty kindProperty() { return kind; }

    public String getTitle() { return title.get(); }
    public void setTitle(String v) { title.set(v); }
    public StringProperty titleProperty() { return title; }

    public String getBody() { return body.get(); }
    public void setBody(String v) { body.set(v); }
    public StringProperty bodyProperty() { return body; }

    public Severity getSeverity() { return severity.get(); }
    public void setSeverity(Severity v) { severity.set(v); }
    public ObjectProperty<Severity> severityProperty() { return severity; }

    public boolean isRead() { return read.get(); }
    public void setRead(boolean v) { read.set(v); }
    public BooleanProperty readProperty() { return read; }

    public Type getRelatedType() { return relatedType.get(); }
    public void setRelatedType(Type v) { relatedType.set(v); }
    public ObjectProperty<Type> relatedTypeProperty() { return relatedType; }

    public Integer getRelatedId() { return relatedId.get(); }
    public void setRelatedId(Integer v) { relatedId.set(v); }
    public ObjectProperty<Integer> relatedIdProperty() { return relatedId; }

    public LocalDateTime getDueAt() { return dueAt.get(); }
    public void setDueAt(LocalDateTime v) { dueAt.set(v); }
    public ObjectProperty<LocalDateTime> dueAtProperty() { return dueAt; }

    public LocalDateTime getCreatedAt() { return createdAt.get(); }
    public void setCreatedAt(LocalDateTime v) { createdAt.set(v); }
    public ObjectProperty<LocalDateTime> createdAtProperty() { return createdAt; }
    
    private final BooleanProperty autoGenerated = new SimpleBooleanProperty(false);
    public boolean isAutoGenerated() { return autoGenerated.get(); }
    public void setAutoGenerated(boolean v) { autoGenerated.set(v); }
    public BooleanProperty autoGeneratedProperty() { return autoGenerated; }

}


