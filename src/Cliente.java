import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
	
/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief Implementa o cliente na relacao RMI
 */
public class Cliente {

	/**
	 * @brief Contem os formatos de datas/horas validas para esta aplicacao
	 */
	public static String[] formatosValidos = {
			"dd-MM-yyyy", "MM-dd-yyyy", 
			"HH:mm:ss", "hh:mm:ss a", 
            "dd-MM-yyyy HH:mm:ss", "MM-dd-yyyy HH:mm:ss", 
            "dd-MM-yyyy hh:mm:ss a", "MM-dd-yyyy hh:mm:ss a"};

	/**
	 * @brief Contem os formatos de datas/horas validas para esta aplicacao, de forma legivel para humanos
	 */
	public static String[] formatosValidosHumanReadable = {
			"dia-mes-ano", "mes-dia-ano", 
			"hora:minuto:segundo 24h", "hora:minuto:segundo AM/PM",
            "dia-mes-ano hora:minuto:segundo 24h", "mes-dia-ano hora:minuto:segundo 24h",
            "dia-mes-ano hora:minuto:segundo AM/PM", "mes-dia-ano hora:minuto:segundo AM/PM"
	};

	public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
		ITempo stub = (ITempo) Naming.lookup("rmi://localhost/Tempo");
		Scanner input = new Scanner(System.in);
		int escolha = 0;
		
		boolean condicao = true;
		while(condicao) {
			printMenu();	
			try { 
				escolha = input.nextInt();
				if(escolha==0) {
					condicao=false;
				} else if(escolha>0 && escolha<=formatosValidos.length) {
					System.out.println("Formato escolhido     -> "+formatosValidosHumanReadable[escolha-1]);
					System.out.println("Resultado do servidor -> "+stub.tempo(new SimpleDateFormat(formatosValidos[escolha-1]))+"\n\n\n");
				} else {
					System.out.println("Opcao invalida! Tente novamente...\n\n\n\n");
				}
			} catch (InputMismatchException ex) {
				input = new Scanner(System.in);
				System.out.println("Opcao invalida! Tente novamente...\n\n\n\n");
			} 			
		}	
		System.out.println("Encerrando a aplicacao no cliente...");
	}

	/**
	 * @brief Imprime o menu de opcoes na saida padrao
	 */
	public static void printMenu() {
		System.out.println(" --- Servidor de tempo ---");
		System.out.println("As nossas opcoes de requisicao de tempo sao as seguintes: ");
		System.out.println();
		int cont = 1;
		for (String fvhr : formatosValidosHumanReadable) {
			System.out.println(cont+" - "+fvhr);
			cont++;
		}
		System.out.println("0 - Sair");
		System.out.println();
	}
}
