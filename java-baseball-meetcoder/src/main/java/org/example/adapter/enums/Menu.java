package org.example.adapter.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Menu {
    START("1"),
    QUIT("9"),
    ;

    private final String value;

    Menu(String value) {
        this.value = value;
    }

    private static final Map<String, Menu> cachedMenu = Arrays.stream(Menu.values())
        .collect(Collectors.toMap(menu -> menu.value, menu -> menu));


    public static Menu from(final String input) {
        Menu menu = cachedMenu.get(input);
        if (menu == null) {
            throw new IllegalStateException("존재하지 않는 메뉴입니다.");
        }
        return menu;
    }

    public static boolean isNotQuit(final String input) {
        return !QUIT.value.equals(input);
    }

}
