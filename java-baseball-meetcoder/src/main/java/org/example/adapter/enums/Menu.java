package org.example.adapter.enums;

public enum Menu {
    START("1"),
    QUIT("9"),
    ;

    private final String value;

    Menu(String value) {
        this.value = value;
    }

    public static Menu from(final String input) {
        for (Menu menu: Menu.values()) {
            if (menu.value.equals(input)) {
                return menu;
            }
        }
        throw new IllegalStateException("존재하지 않는 메뉴입니다.");
    }

    public static boolean isNotQuit(final String input) {
        return !QUIT.value.equals(input);
    }

}
