package temp;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPFaultException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.sun.xml.internal.ws.client.*;
	
/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief Implementa o cliente na relacao RMI
 * @version 04.10.2018
 **/
public class Cliente {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://127.0.0.1:9876/temp?wsdl");
		QName qname = new QName("http://temp/","TempoService");
		
		Service ws = Service.create(url, qname);
		ITempo temp = ws.getPort(ITempo.class);


		Scanner input = new Scanner(System.in);
		int escolha = -1;
		while(escolha != 0) {
			printMenu();	
			try {
				String escolhaString = input.nextLine();

				escolha = Integer.parseInt(escolhaString);
				if (escolha != 1) System.out.println("Opcao invalida! Tente novamente...\n\n");
				else {
					System.out.println("Digite o formato desejado: ");
					input = new Scanner(System.in);
					String format = input.nextLine();
					
					try {
						System.out.println("Resultado do servidor -> " + temp.tempo(format) + "\n\n");
					} catch (SOAPFaultException ex) {
						System.out.println("Formato invalido! Tente novamente...\n\n");
					} catch (ClientTransportException e) {
						System.out.println("ATENÇÂO! Conecção com o servidor foi perdida \n\n");
					} 
				}
			} catch (NumberFormatException | InputMismatchException ex) {
				System.out.println("Opcao invalida! Tente	 novamente...\n\n");
			} 
		}	
		input.close();
		System.out.println("Encerrando a aplicacao no cliente...");
	}

	/**
	 * @brief Imprime o menu de opcoes na saida padrao
	 */
	public static void printMenu() {
		System.out.println(" --- Servidor de tempo --- ");
		System.out.println("Escolha uma opção: \n");
		System.out.println("0 - Sair");
		System.out.println("1 - Digitar Formato de tempo \n");
	}
}
