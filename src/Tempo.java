package temp;

import java.util.Date;
import javax.jws.WebService;
import java.text.SimpleDateFormat;

/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief Classe para implementar o servente de Tempo
 */

@WebService(endpointInterface = "temp.ITempo")
public class Tempo implements ITempo {
	
	/**
	 * Construtor padrao
	 */
	protected Tempo () { }
	
	
	/* (non-Javadoc)
	 * @see ITempo#tempo(java.text.SimpleDateFormat)
	 */
	public String tempo (String tempoFormato) {
		SimpleDateFormat sdf = new SimpleDateFormat(tempoFormato);
		return sdf.format(new Date(System.currentTimeMillis()));
	}

}
