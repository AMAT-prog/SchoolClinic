/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import org.mindrot.jbcrypt.BCrypt;

public class GenerateRecoveryKey {
    public static void main(String[] args) {
        int userId = 1;  // Change if your table uses a different ID
        String recoveryKey = "ScEmergencyKey123"; // You can generate or randomize this

        // Hash it with BCrypt
        String hash = BCrypt.hashpw(recoveryKey, BCrypt.gensalt(10));

        // Save the hash into the database
        new UserDAO().updateRecoveryKeyHash(userId, hash);

        // Print the plaintext key for the admin to keep
        System.out.println("New Emergency Key for user_id=" + userId + ": " + recoveryKey);
        System.out.println("The BCrypt hash has been stored in users.recovery_key_hash.");
    }
}

