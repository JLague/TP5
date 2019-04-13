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
	private static final int[] PREMIERS_ENTRE_1_ET_26 =
	{ 1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25 };

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

		for (int nb : DIVISEURS_DE_12)
		{
			assertTrue(diviseurs12.contains(nb));
		}

		for (int nb : DIVISEURS_DE_17)
		{
			assertTrue(diviseurs17.contains(nb));
		}

		assertEquals(MathUtilitaires.diviseursDe(0), null);
		assertEquals(diviseurs12, diviseursMoins12);
	}

	@Test
	public void testEstPremier()
	{
		assertTrue(MathUtilitaires.estPremier(2));
		assertTrue(MathUtilitaires.estPremier(3));
		assertTrue(MathUtilitaires.estPremier(11));
		assertTrue(MathUtilitaires.estPremier(179426549));

		assertFalse(MathUtilitaires.estPremier(1));
		assertFalse(MathUtilitaires.estPremier(-11));
	}

	@Test
	public void testXPremier()
	{
		SortedSet<Integer> premiers = MathUtilitaires.xPremier(100);
		SortedSet<Integer> vide = MathUtilitaires.xPremier(1);
		SortedSet<Integer> vide2 = MathUtilitaires.xPremier(-10);

		for (int nb : NBR_PREMIERS)
		{
			assertTrue(premiers.contains(nb));
		}

		assertTrue(premiers.size() == NBR_PREMIERS.length);

		assertEquals(vide, null);
		assertEquals(vide2, null);
	}

	@Test
	public void testPGCD()
	{
		assertEquals(MathUtilitaires.PGCD(30, 45), 15);
		assertEquals(MathUtilitaires.PGCD(45, 30), 15);
		assertEquals(MathUtilitaires.PGCD(100, 10), 10);
		assertEquals(MathUtilitaires.PGCD(221, 782), 17);
		assertEquals(MathUtilitaires.PGCD(-221, 782), 17);
		assertEquals(MathUtilitaires.PGCD(221, -782), -17);
	}

	@Test
	public void testXPremierEntreEux()
	{
		SortedSet<Integer> premiers26 = MathUtilitaires.xPremierEntreEux(1, 26);
		SortedSet<Integer> premiersMoins1Et26 = MathUtilitaires.xPremierEntreEux(-1, 26);

		for (int nb : PREMIERS_ENTRE_1_ET_26)
		{
			assertTrue(premiers26.contains(nb));
		}

		assertTrue(premiers26.size() == PREMIERS_ENTRE_1_ET_26.length);
		assertEquals(premiers26, premiersMoins1Et26);
		
		assertEquals(MathUtilitaires.xPremierEntreEux(1, 1), null);
	}

	@Test
	public void testAlea()
	{
//		int borne1 = 0;
//		int borne2 = 0;

		boucleAleatoire(0, 1);
		boucleAleatoire(1, 0);
		boucleAleatoire(-100, 100);
		boucleAleatoire(100, -100);

		/*
		 * //Un peu overkill for(int i = 0; i < NBR_TESTS; i++) { borne1 =
		 * MathUtilitaires.alea(-1000, 1000); borne2 =
		 * MathUtilitaires.alea(-1000, 1000);
		 * 
		 * boucleAleatoire(borne1, borne2); }
		 */
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
