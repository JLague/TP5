package structures;

import java.util.*;

import exceptions.ConstructeurException;

/**
 * Classe qui permet de produire une liste de caractères selon une constante ou
 * selon un tableau de caractères reçu.
 *
 * @author Dylan Renaud
 * @author Justin Lagüe
 *
 */

public class VecteurDeCaracteres
{

	private static final char[] TAB_CHAR_DEFAUT =
	{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '-' };

	private List<Character> tableCaracteres = null;

	/**
	 * Constructeur sans paramètre. Permet de remplir un tableau indexé de
	 * caractères avec les caractères de A à Z, l'espace et le "-". Met tous les
	 * caractères en majuscule.
	 *
	 * Utilise le constructeur avec paramètres
	 *
	 * @throws ConstructeurException
	 */
	// TODO VecteurDeCaracteres - Compléter le code de la méthode
	public VecteurDeCaracteres() throws ConstructeurException
	{
		this(TAB_CHAR_DEFAUT);
	}

	/**
	 * Constructeur avec paramètre. Permet d'instancier et de remplir l'attribut
	 * tableCaracteres, un tableau indexé de caractères à partir du tableau de
	 * "char" reçu. Met tous les caractères en majuscule. Il faut que le tableau
	 * de caractères contienne au moins 1 caractère.
	 * 
	 * @throws ConstructeurException
	 */
	// TODO VecteurDeCaracteres - Compléter le code de la méthode
	public VecteurDeCaracteres(char[] tabChar) throws ConstructeurException
	{
		this.tableCaracteres = new ArrayList<Character>();
		
		if (tabChar.length > 0)
		{
			for(char c : tabChar)
			{
				tableCaracteres.add(Character.toUpperCase(c));
			}
		}
		else
			throw new ConstructeurException("Le tableau est vide");
	}

	/**
	 * Retourne le caractère selon l'index
	 *
	 * @param index: l'index du caractère
	 *
	 * @return le caractère selon l'index
	 *
	 * @throws ArrayIndexOutOfBoundsException
	 */
	// TODO getCaractere - Compléter le code de la méthode
	public char getCaractere(int index) throws ArrayIndexOutOfBoundsException
	{
		return this.tableCaracteres.get(index);
	}

	/**
	 * Retourne l'indice, dans le vecteur de caractères, du caractère reçu
	 *
	 * @param car le caractère à trouver
	 *
	 * @return l'indice du caractère ou -1 si le caractères n'est pas trouvé
	 */
	// TODO getIndice - Compléter le code de la méthode
	public int getIndice(char car)
	{
//		int indice = -1;
//		
//		for(int i = 0; i < this.getTaille(); i++)
//		{
//			if(this.tableCaracteres.get(i) == car)
//			{
//				indice = i;
//			}
//		}
//		
//		return indice;
		
		return this.tableCaracteres.indexOf(car);
	}

	/**
	 * La taille du vecteur de caractères
	 *
	 * @return la taille
	 */
	// TODO getTaille - Compléter le code de la méthode
	public int getTaille()
	{
		return this.tableCaracteres.size();
	}

	/**
	 * Permet de construire une chaîne de caractères structurée pour afficher
	 * les infos d'un objet VecteurDeCaracteres
	 *
	 * <pre>
	 * Exemple de sortie voulue:
	 *
	 * TableDeCorrespondance = [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,  , -]
	 * </pre>
	 */
	@Override
	public String toString()
	{
		return "Table de correspondance = " + this.tableCaracteres;
	}
}
