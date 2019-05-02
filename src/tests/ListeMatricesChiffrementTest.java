package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exceptions.ConstructeurException;
import structures.ListeMatricesChiffrement;
import utilitaires.MatriceUtilitaires;

public class ListeMatricesChiffrementTest
{
	ListeMatricesChiffrement liste;

	@Before
	public void test()
	{
		liste = new ListeMatricesChiffrement(0, 15, 3, 28);
	}

	@Test
	public void testListeMatricesChiffrement()
	{
		try
		{
			new ListeMatricesChiffrement(-10, 10, 3, 28);
			fail("Borne inférieure négative");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeMatricesChiffrement(10, -10, 3, 28);
			fail("Borne supérieure négative");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeMatricesChiffrement(10, 5, 3, 28);
			fail("Borne inférieure plus grande que Borne supérieure");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeMatricesChiffrement(0, 15, 0, 28);
			fail("La dimension est égal à zéro");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeMatricesChiffrement(0, 15, -5, 28);
			fail("La dimension est négative");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeMatricesChiffrement(0, 15, 3, 0);
			fail("Le coeficient dans Z est égal à zéro");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new ListeMatricesChiffrement(0, 15, 3, -5);
			fail("Le coeficient dans Z est négatif");
		}

		catch (ConstructeurException e)
		{
		}
	}

	@Test
	public void testGetBorneInf()
	{
		assertTrue(liste.getBorneInf() == 0);
	}

	@Test
	public void testGetBorneSup()
	{
		assertTrue(liste.getBorneSup() == 15);
	}

	@Test
	public void testGetDimension()
	{
		assertTrue(liste.getDimension() == 3);
	}

	@Test
	public void testGetCoefDansZ()
	{
		assertTrue(liste.getCoefDansZ() == 28);
	}

	@Test
	public void testGetNombreMatricesCandidates()
	{
		assertTrue(liste.getNombreMatricesCandidates() == 4042);
	}

	@Test
	public void testChoisirMatriceCourante()
	{
		int[][] mat = liste.getCopieMatriceCourante();
		int compteur = 0;
		int totalTest = 100;
		double pourcentageReussite = 0.8;

		for (int i = 0; i < totalTest; i++)
		{
			liste.choisirMatriceCourante();
			if (!this.liste.getCopieMatriceCourante().equals(mat))
			{
				compteur++;
			}
		}
		assertTrue(compteur / totalTest > pourcentageReussite);
	}

	@Test
	public void testChoisirMatriceCouranteInt()
	{
		for (int i = 0; i <= 10; i++)
		{

			liste.choisirMatriceCourante(i);

			ListeMatricesChiffrement mat = new ListeMatricesChiffrement(0, 15,
					3, 28);
			mat.choisirMatriceCourante(i);

			assertTrue(liste.getCopieMatriceCourante()
					.equals(mat.getCopieMatriceCourante()));
		}

	}

	@Test
	public void testGetCopieMatriceCourante()
	{
		liste.choisirMatriceCourante(1);
		int[][] copie = liste.getCopieMatriceCourante();
		int[][] copie2 = liste.getCopieMatriceCourante();
		for(int i = 0; i < liste.getDimension(); i++)
		{
			for(int j = 0; j < liste.getDimension(); j++)
			{
				assertTrue(copie[i][j] == copie2[i][j]);
			}
		}
	}

	@Test
	public void testGetMatriceCouranteInverseHill()
	{
		int[][] mat = liste.getMatriceCouranteInverseHill();
		
		liste.get
	}

}
