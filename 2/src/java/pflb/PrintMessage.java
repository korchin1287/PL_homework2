package pflb;

import ru.pflb.mq.dummy.interfaces.Producer;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintMessage {
	public PrintMessage() {
	}

	public void print(Producer producer, ArrayList<String> arrayList) throws InterruptedException {
		Iterator iterator = arrayList.iterator();
		while (iterator.hasNext()){
			producer.send(String.valueOf(iterator.next()));
			Thread.sleep(2000);
		}
	}
}
