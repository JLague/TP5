package structures;

import java.io.File;
import java.util.SortedSet;

import exceptions.ConstructeurException;
import utilitaires.FichierUtilitaires;
import utilitaires.MathUtilitaires;
import utilitaires.MatriceUtilitaires;

public class MessageChiffrerDechiffrer implements iCrypto
{
	// Si le caractère de remplacement est un espace on peut mettre au moins 80%
	public static final float POURCENTAGE_ACCEPTABLE = 0.8f;
	public static final char CAR_DE_COMPLEMENT = ' ';

	private VecteurDeCaracteres vecCaracteres = null;
	private ListeMatricesChiffrement listeMatricesCandidates = null;
	private SortedSet<String> dico = null;

	/**
	 * Constructeur, permet d'affecter les différents attributs à partir des
	 * objets reçus en entrée. Avant d'affecter les attributs de la classe avec
	 * les objets reçus en entrée, il faut valider ces derniers (<> null et pas
	 * vide).
	 *
	 * @param vecCars la table de caractères pour la correspondance lors de
	 *            l'encodage et du décodage.
	 * @param listeMats liste des matrices candidates.
	 * @param dico liste des mots pour la validation lors du décodage.
	 *
	 * @throws ConstructeurException
	 */
	// TODO MessageChiffrerDechiffrer - Compléter le code de la méthode
	public MessageChiffrerDechiffrer(VecteurDeCaracteres vecCars,
			ListeMatricesChiffrement listeMats, SortedSet<String> dico)
			throws ConstructeurException
	{
		if (validerVecCaracteres(vecCars) && validerMatsEncodage(listeMats)
				&& validerDico(dico))
		{
			setVecCaracteres(vecCars);
			setMatsEncodage(listeMats);
			setDico(dico);
		}
		else
			throw new ConstructeurException(
					"Un ou des paramètres sont invalides");

	}

	private void setVecCaracteres(VecteurDeCaracteres pVec)
	{
		if (validerVecCaracteres(pVec))
		{
			this.vecCaracteres = pVec;
		}
	}

	private void setMatsEncodage(ListeMatricesChiffrement listeMats)
	{
		if (validerMatsEncodage(listeMats))
		{
			this.listeMatricesCandidates = listeMats;
		}
	}

	private void setDico(SortedSet<String> dico)
	{
		if (validerDico(dico))
		{
			this.dico = dico;
		}
	}

	private static boolean validerVecCaracteres(VecteurDeCaracteres pVec)
	{
		return ((pVec != null) && (pVec.getTaille() > 0));
	}

	private static boolean validerMatsEncodage(
			ListeMatricesChiffrement listeMats)
	{
		return ((listeMats != null)
				&& (listeMats.getNombreMatricesCandidates() > 0));
	}

	private static boolean validerDico(SortedSet<String> dico)
	{
		return ((dico != null) && !dico.isEmpty());
	}

	/**
	 * Obtenir la matrice courante qui a été utilisée par l'encodage ou le
	 * décodage. Très utile pour les tests.
	 *
	 * @return la matrice courante utilisée à partir de l'objet
	 *         "listeMatricesCandidates".
	 */
	public int[][] getMatriceCourante()
	{
		return listeMatricesCandidates.getCopieMatriceCourante();
	}

	@Override
	// TODO validerMessageSelonDico - Compléter le code de la méthode
	public boolean validerMessageSelonDico(String message,
			float pourcentageDeReussite)
	{
		String[] mots = message.toLowerCase().split(" ");
		int count = 0;

		for (String mot : mots)
		{
			// On compte aussi les espaces dans le pourcentage à la fin
			count += this.dico.contains(mot) ? mot.length() : 0;
		}

		return (double) count / message.length()
				- (mots.length - 1) >= pourcentageDeReussite;
	}

	@Override
	// TODO ajusterMessageBrute - Compléter le code de la méthode
	public String ajusterMessageBrute(String message, int diviseur)
	{
		while (MathUtilitaires.modulo(message.length(), diviseur) != 0)
		{
			message += CAR_DE_COMPLEMENT;
		}

		return message;
	}

	@Override
	// TODO encoder - Compléter le code de la méthode
	public String encoder(String message)
	{
		int[][] matrice = this.getMatriceCourante();
		return chiffrementDeHill(matrice,
				ajusterMessageBrute(message, matrice.length));
	}

	@Override
	// TODO decoder - Compléter le code de la méthode
	public String decoder(String message)
	{
		int[][] matriceInverse = null;
		String messageDecode = "";
		boolean trouve = false;

		// Parcours les matrices candidates
		for (int i = 0; i < listeMatricesCandidates
				.getNombreMatricesCandidates() && !trouve; i++)
		{
			listeMatricesCandidates.choisirMatriceCourante(i);
			matriceInverse = listeMatricesCandidates
					.getMatriceCouranteInverseHill();
			matriceInverse = MatriceUtilitaires.getMatModuloX(matriceInverse,
					vecCaracteres.getTaille());

			// Décode le message et le vérifie selon le dico
			messageDecode = chiffrementDeHill(matriceInverse, message);
			trouve = validerMessageSelonDico(messageDecode,
					POURCENTAGE_ACCEPTABLE);
		}

		return trouve ? messageDecode : null;
	}

	private String chiffrementDeHill(int[][] matrice, String message)
	{
		int valeurLettre = 0;
		int longueur = message.length();
		String messageFinal = "";
		int dimension = matrice.length;

		// Parcours chaque groupe de lettre
		for (int i = 0; i < longueur / dimension; i++)
		{
			// Parcours chaque ligne de la matrice d'encryption
			for (int j = 0; j < dimension; j++)
			{
				// Parcours chaque élément de chaque ligne de la matrice
				// d'encryption
				for (int k = 0; k < dimension; k++)
				{
					valeurLettre += matrice[j][k]
							* vecCaracteres.getIndice(message.charAt(k));
				}
				// Ajoute le caractère au message final
				messageFinal += vecCaracteres
						.getCaractere(valeurLettre % vecCaracteres.getTaille());
				valeurLettre = 0;
			}
			message = message.substring(dimension);

		}

		return messageFinal;
	}

	public static void main(String[] args)
	{
		MessageChiffrerDechiffrer m = new MessageChiffrerDechiffrer(
				new VecteurDeCaracteres(),
				new ListeMatricesChiffrement(1, 20, 2, 28), FichierUtilitaires
						.lireDictionnaire(new File("dictionnaire.txt")));

		String message = "ceci est un test";
		String e = m.encoder(message);
		System.out.println(e);
		System.out.println(m.decoder(e));
	}
}
