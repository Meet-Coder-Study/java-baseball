package sehee.answer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static sehee.util.constant.NumberBaseballGameConstant.ANSWER_LENGTH;
import static sehee.util.constant.NumberBaseballGameMessage.ANSWER_LENGTH_EXCEPTION_MESSAGE;
import static sehee.util.constant.NumberBaseballGameMessage.DUPLICATED_EXCEPTION_MESSAGE;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import sehee.stub.NumberMakerStub;

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

        @BeforeEach
        void setup() {

        }

        @Test
        @DisplayName("")
        void successMatchByThreeStrike() {
            // given
            // when
            // then
        }

    }

}
