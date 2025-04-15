
public class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

class LettersMissException extends PasswordException {
    public LettersMissException(String message) {
        super(message);
    }
}

class MissBigLetter extends LettersMissException {
    public MissBigLetter() {
        super("Hasło musi zawierać co najmniej jedną dużą literę.");
    }
}

class MissSmallLetter extends LettersMissException {
    public MissSmallLetter() {
        super("Hasło musi zawierać co najmniej jedną małą literę.");
    }
}

class NumberMissException extends PasswordException {
    public NumberMissException(String message) {
        super(message);
    }
}

class MissNum extends NumberMissException {
    public MissNum() {
        super("Hasło musi zawierać co najmniej jedną cyfrę.");
    }
}
