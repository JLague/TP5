package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import exceptions.ConstructeurException;
import structures.ListeMatricesChiffrement;
import structures.MessageChiffrerDechiffrer;
import structures.VecteurDeCaracteres;
import utilitaires.FichierUtilitaires;

public class MessageChiffrerDechiffrerTest
{
	// pas encore fait
	VecteurDeCaracteres vec;
	ListeMatricesChiffrement mat;
	SortedSet<String> dico;
	MessageChiffrerDechiffrer message;

	@Before
	public void test()
	{
		vec = new VecteurDeCaracteres();
		mat = new ListeMatricesChiffrement(0, 12, 3, 28);
		dico = FichierUtilitaires
				.lireDictionnaire(new File("dictionnaire.txt"));

		message = new MessageChiffrerDechiffrer(vec, mat, dico);
	}

	@Test
	public void testMessageChiffrerDechiffrer()
	{
		try
		{
			new MessageChiffrerDechiffrer(null, mat, dico);
			fail("Vecteur de Caractère null");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new MessageChiffrerDechiffrer(vec, null, dico);
			fail("Liste Matrice Chiffrement null");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new MessageChiffrerDechiffrer(vec, mat, null);
			fail("Dictionnaire null");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new MessageChiffrerDechiffrer(null, null, dico);
			fail("Vecteur de Caractère null et matrice de chiffrement null");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new MessageChiffrerDechiffrer(vec, null, null);
			fail("Liste Matrice Chiffrement null et dictionnaire null");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new MessageChiffrerDechiffrer(null, mat, null);
			fail("Vecteur de Caractère et Dictionnaire null");
		}

		catch (ConstructeurException e)
		{
		}

		try
		{
			new MessageChiffrerDechiffrer(null, null, null);
			fail("tout null");
		}

		catch (ConstructeurException e)
		{
		}
	}

	@Test
	public void testValiderMessageSelonDico()
	{
		// Cas valide
		assertTrue(message.validerMessageSelonDico(
				"Ce qui est drole c quand ca marche mais on ne sait pas pourquoi",
				0.8f));

		// message null
		assertFalse(message.validerMessageSelonDico(null, 0.8f));
		// message vide
		assertFalse(message.validerMessageSelonDico("", 0.8f));
		// Pourcentage de réussite <= 0
		assertFalse(message.validerMessageSelonDico(
				"Fortnite est plate. et bien oui - revelation", -0.5f));
		assertFalse(message.validerMessageSelonDico(
				"Les patates douces ne sont pas douce", 0f));
		// Pourcentage de réussite plus grand que 1
		assertFalse(message.validerMessageSelonDico(
				"Ce Travail vaut clairement plus que cent pour cent", 1.5f));
	}

	@Test
	public void testAjusterMessageBrute()
	{
		// Cas valide
		String messageBrut1 = message
				.ajusterMessageBrute("Projet texte tres interessant", 3);
		assertTrue(messageBrut1.length() == 30);

		// Cas invalides
		String messageBrut2 = message.ajusterMessageBrute(null, 3);
		assertTrue(messageBrut2.length() == 0);

		String messageBrut3 = message.ajusterMessageBrute("message brute court",
				30);
		assertTrue(messageBrut3.length() == 0);

	}

	@Test
	public void testEncoder()
	{
		String encoder = message.encoder("un jolie message d amour");
		assertFalse(encoder.equals("un jolie message d amour"));
	}

	@Test
	public void testDecoder()
	{
		String encoder = message.encoder("un jolie message d amour");
		assertFalse(encoder.equals("un jolie message d amour"));

		String decoder = message.decoder(encoder);
		assertTrue(decoder.equals("UN JOLIE MESSAGE D AMOUR"));
	}
}
