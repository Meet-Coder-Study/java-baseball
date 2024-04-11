package baseball.dto;

import java.util.List;

public record CheckBallsRequest(
        List<Integer> userNumbers,
        int gameId
) {
}
