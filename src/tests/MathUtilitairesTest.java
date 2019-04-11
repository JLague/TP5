package tests;

import static org.junit.Assert.*;

import java.util.SortedSet;

import org.junit.Test;

import utilitaires.MathUtilitaires;

public class MathUtilitairesTest
{
	private static final int NBR_TESTS = 100;
	private static final int[] DIVISEURS_DE_12 =
	{ 1, 2, 3, 4, 6, 12 };
	private static final int[] DIVISEURS_DE_17 =
	{ 1, 17 };
	private static final int[] NBR_PREMIERS =
	{ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
			71, 73, 79, 83, 89, 97 };

	@Test
	public void testFact()
	{
		for (int i = -1; i <= 1; i++)
		{
			assertTrue(MathUtilitaires.fact(i) == 1);
		}

		assertTrue(MathUtilitaires.fact(5) == 120);
		assertTrue(MathUtilitaires.fact(10) == 3628800);

	}

	@Test
	public void testModulo()
	{
		try
		{
			MathUtilitaires.modulo(100, 0);
			fail("Division par zéro");
		}
		catch (ArithmeticException e)
		{
		}

		assertEquals(MathUtilitaires.modulo(16, 3), 1);
		assertEquals(MathUtilitaires.modulo(-16, 3), 2);
		assertEquals(MathUtilitaires.modulo(16, -3), -2);
		assertEquals(MathUtilitaires.modulo(-16, -3), -1);
	}

	@Test
	public void testDiviseursDe()
	{
		SortedSet<Integer> diviseurs12 = MathUtilitaires.diviseursDe(12);
		SortedSet<Integer> diviseursMoins12 = MathUtilitaires.diviseursDe(-12);
		SortedSet<Integer> diviseurs17 = MathUtilitaires.diviseursDe(17);

		for (int i = 0; i < DIVISEURS_DE_12.length; i++)
		{
			assertTrue(diviseurs12.contains(DIVISEURS_DE_12[i]));
		}

		for (int i = 0; i < DIVISEURS_DE_17.length; i++)
		{
			assertTrue(diviseurs17.contains(DIVISEURS_DE_17[i]));
		}

		assertEquals(MathUtilitaires.diviseursDe(0), null);
		assertEquals(diviseurs12, diviseursMoins12);
	}

	@Test
	public void testEstPremier()
	{
		int index = 0;

		for (int i = 1; i <= 100; i++)
		{
			if (index < NBR_PREMIERS.length && i == NBR_PREMIERS[index])
			{
				assertTrue(MathUtilitaires.estPremier(i));
				index++;
			}
			else
				assertFalse(MathUtilitaires.estPremier(i));
		}
	}

	@Test
	public void testXPremier()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testPGCD()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testXPremierEntreEux()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAlea()
	{
		boucleAleatoire(0, 1);
		boucleAleatoire(1, 0);
		boucleAleatoire(-100, 100);
		boucleAleatoire(100, -100);
	}

	/**
	 * Permet de faire les tests pour la méthode alea de MathUtilitaires avec
	 * une boucle à l'aide des bornes passées en paramètre
	 * 
	 * @param pBorne1
	 * @param pBorne2
	 */
	private void boucleAleatoire(int pBorne1, int pBorne2)
	{
		int nb = 0;

		for (int i = 0; i < NBR_TESTS; i++)
		{
			nb = MathUtilitaires.alea(pBorne1, pBorne2);
			if (pBorne1 < pBorne2)
				assertTrue(nb >= pBorne1 && nb <= pBorne2);
			else
				assertTrue(nb >= pBorne2 && nb <= pBorne1);
		}
	}

}
