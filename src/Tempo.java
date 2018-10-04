import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief Classe para implementar o servente de Tempo
 */
public class Tempo extends UnicastRemoteObject implements ITempo {
	
	/**
	 * Construtor padrao
	 * @throws RemoteException
	 */
	protected Tempo() throws RemoteException { 
		super(); 
	}
	
	
	/* (non-Javadoc)
	 * @see ITempo#tempo(java.text.SimpleDateFormat)
	 */
	public String tempo(SimpleDateFormat tempo) throws RemoteException{
		return tempo.format(new Date(System.currentTimeMillis()));
	}

}
