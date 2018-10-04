import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author Joaliton Luan Pereira Ferreira
 * @author Shirley Ohara Telemaco de Freitas
 * @brief Uma classe para definir o servidor de tempo no padrao RMI.
 */
public class Servidor {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// Execução do modulo de referencia remota (RMI Registry)
		LocateRegistry.createRegistry(1099);
		
		// Instanciacao do servente
		Tempo tempo = new Tempo();
		
		// Registro do servente no modulo de referencia remota (RMI Registry)
		Naming.rebind("rmi://localhost/Tempo", tempo);
		System.out.println("Servidor pronto e registrado no RMI Registry.");

	}

}
