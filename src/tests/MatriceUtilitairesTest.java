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
		// Tests visuels
		System.out.println("Transposition:\n");
		System.out.println("Avant");
		System.out.println(MatriceUtilitaires.toStringMat(mat));
		System.out.println("Après");
		System.out.println(MatriceUtilitaires
				.toStringMat(MatriceUtilitaires.getMatTranspose(mat)));
		System.out.println();

		System.out.println("Avant");
		System.out.println(MatriceUtilitaires.toStringMat(grosseMat));
		System.out.println("Après");
		System.out.println(MatriceUtilitaires
				.toStringMat(MatriceUtilitaires.getMatTranspose(grosseMat)));
		System.out.println();

		System.out.println("Avant");
		System.out.println(MatriceUtilitaires.toStringMat(rectangle));
		System.out.println("Après");
		System.out.println(MatriceUtilitaires
				.toStringMat(MatriceUtilitaires.getMatTranspose(rectangle)));
		System.out.println();
	}

	@Test
	public void testGetMatMultScalaire()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatModuloX()
	{
		fail("Not yet implemented");
	}

}
