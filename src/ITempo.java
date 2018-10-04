
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;


/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief Interface para definir o servente de Tempo
 */
public interface ITempo extends Remote {
	
	
	/**
	 * @brief Um metodo que retorna a data e/ou hora atual seguindo o formato passado por argumento 
	 * @param tempo O formato que deve ser utilizado para exibir a data/hora
	 * @return A data/hora atual
	 * @throws RemoteException
	 */
	public String tempo(SimpleDateFormat tempo) throws RemoteException;
}
