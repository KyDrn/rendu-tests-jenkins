import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.yoann.calcul.Calculs;

@RunWith(Parameterized.class)
class CalculsTest2 {

    static Stream<Arguments> chargerJeuDeTest() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,4),
            Arguments.of(6,6,36),
            Arguments.of(3,2,6)
        );
    }
    
    static Stream<Arguments> chargerJeuDeTestAdditionner() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,4),
            Arguments.of(6,6,12),
            Arguments.of(3,2,5)
        );
    }
    
    static Stream<Arguments> chargerJeuDeTestSoustraire() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,0),
            Arguments.of(6,6,0),
            Arguments.of(3,2,1)
        );
    }

    static Stream<Arguments> chargerJeuDeTestDiviser() throws Throwable 
    {
        return Stream.of(
            Arguments.of(2,2,1),
            Arguments.of(6,2,3),
            Arguments.of(3,1,3)
        );
    }

	@ParameterizedTest(name="Multiplication numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTest")
	void testMultiplier(int firstNumber, int secondNumber, int expectedResult) 
	{
	        Calculs calc = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, calc.multiplier(), "test en échec pour " + firstNumber + " * " + secondNumber + " != " + expectedResult); 
	}
	
	@ParameterizedTest(name="Addition numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTestAdditionner")
	void testAdditionner(int firstNumber, int secondNumber, int expectedResult) 
	{
	        Calculs calc = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, calc.additionner(), "test en échec pour " + firstNumber + " * " + secondNumber + " != " + expectedResult); 
	}
	
	@ParameterizedTest(name="Soustraire numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTestSoustraire")
	void testSoustraire(int firstNumber, int secondNumber, int expectedResult) 
	{
	        Calculs calc = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, calc.soustraire(), "test en échec pour " + firstNumber + " * " + secondNumber + " != " + expectedResult); 
	}
	
	@ParameterizedTest(name="Diviser numéro {index}: nombre1={0}, nombre2={1}, résultat attendu = {2}")
	@MethodSource("chargerJeuDeTestDiviser")
	void testDiviser(int firstNumber, int secondNumber, int expectedResult) 
	{
	        Calculs calc = new Calculs(firstNumber, secondNumber);
	        assertEquals(expectedResult, calc.diviser(), "test en échec pour " + firstNumber + " * " + secondNumber + " != " + expectedResult); 
	}

}