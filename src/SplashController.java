/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author User
 */


import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SplashController {

    @FXML private StackPane splashRoot;
    @FXML private StackPane card;
    @FXML private Label title;
    @FXML private ProgressIndicator spinner;
    @FXML private Label percentLabel;

    /** Called by Splash.show() */
    public void setTitle(String t) { title.setText(t); }

    /** Neumorphism: two opposite drop-shadows (applied once). */
    private void applyNeumorph() {
        DropShadow dark = new DropShadow();
        dark.setRadius(26);
        dark.setOffsetX(10);
        dark.setOffsetY(10);
        dark.setColor(javafx.scene.paint.Color.rgb(0, 0, 0, 0.10));

        DropShadow light = new DropShadow();
        light.setRadius(26);
        light.setOffsetX(-10);
        light.setOffsetY(-10);
        light.setColor(javafx.scene.paint.Color.rgb(255, 255, 255, 0.9));

        // chain: light on top of dark
        light.setInput(dark);
        card.setEffect(light);
    }

    /** Typewriter effect for the title over the same duration as the progress. */
//    private Animation buildTypewriter(Duration duration) {
//        String full = title.getText();
//        title.setText(""); // start empty
//        int N = full.length();
//
//        Timeline tl = new Timeline();
//        for (int i = 1; i <= N; i++) {
//            double frac = (double) i / N;
//            KeyFrame kf = new KeyFrame(duration.multiply(frac),
//                    new KeyValue(title.textProperty(), full.substring(0, i)));
//            tl.getKeyFrames().add(kf);
//        }
//        return tl;
//    }
    /** Slow fade in/out of the header; never fully invisible. */
    private Animation buildHeaderBreath(Duration total) {
        // one breath cycle ~ 1.4s (tweak as you like)
        Duration cycle = total.divide(2.5); // ~40% of total time
        FadeTransition ft = new FadeTransition(cycle, title);
        ft.setFromValue(0.35);  // not fully faded out (still readable)
        ft.setToValue(1.0);     // full intensity
        ft.setAutoReverse(true);
        ft.setCycleCount(Animation.INDEFINITE);
        return ft;
    }


    /** Progress 0->100%, update percentLabel. */
    private Animation buildProgress(Duration duration) {
        spinner.setProgress(0);
        spinner.progressProperty().addListener((obs, ov, nv) -> {
            double p = (nv == null) ? 0 : Math.max(0, Math.min(1, nv.doubleValue()));
            percentLabel.setText(String.format("%.0f%%", p * 100));
        });
        return new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(spinner.progressProperty(), 0)),
            new KeyFrame(duration,      new KeyValue(spinner.progressProperty(), 1))
        );
    }

    /** Optional: gentle pulse of the spinner scale */
    private Animation buildPulse(Duration duration) {
        ScaleTransition st = new ScaleTransition(duration.divide(6), spinner);
        st.setFromX(1.0); st.setFromY(1.0);
        st.setToX(1.06);  st.setToY(1.06);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);
        return st;
    }

    /** Public entry: called from Splash.show(...) */
    public void play(Duration duration) {
        applyNeumorph();

        // --- 1) FADE-IN for card (soft entrance) ---
        card.setOpacity(0);
        FadeTransition ft = new FadeTransition(Duration.millis(300), card);
        ft.setToValue(1);
        ft.play();

        // --- 2) Build animations (progress + text + pulse) ---
        ParallelTransition all = new ParallelTransition(
            buildProgress(duration),
//            buildTypewriter(duration),
            buildHeaderBreath(duration),  // header breathing fade
            buildPulse(duration)
        );

        // --- 3) Start them ---
        all.play();
    }
    
    public void bindToTask(Task<?> task, Duration total) {
        applyNeumorph();

        // card intro
        card.setOpacity(0);
        FadeTransition intro = new FadeTransition(Duration.millis(300), card);
        intro.setToValue(1);
        intro.play();

        // spinner progress from the task
        spinner.progressProperty().unbind();
        spinner.progressProperty().bind(task.progressProperty());

        // update percent label
        task.progressProperty().addListener((obs, ov, nv) -> {
            double p = nv == null ? 0 : Math.max(0, Math.min(1, nv.doubleValue()));
            percentLabel.setText(String.format("%.0f%%", p * 100));
        });

        // header breathing fade (keeps readable)
        buildHeaderBreath(total).play();
        buildPulse(total).play(); // optional spinner pulse
    }
    
    /** Smooth UI-driven progress 0→90% during minDuration; complete to 100% when task succeeds. */
    public void bindToTaskWithFakeProgress(Task<?> task, Duration minDuration) {
        applyNeumorph();

        // intro fade for the card
        card.setOpacity(0);
        FadeTransition intro = new FadeTransition(Duration.millis(300), card);
        intro.setToValue(1);
        intro.play();

        // UI progress timeline (independent of task's own progress)
        spinner.setProgress(0);
        Timeline uiProgress = new Timeline(
            new KeyFrame(Duration.ZERO,                new KeyValue(spinner.progressProperty(), 0)),
            new KeyFrame(minDuration.multiply(100),   new KeyValue(spinner.progressProperty(), 100))
        );
        uiProgress.play();

        // percent text
        spinner.progressProperty().addListener((obs, ov, nv) -> {
            double p = Math.max(0, Math.min(1, nv == null ? 0 : nv.doubleValue()));
            percentLabel.setText(String.format("%.0f%%", p * 100));
        });

        // header + pulse
        buildHeaderBreath(minDuration).play();
        buildPulse(minDuration).play();

        // when task finishes, snap to 100%
        task.setOnSucceeded(e -> {
            uiProgress.stop();
            spinner.setProgress(1);
            percentLabel.setText("100%");
        });
    }


}


