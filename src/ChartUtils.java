/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
// */

import java.text.DecimalFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

import java.util.List;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.control.Tooltip;

public final class ChartUtils {
    private ChartUtils(){}

    public static void fillBar(BarChart<String,Number> chart, String seriesName, List<KV> data) {
        chart.getData().clear();
        XYChart.Series<String,Number> s = new XYChart.Series<>();
        s.setName(seriesName);
        for (KV kv : data) s.getData().add(new XYChart.Data<>(kv.key, kv.val));
        chart.getData().add(s);
    }

    public static void fillLine(LineChart<String,Number> chart, String seriesName, List<KV> data) {
        chart.getData().clear();
        XYChart.Series<String,Number> s = new XYChart.Series<>();
        s.setName(seriesName);
        for (KV kv : data) s.getData().add(new XYChart.Data<>(kv.key, kv.val));
        chart.getData().add(s);
    }

    public static void fillPie(PieChart pie, Map<String,Integer> m) {
        ObservableList<PieChart.Data> items = FXCollections.observableArrayList();
        m.forEach((k,v) -> items.add(new PieChart.Data(k==null?"Unknown":k, v)));
        pie.setData(items);
    }

    public static void fillPieFromList(PieChart pie, List<KV> list) {
        ObservableList<PieChart.Data> items = FXCollections.observableArrayList();
        for (KV kv : list) items.add(new PieChart.Data(kv.key, kv.val.doubleValue()));
        pie.setData(items);
    }
    
    /** Converts a List<KV> (key-value pairs) into PieChart.Data entries. */
    public static ObservableList<PieChart.Data> dataFromList(List<KV> list) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (KV kv : list) {
            data.add(new PieChart.Data(kv.key, kv.val.doubleValue()));
        }
        return data;
    }
    
    /** Force a stable layout (prevents the label glitch after data changes). */
    public static void stabilize(PieChart pie) {
        pie.setAnimated(false);          // no re-animate on every refresh
        pie.setLabelsVisible(true);
        pie.setLegendVisible(true);
        pie.setStartAngle(90);           // consistent slice start helps layout

        // Run after CSS/layout pass so label nodes exist
        Platform.runLater(() -> {
            pie.applyCss();
            pie.requestLayout();
        });
    }

    /** Show "Name — N (P%)" on labels (and tooltip), computed from the current data. */
    public static void relabelWithCountsAndPercent(PieChart pie) {
        double total = pie.getData().stream().mapToDouble(PieChart.Data::getPieValue).sum();
        if (total <= 0) return;

        for (PieChart.Data d : pie.getData()) {
            // strip any previous suffix we added
            String base = d.getName().replaceAll("\\s+—\\s+.*$", "");
            double pct = (d.getPieValue() / total) * 100.0;
            String label = String.format("%s — %.0f (%.1f%%)", base, d.getPieValue(), pct);
            d.setName(label);

            // also put it in a tooltip (handy when labels are far)
            if (d.getNode() != null) {
                Tooltip.install(d.getNode(), new Tooltip(label));
            }
        }
    }

    /** Convenience: convert your List<KV> to PieChart.Data. */
    public static ObservableList<PieChart.Data> dataFromKV(java.util.List<KV> list) {
        ObservableList<PieChart.Data> out = FXCollections.observableArrayList();
        for (KV kv : list) out.add(new PieChart.Data(kv.key, kv.val.doubleValue()));
        return out;
    }
    
    
    
    
    
    
    private static final DecimalFormat PCT = new DecimalFormat("0.0");
    private static final DecimalFormat NUM = new DecimalFormat("#,##0.##");

    // ===== existing methods (fillBar, fillLine, fillPie, fillPieFromList, dataFromList) stay =====

    /** Build PieChart data where each legend item becomes: "Label — N (p%)". */
    public static ObservableList<PieChart.Data> pieDataWithStatsFromList(List<KV> list) {
        double total = list.stream().mapToDouble(kv -> kv.val.doubleValue()).sum();
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        if (total <= 0.0) return data;

        for (KV kv : list) {
            double v = kv.val.doubleValue();
            double pct = (v / total) * 100.0;
            String name = kv.key + " — " + NUM.format(v) + " (" + PCT.format(pct) + "%)";
            data.add(new PieChart.Data(name, v));
        }
        return data;
    }

    /** Same but for Map<String,Integer>. Null/blank keys become "Unknown". */
    public static ObservableList<PieChart.Data> pieDataWithStatsFromMap(Map<String,Integer> m) {
        double total = m.values().stream().mapToDouble(Integer::doubleValue).sum();
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        if (total <= 0.0) return data;

        m.forEach((rawKey, vInt) -> {
            String key = (rawKey == null || rawKey.isBlank()) ? "Unknown" : rawKey;
            double v = vInt.doubleValue();
            double pct = (v / total) * 100.0;
            String name = key + " — " + NUM.format(v) + " (" + PCT.format(pct) + "%)";
            data.add(new PieChart.Data(name, v));
        });
        return data;
    }
}

