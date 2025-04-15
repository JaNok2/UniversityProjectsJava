
public class PasswordCheck {
    public static void validatePassword(String password) throws PasswordException {
        if (password == null || password.isEmpty()) {
            throw new PasswordException("Hasło nie może być puste.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new MissBigLetter();
        }
        if (!password.matches(".*[a-z].*")) {
            throw new MissSmallLetter();
        }
        if (!password.matches(".*\\d.*")) {
            throw new MissNum();
        }
    }
}
