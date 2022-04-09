import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    /* AssertEquals.assertEquals(expected, actual);
    * : assertEquals두애는 import static으로 메소드를 import한 후 구현할 수 있다.
    * : 첫 번째 인자는 기대하는 결과 값이고, 두 번째 인자는 프로덕션 코드의 메소드를 실행한 결과 값이다.
    * */

    private Calculator cal;

    @BeforeEach
    void setUp(){
        cal = new Calculator();
    }

    @Test
    void add() {
        assertEquals(7, cal.add(3, 4));
    }

    @Test
    void subtract() {
        assertEquals(8, cal.subtract(10, 2));
    }

    @Test
    void multiply() {
        assertEquals(10, cal.multiply(2,5));
    }

    @Test
    void divide() {
        assertEquals(2, cal.divide(8,4));
    }
}