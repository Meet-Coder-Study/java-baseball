package meetcoder.study.model;

public enum GuessResultType {
    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼");

    private final String name;

    GuessResultType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
