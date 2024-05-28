package sehee.answer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static sehee.util.constant.NumberBaseballGameConstant.ANSWER_LENGTH;
import static sehee.util.constant.NumberBaseballGameConstant.BALL;
import static sehee.util.constant.NumberBaseballGameConstant.NOTHING;
import static sehee.util.constant.NumberBaseballGameConstant.STRIKE;
import static sehee.util.constant.NumberBaseballGameMessage.ANSWER_LENGTH_EXCEPTION_MESSAGE;
import static sehee.util.constant.NumberBaseballGameMessage.DUPLICATED_EXCEPTION_MESSAGE;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import sehee.testutil.stub.NumberMakerStub;

class AnswerTest {

    private AnswerFactory answerFactory;
    private NumberMakerStub numberMaker;

    @BeforeEach
    void setup() {
        numberMaker = new NumberMakerStub();
        answerFactory = new AnswerFactory(numberMaker);
    }

    @Nested
    class MakeTest {

        @Test
        @DisplayName("numberMaker를 통해 자동으로 Answer를 생성할 수 있다.")
        void successAutoMake() {
            // given
            int[] answerNumbers = new int[] {1, 2, 3};
            numberMaker.setNumbers(answerNumbers);

            // when
            Answer autoMadeAnswer = answerFactory.make();

            // then
            assertThat(autoMadeAnswer).extracting("numbers")
                .isEqualTo(answerNumbers);
        }

        @Test
        @DisplayName("Answer를 수동으로 생성할 수 있다.")
        void successInputMake() {
            // given
            int[] numbers = new int[] {1, 2, 3};

            // when
            Answer answer = answerFactory.make(numbers);

            // then
            assertThat(answer).extracting("numbers")
                .isEqualTo(numbers);
        }

        @Test
        @DisplayName("input 길이가 " + ANSWER_LENGTH + "과 밎지 않아 Answer를 수동으로 생성하는 데에 실패한다.")
        void failInputMakeByLength() {
            // given
            int[] numbers = new int[] {1, 2, 3, 4};

            // when
            ThrowableAssert.ThrowingCallable make = () -> answerFactory.make(numbers);

            // then
            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(make)
                .withMessage(ANSWER_LENGTH_EXCEPTION_MESSAGE);
        }

        @Test
        @DisplayName("중복된 숫자가 있어 Answer를 수동으로 생성하는 데에 실패한다.")
        void failInputMakeByDuplicated() {
            // given
            int[] numbers = new int[] {1, 3, 3};

            // when
            ThrowableAssert.ThrowingCallable make = () -> answerFactory.make(numbers);

            // then
            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(make)
                .withMessage(DUPLICATED_EXCEPTION_MESSAGE);
        }

    }

    @Nested
    class MatchTest {

        @Test
        @DisplayName("컴퓨터 설정값과 사용자 입력값이 모두 같은 경우 3스트라이크 결과가 나온다.")
        void successMatchThreeStrike() {
            // given
            int[] numbers = new int[] {1, 2, 3};
            Answer computerAnswer = answerFactory.make(numbers);
            Answer userAnswer = answerFactory.make(numbers);

            // when
            Hint matchResult = computerAnswer.match(userAnswer);

            // then
            assertThat(matchResult.isThreeStrike()).isTrue();
            assertThat(matchResult.toString()).isEqualTo(ANSWER_LENGTH + STRIKE);
        }

        @ParameterizedTest(name = "[{index}] {0}개의 숫자가 같은 위치에서 값이 일치하는 경우({0}스트라이크)")
        @MethodSource("sehee.testutil.source.AnswerSourceProvider#provideStrikeCase")
        @DisplayName("같은 위치의 숫자값이 같은 경우를 합한 값이 스트라이크이다.")
        void successMatchStrike(int strikeCount, int[] computerNumbers, int[] userNumbers) {
            // given
            Answer computerAnswer = answerFactory.make(computerNumbers);
            Answer userAnswer = answerFactory.make(userNumbers);

            // when
            Hint matchResult = computerAnswer.match(userAnswer);

            // then
            assertThat(matchResult.toString()).isEqualTo(strikeCount + STRIKE);
        }

        @ParameterizedTest(name = "[{index}] {0}개의 숫자가 다른 위치에서 값이 일치하는 경우({0}볼)")
        @MethodSource("sehee.testutil.source.AnswerSourceProvider#provideBallCase")
        @DisplayName("다른 위치의 숫자값이 같은 경우를 합한 값이 볼이다.")
        void successMatchBall(int ballCount, int[] computerNumbers, int[] userNumbers) {
            // given
            Answer computerAnswer = answerFactory.make(computerNumbers);
            Answer userAnswer = answerFactory.make(userNumbers);

            // when
            Hint matchResult = computerAnswer.match(userAnswer);

            // then
            assertThat(matchResult.isThreeStrike()).isFalse();
            assertThat(matchResult.toString()).isEqualTo(ballCount + BALL);
        }

        @ParameterizedTest(name = "[{index}] {0}볼 {1}스트라이크인 경우")
        @MethodSource("sehee.testutil.source.AnswerSourceProvider#provideBallAndStrikeCase")
        @DisplayName("볼과 스트라이크가 동시에 발견될 수 있다.")
        void successMatchBall(int ballCount, int strikeCount, int[] computerNumbers, int[] userNumbers) {
            // given
            Answer computerAnswer = answerFactory.make(computerNumbers);
            Answer userAnswer = answerFactory.make(userNumbers);

            // when
            Hint matchResult = computerAnswer.match(userAnswer);

            // then
            assertThat(matchResult.isThreeStrike()).isFalse();
            assertThat(matchResult.toString()).isEqualTo(ballCount + BALL + " " + strikeCount + STRIKE);
        }

        @Test
        @DisplayName("컴퓨터 설정값과 사용자 입력값이 다른 경우 낫싱 결과가 나온다.")
        void successMatchNothing() {
            // given
            int[] computerNumbers = new int[] {1, 2, 3};
            Answer computerAnswer = answerFactory.make(computerNumbers);

            int[] userNumbers = new int[] {4, 5, 6};
            Answer userAnswer = answerFactory.make(userNumbers);

            // when
            Hint matchResult = computerAnswer.match(userAnswer);

            // then
            assertThat(matchResult.isThreeStrike()).isFalse();
            assertThat(matchResult.toString()).isEqualTo(NOTHING);
        }

    }

}
