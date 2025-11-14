/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.io.*;
import java.time.*;
import java.util.Properties;

/**
 * TrialManager for School Clinic System
 * Handles 4-week (28 days) trial countdown stored locally.
 */
public class TrialManager {

    private static final String FOLDER = System.getenv("ProgramData") + "\\SchoolClinic";
    private static final String FILE = FOLDER + "\\trial.properties";
    private static final int TRIAL_DAYS = 20; // 20 days

    public static boolean isTrialExpired() {
        try {
            File folder = new File(FOLDER);
            if (!folder.exists()) folder.mkdirs();

            File trialFile = new File(FILE);
            Properties props = new Properties();

            // First run → create trial file
            if (!trialFile.exists()) {
                props.setProperty("startDate", LocalDate.now().toString());
                try (FileOutputStream out = new FileOutputStream(trialFile)) {
                    props.store(out, "School Clinic Trial Info");
                }
                return false; // just started, still valid
            }

            // Read start date
            try (FileInputStream in = new FileInputStream(trialFile)) {
                props.load(in);
            }

            LocalDate startDate = LocalDate.parse(props.getProperty("startDate"));
            long daysUsed = Duration.between(startDate.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();

            return daysUsed >= TRIAL_DAYS;

        } catch (Exception e) {
            e.printStackTrace();
            return true; // fail-safe
        }
    }

    public static long getDaysLeft() {
        try {
            Properties props = new Properties();
            try (FileInputStream in = new FileInputStream(FILE)) {
                props.load(in);
            }
            LocalDate startDate = LocalDate.parse(props.getProperty("startDate"));
            long used = Duration.between(startDate.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
            return Math.max(0, TRIAL_DAYS - used);
        } catch (Exception e) {
            return 0;
        }
    }
}

