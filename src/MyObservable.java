package CUS1156Project3;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is an abstract class which maintains a list of observers (Users) and 
 * notifies them for any changes in the restaurants reviews.
 * @author sayefiqbal
 *
 */
public abstract class MyObservable implements Serializable{
	
protected ArrayList<MyObserver> observers = new ArrayList<MyObserver>();
public void notifyObservers(Object stuff)
{
for(MyObserver curr: observers)
{
	curr.update(this, stuff);
}
}

public void addObserver(User observer)
{
	observers.add(observer);
}

}
