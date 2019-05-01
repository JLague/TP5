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
		liste  = new ListeMatricesChiffrement(0, 15, 3, 28);
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
		
		for(int i = 0; i < liste.getNombreMatricesCandidates(); i++)
		{
			liste.choisirMatriceCourante(i);
			if(this.liste.getCopieMatriceCourante().equals(mat))
				
			
		}
		assertTrue(this.liste.)
	}

	@Test
	public void testChoisirMatriceCouranteInt()
	{
		this.liste.getCopieMatriceCourante().equals
	}

	@Test
	public void testGetCopieMatriceCourante()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatriceCouranteInverseHill()
	{
		fail("Not yet implemented");
	}

}
