package control;

import java.util.ArrayList;

public interface IDB<E,B,K> {
	/*
	 * E: Entity
	 * B: Boolean
	 * K: String, Int,...
	 */
	public B add(E e);	
	public B delete (K k);
	public B update (E e);
	public E find(K k);
	public ArrayList<E> getAll();
	
	

}
