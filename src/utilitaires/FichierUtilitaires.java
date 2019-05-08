package utilitaires;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JFileChooser;

/**
 * Classe utilitaires pour la gestion de fichiers
 *
 * @author Dylan Renaud
 * @author Justin Lagüe
 */
public class FichierUtilitaires
{

	/**
	 * Enregistrer un message (une chaîne) dans un fichier (PrintWriter)
	 *
	 * @param message: le message à enregistrer
	 * @param nomFichier: un objet File, le fichier dans lequel il faut
	 *            enregistrer le message
	 *
	 * @return vrai si le message a été enregistré.
	 */
	// TODO enregistrerMessage - Compléter le code de la méthode
	public static boolean enregistrerMessage(String message, File nomFichier)
	{
		boolean enregistre = false;
		PrintWriter sortie = null;
		
		if (message != null)
		{
			try
			{
				sortie = new PrintWriter(new FileWriter(nomFichier));
				sortie.println(message);
				enregistre = true;

				sortie.flush();
				sortie.close();
			}
			catch (IOException | NullPointerException e)
			{
			}
		}

		return enregistre;
	}

	/**
	 * Lire seulement la première ligne (une chaîne) du fichier reçu
	 *
	 * @param nomFichier, un File dans lequel lire.
	 *
	 * @return la ligne lue
	 */
	// TODO lireMessage - Compléter le code de la méthode
	public static String lireMessage(File nomFichier)
	{
		String ligne = null;
		BufferedReader entree = null;

		try
		{
			entree = new BufferedReader(new FileReader(nomFichier));
			ligne = entree.readLine();
			entree.close();
		}
		catch (IOException | NullPointerException e)
		{
		}

		return ligne;
	}

	/**
	 * Lire un fichier de mots. Chaque mot est sur une ligne différente. Chaque
	 * mot doit être mis en minuscule et on doit enlever les espaces de chaque
	 * bout (voir la classe String). Il faut aussi éliminer les doublons.
	 *
	 * @param nomFichier le nom du fichier dictionnaire
	 *
	 * @return un SortedSet des mots du dictionnaire ou null s'il n'y a pas de
	 *         mot dans le fichier.
	 */
	// TODO lireDictionnaire - Compléter le code de la méthode
	public static SortedSet<String> lireDictionnaire(File nomDic)
	{
		String ligne = null;
		BufferedReader entree = null;
		SortedSet<String> dictionnaire = new TreeSet<String>();

		try
		{
			entree = new BufferedReader(new FileReader(nomDic));
			while ((ligne = entree.readLine()) != null)
			{
				dictionnaire.add(ligne.trim().toLowerCase());
			}
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		finally
		{
			try
			{
				entree.close();
			}
			catch (IOException e)
			{
				System.err.println(e);
			}
		}

		return dictionnaire.isEmpty() ? null : dictionnaire;
	}

	/**
	 * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
	 * dialogue graphique.
	 * 
	 * @param option: le nom du bouton principal
	 * 
	 * @return un File, le fichier sélectionné ou null
	 */
	public static File obtenirNomFichier(String option)
	{
		File f = null;
		JFileChooser chooser = new JFileChooser(".");

		if (chooser.showDialog(null, option) == JFileChooser.APPROVE_OPTION)
			f = chooser.getSelectedFile();

		return f;
	}

	/**
	 * Obtenir le nom du fichier de l'utilisateur à partir d'une boîte de
	 * dialogue graphique.
	 *
	 * @param option: le nom du bouton principal
	 * @param le nom du fichier pré-sélectionné
	 *
	 * @return un File, le fichier sélectionné ou null
	 */
	public static File obtenirNomFichier(String option, File fichier)
	{
		File f = null;
		JFileChooser chooser = new JFileChooser(".");
		chooser.setSelectedFile(fichier);

		if (chooser.showDialog(null, option) == JFileChooser.APPROVE_OPTION)
			f = chooser.getSelectedFile();

		return f;
	}
}
