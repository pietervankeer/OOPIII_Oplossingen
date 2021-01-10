package domein;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class VerzoekLogger {
   private final BlockingQueue queue= new ArrayBlockingQueue<>(1000);


   public  void log(String string) {
      try {
		queue.put(string);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }
   
   public String haalLogOp(){
       try {
		queue.take();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
       
       return null;
   }
    
}
