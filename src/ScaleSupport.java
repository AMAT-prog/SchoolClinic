// ScaleSupport.java
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.layout.Region;

public final class ScaleSupport {
    private ScaleSupport() {}

    public static void hook(Scene scene, Region appSurface,
                            double baseW, double baseH,
                            double maxScale /* e.g. 1.6 or Double.POSITIVE_INFINITY */) {

        // Lock designed size so scale math is stable
        appSurface.setPrefSize(baseW, baseH);
        appSurface.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        appSurface.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        ChangeListener<Number> relayout = (obs, ov, nv) -> {
            double sw = scene.getWidth();
            double sh = scene.getHeight();

            double sx = sw / baseW;
            double sy = sh / baseH;
            double s  = Math.min(sx, sy);
            if (Double.isFinite(maxScale)) s = Math.min(s, maxScale);

            appSurface.setScaleX(s);
            appSurface.setScaleY(s);

            double scaledW = baseW * s;
            double scaledH = baseH * s;
            appSurface.setTranslateX((sw - scaledW) / 2.0);
            appSurface.setTranslateY((sh - scaledH) / 2.0);
        };

        scene.widthProperty().addListener(relayout);
        scene.heightProperty().addListener(relayout);
        relayout.changed(null, null, null); // initial layout
    }
}
