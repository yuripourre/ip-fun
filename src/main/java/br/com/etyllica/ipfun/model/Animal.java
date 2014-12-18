package br.com.etyllica.ipfun.model;

public enum Animal {

	CAT(0), 
	CHICKEN(1), 
	COW(2),
	DOG(3),
	DONKEY(4),
	DUCK(5),
	ELEPHANT(6),
	FOX(7),
	HIPPO(8),
	KOALA(9),
	MOUSE(10),
	PANDA(11),
	PENGUIN(12),
	PIG(13),
	RABBIT(14),
	SHEEP(15);

	private Animal(int value) {
		this.value = value;
	}

	private final int value;

	public int getValue() {
		return value;
	}

}
