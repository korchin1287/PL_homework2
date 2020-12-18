package pflb;

import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.interfaces.Connection;
import ru.pflb.mq.dummy.interfaces.Destination;
import ru.pflb.mq.dummy.interfaces.Producer;
import ru.pflb.mq.dummy.interfaces.Session;
import java.util.ArrayList;


public class Main {
	static ArrayList<String> arrayList;

	public static void main(String[] args) {
		try (Connection connection = new ConnectionImpl();
		     Session session = connection.createSession(true);) {
			Destination destination = session.createDestination("myQueue");
			Producer producer = session.createProducer(destination);
			arrayList = new ArrayList<>();
			ReadFile readFile = new ReadFile();
			PrintMessage printMessage = new PrintMessage();
			while (true) {
				readFile.addFile(args[0], arrayList);
				printMessage.print(producer, arrayList);
			}
		} catch (Exception e){
			System.out.println("Там в общем ошибка, в открытии session");
		}
	}
}
