package org.module.common.dataservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class MyList<E> extends ArrayList<E> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyList() {
		// TODO Auto-generated constructor stub
	}

	public MyList(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	public MyList(Collection<? extends E> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

}
