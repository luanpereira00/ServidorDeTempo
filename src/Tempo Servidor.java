package temp;

import javax.xml.ws.Endpoint;

/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief Uma classe para definir publicar o servidor de tempo em SOAP
 */
public class TempoServidor {
	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9876/", new Tempo());
		System.out.println("Hey, I'm running");
	}
}