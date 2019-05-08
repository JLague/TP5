package tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import utilitaires.FichierUtilitaires;

//TODO
public class FichierUtilitairesTest
{
	public static final String MESSAGE = "Ceci est un test\nsur plusieurs lignes\ntest\n\n\n\n\nF";
	public static final File TEST = new File("test.txt");
	public static final File VIDE = new File("vide.txt");
	public static final File INVALIDE = new File("aucunFichierDeCeNom.txt");
	
	@Before
	public void setUp()
	{
		FichierUtilitaires.enregistrerMessage(MESSAGE, TEST);
		FichierUtilitaires.enregistrerMessage("", VIDE);
	}

	@Test
	public void testEnregistrerMessage()
	{
		// Message et fichier valide
		assertTrue(FichierUtilitaires.enregistrerMessage(MESSAGE, TEST));
		assertEquals(MESSAGE.substring(0, MESSAGE.indexOf("\n")),
				FichierUtilitaires.lireMessage(TEST));
		
		// Message vide et fichier valide
		assertTrue(FichierUtilitaires.enregistrerMessage("", VIDE));
		assertEquals(FichierUtilitaires.lireMessage(VIDE), "");
		
		// Message vide et fichier invalide (crée le fichier)
		assertTrue(FichierUtilitaires.enregistrerMessage("", INVALIDE));
		assertFalse(FichierUtilitaires.lireMessage(TEST).equals(""));
		INVALIDE.delete();
		
		// Message null et fichier valide
		assertFalse(FichierUtilitaires.enregistrerMessage(null, TEST));
		
		// Message null et fichier invalide
		assertFalse(FichierUtilitaires.enregistrerMessage(null, INVALIDE));
		
		// Fichier invalide
		assertTrue(FichierUtilitaires.enregistrerMessage(MESSAGE, INVALIDE));
		INVALIDE.delete();
	}

	@Test
	public void testLireMessage()
	{
		// Message valide
		assertEquals(MESSAGE.substring(0, MESSAGE.indexOf("\n")),
				FichierUtilitaires.lireMessage(TEST));

		// Aucun fichier de ce nom
		System.out.println(FichierUtilitaires.lireMessage(INVALIDE));
		assertNull(FichierUtilitaires
				.lireMessage(INVALIDE));
		
		// Fichier null
		
		assertNull(FichierUtilitaires.lireMessage(null));
		
		// Message vide
		assertEquals("", FichierUtilitaires.lireMessage(VIDE));

	}

	@Test
	public void testLireDictionnaire()
	{
		fail("Not yet implemented");
	}
}
