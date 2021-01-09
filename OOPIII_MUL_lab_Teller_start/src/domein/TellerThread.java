package domein;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;

public class TellerThread implements Runnable {

	private IntegerProperty teller = new SimpleIntegerProperty();
	private Lock accessLock = new ReentrantLock();
	private Condition pauzeGewijzigd = accessLock.newCondition();
	private boolean pauze = false;
	private boolean going = true;

	public void addObserver(ChangeListener<? super Number> listener) {
		teller.addListener(listener);
	}

	public void suspend() {
		// als het slot vrij is dan gaat de thread dit op slot doen.
		// is het slot bezet dan gaat de thread in wacht
		// zet dit in een try-finally zodat je zeker bent dat het slot wordt vrijgegeven

		try {
			accessLock.lock();
			pauze = true;
			// omdat de waarde van pauze gewijzigd is
			// pauzeGewijzigd wakker maken en de conditie laten evalueren in de run
			pauzeGewijzigd.signal();

		} finally {
			accessLock.unlock();
		}

	}

	public void resume() {
		try {
			accessLock.lock();
			pauze = false;
			// omdat de waarde van pauze gewijzigd is
			// pauzeGewijzigd wakker maken en de conditie laten evalueren in de run
			pauzeGewijzigd.signal();
		} finally {
			accessLock.unlock();
		}
	}

	public void stop() {
		try {
			accessLock.lock();
			going = false;
		} finally {
			accessLock.unlock();
		}
	}

	@Override
	public void run() {
		while (going) {
			teller.set(teller.get() + 1);
			try {
				Thread.sleep(100);
				// TODO nagaan of er moet gepauzeerd worden
				// en indien zo Thread in wait toestand brengen
				accessLock.lock();

				while (pauze == true) {
					pauzeGewijzigd.await();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} finally {
				accessLock.unlock();
			}

		}
	}
}
