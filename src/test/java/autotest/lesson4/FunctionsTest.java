package autotest.lesson4;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class FunctionsTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("Метод выполнился 1 раз перед всеми тестами класса");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Метод выполнятся перед каждым тестом");
    }

    @Test
    @DisplayName("Позитивный тест с простым числом")
    void givenPrimeNumberWhenCallsPrimeTrue(){
        boolean result = Functions.isPrime(7);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123321", "12321"})
    void isPalindromeTest(String word){
        Assertions.assertTrue(Functions.isPalindrome(word));
    }

    @ParameterizedTest
    @CsvSource({"12321, true", "1343242, false"})
    void isPalindromeParametrizedTest(String word, boolean result){
        Assertions.assertEquals(Functions.isPalindrome(word), result);
    }

    @ParameterizedTest
    @MethodSource("catAndBoolDataProvider")
    void anyObjectParametrizedTest(Cat test, Boolean result){

    }

    private static Stream<Arguments> catAndBoolDataProvider(){
        return Stream.of(
                Arguments.of(new Cat("moris", 10), true),
                Arguments.of(new Cat("barsuk", 11), false)
        );
    }


    @AfterEach
    void afterEach(){

    }
    @AfterAll
    static void afterAll(){
        System.out.println("Метод выполнится после всех тестов");
    }
}
