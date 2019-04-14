package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ConstructeurException;
import structures.VecteurDeCaracteres;

public class VecteurDeCaracteresTest
{
	private static final char[] TABLEAU_CHAR =
	{ 'a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u', 'w', 'y' };

	private VecteurDeCaracteres v1, v2;

	@Before
	public void testVecteurDeCaracteres()
	{
		v1 = new VecteurDeCaracteres();
		v2 = new VecteurDeCaracteres(TABLEAU_CHAR);
	}

	@Test
	public void testVecteurDeCaracteresInvalide()
	{
		try
		{
			new VecteurDeCaracteres(null);
			fail("Tableau null");
		}
		catch (ConstructeurException e)
		{
		}

		try
		{
			new VecteurDeCaracteres(new char[0]);
			fail("Tableau vide");
		}
		catch (ConstructeurException e)
		{
		}
	}

	@Test
	public void testGetCaractere()
	{
		// Valides
		assertEquals(v1.getCaractere(0), 'A');
		assertEquals(v1.getCaractere(1), 'B');
		assertEquals(v1.getCaractere(26), ' ');
		assertEquals(v1.getCaractere(27), '-');

		for (int i = 0; i < v2.getTaille(); i++)
		{
			assertEquals(Character.toUpperCase(TABLEAU_CHAR[i]),
					v2.getCaractere(i));
		}

		// Invalide
		try
		{
			v1.getCaractere(-1);
			fail("Index plus petit que 0");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
		}
		
		try
		{
			v1.getCaractere(v1.getTaille());
			fail("Index plus grand que la taille - 1");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
		}
	}

	@Test
	public void testGetIndice()
	{
		assertEquals(v1.getIndice('A'), 0);
		assertEquals(v1.getIndice(' '), 26);
		assertEquals(v1.getIndice('a'), -1);
		
		assertEquals(v2.getIndice('B'), -1);
		assertEquals(v2.getIndice('b'), -1);
		assertEquals(v2.getIndice('Y'), 12);
	}

	@Test
	public void testGetTaille()
	{
		assertEquals(v1.getTaille(), 28);
		assertEquals(v2.getTaille(), 13);
	}

}
