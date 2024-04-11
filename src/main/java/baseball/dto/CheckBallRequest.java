package baseball.dto;

import java.util.List;

public record CheckBallRequest(
        List<Integer> userNumbers,
        int computerId
) {
}
