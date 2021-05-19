package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, -1})
    @DisplayName("로또 번호가 1~45 이외의 값이 입력될 경우 예외발생")
    void validateNumber(int input) {
        assertThatThrownBy(()->new LottoNumber(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또 번호는 1과 45사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45, 33, 7})
    @DisplayName("로또 번호가 1~45 내의 값이 입력될 경우 정상생성")
    void createNumber(int input) {
        LottoNumber lottoNumber = new LottoNumber(input);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(input));
    }
}
