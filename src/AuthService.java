/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class AuthService {
    private final UserDAO dao = new UserDAO();

    /** Returns the logged-in user or null */
    public User login(String username, String rawPassword) {
        User u = dao.findByUsername(username);
        if (u == null) return null;
        return PasswordUtil.matches(rawPassword, u.getPasswordHash()) ? u : null;
    }
//
//    public boolean isRecoveryKeyValid(String userEnteredKey) {
//        int uid = dao.getSingleUserId();               // your single-user helper
//        String stored = dao.getRecoveryKeyHash(uid);   // read from recovery_key_hash
//        return PasswordUtil.matches(userEnteredKey.trim(), stored);
//    }
    
    // --- RECOVERY KEY: overload when caller has the userId already ---
    public boolean isRecoveryKeyValid(int userId, String userEnteredKey) {
        String stored = dao.getRecoveryKeyHash(userId);
        return PasswordUtil.matches(userEnteredKey.trim(), stored);
    }

    public boolean updateCredentials(int userId, String newUsernameOrNull, String newRawPasswordOrNull) {
        String hash = (newRawPasswordOrNull == null || newRawPasswordOrNull.isBlank())
                ? null : PasswordUtil.hash(newRawPasswordOrNull);
        return dao.updateCredentials(userId, newUsernameOrNull, hash);
    }
    
     /* Optional adapter to match controller’s earlier name */
    public boolean updateCredentialsWithRecovery(String newUsername, String newRawPassword) {
        Integer id = getSingleUserId();
        if (id == null) return false;
        return updateCredentials(id, newUsername, newRawPassword);
    }

    public Integer getSingleUserId() { return dao.getSingleUserId(); }
}

