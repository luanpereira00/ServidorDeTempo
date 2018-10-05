package temp;

import java.rmi.RemoteException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief  Interface para definir o servente de Tempo
 */

@WebService
@SOAPBinding(style = Style.RPC)
public interface ITempo {
	
	/**
	 * @brief Um metodo que retorna a data e/ou hora atual seguindo o formato passado por argumento 
	 * @param tempo O formato que deve ser utilizado para exibir a data/hora
	 * @return A data/hora atual
	 * @throws RemoteException
	 */
	@WebMethod String tempo(String tempoFormato);
}
