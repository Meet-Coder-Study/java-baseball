package baseball.dto;

public record CheckBallResponse(
        int strikeCont,
        int ballCont,
        boolean isNotting,
        boolean isSuccess
) {
}
