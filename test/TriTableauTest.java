

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.yoann.tritableau.TriTableau;

@RunWith(Parameterized.class)
class TriTableauTest {

	static Stream<Arguments> jeuDeTestTriTableauCroissant() throws Throwable
	{
		return Stream.of(
				Arguments.of(new int[] {1, 2, 3, 4}, new int []{1, 2, 3, 4}),
				Arguments.of(new int[] {4, 3, 2, 1}, new int []{1, 2, 3, 4}),
				Arguments.of(new int[] {1, 4, -2, 3}, new int []{-2, 1, 3, 4}),
				Arguments.of(new int[] {-1, -3, -2, -4}, new int []{-4, -3, -2, -1})
				);
	}
	
	static Stream<Arguments> jeuDeTestTriTableauDecroissant() throws Throwable 
    {
        return Stream.of(
        		Arguments.of(new int[] {1, 2, 3, 4}, new int []{4, 3, 2, 1}),
				Arguments.of(new int[] {4, 3, 2, 1}, new int []{4, 3, 2, 1}),
				Arguments.of(new int[] {1, 4, -2, 3}, new int []{4, 3, 1, -2}),
				Arguments.of(new int[] {-1, -3, -2, -4}, new int []{-1, -2, -3, -4})
        );
    }

	

	@ParameterizedTest(name="Tri tableau croissant numéro {index}: tableau={0}, résultat attendu = {1}")
	@MethodSource("jeuDeTestTriTableauCroissant")
	void testTriTableauCroissant(int tableau[], int expectedResult[]) 
	{
		//Act
		TriTableau.triCroissant(tableau);
		
		//Assert
		for (int i = 0; i < tableau.length; i++) {
			assertEquals(expectedResult[i], tableau[i], "test en échec pour " + tableau[i] + " != " + expectedResult[i]);
		} 
	}
	
	@ParameterizedTest(name="Tri tableau decroissant numéro {index}: tableau={0}, résultat attendu = {1}")
	@MethodSource("jeuDeTestTriTableauDecroissant")
	void testTriTableauDecroissant(int tableau[], int expectedResult[]) 
	{
		//Act
		TriTableau.triDecroissant(tableau);
		
		//Les tests ne vont pas passer car il manque un -1 dans le boucle du tri décroissant sur la longueur
		
		//Assert
		for (int i = 0; i < tableau.length; i++) {
			assertEquals(expectedResult[i], tableau[i], "test en échec pour " + tableau[i] + " != " + expectedResult[i]);
		} 
	}

}
