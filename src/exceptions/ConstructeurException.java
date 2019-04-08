package exceptions;

/**
 * Classe d'exception implicite levée losrqu'il n'est pas légitime de construire
 * un objet.
 * 
 */
public class ConstructeurException extends RuntimeException
{
	private static final long serialVersionUID = 7539875574071609659L;

	/**
	 * Constructeur
	 */
	public ConstructeurException()
	{
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param message le message qui sera transmis à la classe parent
	 */
	public ConstructeurException(String message)
	{
		super(message);
	}
}
