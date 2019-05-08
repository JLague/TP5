package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exceptions.ConstructeurException;
import structures.ListeCombinatoire;

public class ListeCombinatoireTest
{
	private static final int VALEUR_ENS_MIN = ListeCombinatoire.VALEUR_ENS_MIN;
	private static final int VALEUR_ENS_MAX = ListeCombinatoire.VALEUR_ENS_MAX;
	private static final int LONGUEUR_COMBINAISON_MIN = ListeCombinatoire.LONGUEUR_COMBINAISON_MIN;

	private static ListeCombinatoire l1, l2;

	@Before
	public void testListeCombinatoire()
	{
		l1 = new ListeCombinatoire(1, 5, 3);
		l2 = new ListeCombinatoire(1, 20, 4);
	}

	@Test
	public void testListeCombinatoireInvalide()
	{
		try
		{
			new ListeCombinatoire(VALEUR_ENS_MIN - 1, VALEUR_ENS_MAX,
					LONGUEUR_COMBINAISON_MIN);
			fail("Min trop petit");
		}
		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeCombinatoire(VALEUR_ENS_MIN, VALEUR_ENS_MAX + 1,
					LONGUEUR_COMBINAISON_MIN);
			fail("Max trop grand");
		}
		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeCombinatoire(VALEUR_ENS_MIN, VALEUR_ENS_MIN,
					LONGUEUR_COMBINAISON_MIN - 1);
			fail("Longueur trop petite");
		}
		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeCombinatoire(VALEUR_ENS_MIN, VALEUR_ENS_MIN + 1,
					LONGUEUR_COMBINAISON_MIN + 2);
			fail("Longueur plus petite que l'ensemble");
		}
		catch (ConstructeurException e)
		{
		}
	}

	@Test
	public void testGenererEnsembleValeurs()
	{
		List<Integer> ensemble1 = l1.genererEnsembleValeurs();
		List<Integer> ensemble2 = l2.genererEnsembleValeurs();

		assertEquals(ensemble1.size(), l1.getFinEns() - l1.getDebutEns() + 1);
		assertEquals(ensemble2.size(), l2.getFinEns() - l2.getDebutEns() + 1);

		// Test visuel
		System.out.println(ensemble1);
		System.out.println(ensemble2);
	}

	@Test
	public void testToString()
	{
		// Tests visuels
		System.out.println(l1);
		System.out.println(l2);
	}

}
