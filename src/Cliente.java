package temp;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPFaultException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.sun.xml.internal.ws.client.;
	

  @author Joaliton Luan Pereira Ferreira
  @author Shirley Ohara Telemaco de Freitas
  @brief Implementa o cliente na relacao RMI
 
public class Cliente {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL(http127.0.0.19876tempwsdl);
		QName qname = new QName(httptemp,TempoService);
		
		Service ws = Service.create(url, qname);
		ITempo temp = ws.getPort(ITempo.class);
			
		System.out.println(Result from yyyy-MM-dd  + temp.tempo(yyyy-MM-dd));

		Scanner input = new Scanner(System.in);
		int escolha = -1;
		while(escolha != 0) {
			printMenu();	
			try {
				String escolhaString = input.nextLine();

				escolha = Integer.parseInt(escolhaString);
				if (escolha != 1) System.out.println(Opcao invalida! Tente novamente...nn);
				else {
					System.out.println(Digite o formato desejado );
					input = new Scanner(System.in);
					String format = input.nextLine();
					
					try {
						System.out.println(Resultado do servidor -  + temp.tempo(format) + nn);
					} catch (SOAPFaultException ex) {
						System.out.println(Formato invalido! Tente novamente...nn);
					} catch (ClientTransportException e) {
						System.out.println(Conecção com o servidor foi perdida);
					} 
				}
			} catch (NumberFormatException  InputMismatchException ex) {
				System.out.println(Opcao invalida! Tente	 novamente...nn);
			} 
		}	
		input.close();
		System.out.println(Encerrando a aplicacao no cliente...);
	}

	
	  @brief Imprime o menu de opcoes na saida padrao
	 
	public static void printMenu() {
		System.out.println( --- Servidor de tempo ---);
		System.out.println(As nossas opcoes de requisicao de tempo sao as seguintes n);
		System.out.println(0 - Sair);
		System.out.println(1 - Digitar Formato de tempon);
	}
}
