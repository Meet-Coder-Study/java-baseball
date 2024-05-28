package sehee.testutil.source;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public final class AnswerSourceProvider {

    public static Stream<Arguments> provideStrikeCase() {
        return Stream.of(
            Arguments.of(1, new int[] {1, 2, 3}, new int[] {1, 4, 5}),
            Arguments.of(2, new int[] {1, 2, 3}, new int[] {1, 2, 4}),
            Arguments.of(3, new int[] {1, 2, 3}, new int[] {1, 2, 3})
        );
    }

    public static Stream<Arguments> provideBallCase() {
        return Stream.of(
            Arguments.of(1, new int[] {1, 2, 3}, new int[] {4, 5, 1}),
            Arguments.of(2, new int[] {1, 2, 3}, new int[] {4, 1, 2}),
            Arguments.of(3, new int[] {1, 2, 3}, new int[] {3, 1, 2})
        );
    }

    public static Stream<Arguments> provideBallAndStrikeCase() {
        return Stream.of(
            Arguments.of(2, 1, new int[] {1, 2, 3}, new int[] {3, 2, 1}),
            Arguments.of(1, 1, new int[] {1, 2, 3}, new int[] {1, 5, 2})
        );
    }

}
