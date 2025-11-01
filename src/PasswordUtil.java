/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
// PasswordUtil.java
// PasswordUtil.java
import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil {
    private PasswordUtil() {}

    /** Hash a raw password/key with BCrypt (cost=12 is a good default). */
    public static String hash(String raw) {
        return BCrypt.hashpw(raw, BCrypt.gensalt(12));
    }

    /** Compare raw against a stored hash. */
    public static boolean matches(String raw, String storedHash) {
        if (storedHash == null || storedHash.isBlank()) return false;
        // Optional: if you had legacy plaintext before migrating to BCrypt, temporarily allow:
        if (!(storedHash.startsWith("$2a$") || storedHash.startsWith("$2b$") || storedHash.startsWith("$2y$"))) {
            // Legacy fallback – remove after you migrate all stored values to BCrypt
            return raw.equals(storedHash);
        }
        return BCrypt.checkpw(raw, storedHash);
    }
}


//public final class PasswordUtil {
//    private PasswordUtil() {}
//
//    public static String hash(String raw) {
//        // 12 cost is a good default
//        return org.mindrot.jbcrypt.BCrypt.hashpw(raw, org.mindrot.jbcrypt.BCrypt.gensalt(12));
//    }
//
//    public static boolean matches(String raw, String hash) {
//        if (hash == null || hash.isBlank()) return false;
//        return org.mindrot.jbcrypt.BCrypt.checkpw(raw, hash);
//    }
//}
