package study.effectivejava.item18.case1;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -126988860240333378L;
	private int addCount;

	public InstrumentedHashSet() {

	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}	

	public int getAddCount() {
		return addCount;
	}
}