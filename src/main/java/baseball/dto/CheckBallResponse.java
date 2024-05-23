package baseball.dto;

public record CheckBallResponse(
        int strikeCount,
        int ballCount,
        boolean isNotting,
        boolean isSuccess
) {
}
