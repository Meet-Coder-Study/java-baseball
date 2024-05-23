package meetcoder.study.util;

public final class Validator {

    private Validator() {
        // 유틸리티 클래스
    }

    public static void checkArgument(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

}
