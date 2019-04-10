package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import utilitaires.MatriceUtilitaires;

public class MatriceUtilitairesTest
{
	int[][] mat, grosseMat, rectangle;

	@Before
	public void MatriceUtilitaires()
	{
		mat = new int[][]
		{
				{ 6, 1, -5 },
				{ -2, -5, 4 },
				{ -3, 3, -1 } };

		grosseMat = new int[][]
		{
				{ 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		rectangle = new int[][]
		{
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 } };
	}

	@Test
	public void testToStringMat()
	{
		// Tests visuels
		System.out.println(MatriceUtilitaires.toStringMat(mat));
		System.out.println();
		System.out.println(MatriceUtilitaires.toStringMat(grosseMat));
		System.out.println();
		System.out.println(MatriceUtilitaires.toStringMat(rectangle));
	}

	@Test
	public void testGetMatTranspose()
	{
		int[][] matT = new int[][]
		{
				{ 6, -2, -3 },
				{ 1, -5, 3 },
				{ -5, 4, -1 } };

		int[][] grosseMatT = new int[][]
		{
				{ 1, 6, 11, 16, 21 },
				{ 2, 7, 12, 17, 22 },
				{ 3, 8, 13, 18, 23 },
				{ 4, 9, 14, 19, 24 },
				{ 5, 10, 15, 20, 25 } };

		int[][] rectangleT = new int[][]
		{
				{ 1, 5 },
				{ 2, 6 },
				{ 3, 7 },
				{ 4, 8 } };

		int[][] matTranspose = MatriceUtilitaires.getMatTranspose(mat);
		int[][] grosseMatTranspose = MatriceUtilitaires.getMatTranspose(grosseMat);
		int[][] rectangleTranspose = MatriceUtilitaires.getMatTranspose(rectangle);

		for(int i = 0; i < matT.length; i++)
		{
			for (int j = 0; j < matT[i].length; j++)
			{
				assertEquals(matT[i][j], matTranspose[i][j]);
			}
		}
		
		for(int i = 0; i < grosseMatT.length; i++)
		{
			for (int j = 0; j < grosseMatT[i].length; j++)
			{
				assertEquals(grosseMatT[i][j], grosseMatTranspose[i][j]);
			}
		}
		
		for(int i = 0; i < rectangleT.length; i++)
		{
			for (int j = 0; j < rectangleT[i].length; j++)
			{
				assertEquals(rectangleT[i][j], rectangleTranspose[i][j]);
			}
		}
	}

	@Test
	public void testGetMatMultScalaire()
	{
		int[][] matM = MatriceUtilitaires.getMatMultScalaire(mat, 5);
		int[][] grosseMatM = MatriceUtilitaires.getMatMultScalaire(grosseMat, 5);
		int[][] rectangleM = MatriceUtilitaires.getMatMultScalaire(rectangle, 5);
	}

	@Test
	public void testGetMatModuloX()
	{
		fail("Not yet implemented");
	}

}
