import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    /*
     * 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환한다.
     * - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
     * - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
     *   커스텀 구분자는 문자열 앞 부분의 // 와 \n 사이에 위치하는 문자를 커서텀 구분자로 사용한다.
     * - 문자열 계산기에 음수를 전달하는 경우 RuntimeException 으로 예외처리한다.
     * */
    private StringCalculator cal;
    private String text;

    @BeforeEach
    void setUp(){
        cal = new StringCalculator();
    }

    @Test
    void 문자열이_공백이라면_0을_반환한다(){
        text = "";
        assertEquals(0, cal.add(text));
    }

    @Test
    void 기본_구분자_문자열_계산(){
        text = "1,2,3,4";
        assertEquals(10, cal.add(text));
        text = "1:4";
        assertEquals(5, cal.add(text));
        text = "1,4,2:3,9";
        assertEquals(19, cal.add(text));
    }

    @Test
    void 커스텀_구분자_문자열_계산(){
        text = "//%\n3%4%0%6";
        assertEquals(13, cal.add(text));
    }

    @Test
    void 음수가_포함된_경우_RuntimeException(){
        String text = "4,5,6,-2,0,1";
        assertThrows(RuntimeException.class, () -> cal.add(text));
    }

}