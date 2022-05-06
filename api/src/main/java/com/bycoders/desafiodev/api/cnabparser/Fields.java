package com.bycoders.desafiodev.api.cnabparser;


public class Fields {
	
	private Fields() {}
	public static final int [] TYPE = {0,1,1};
	public static final Object [] DATE = {1,9,8, "yyyyMMdd"};
	public static final int [] VALUE = {9,19,10};
	public static final int [] CPF = {19,30,11};
	public static final int [] CARD = {30,42,11};
	public static final Object [] HOUR = {42,48,6, "HHmmss"};
	public static final int [] OWNER = {48,62,14};
	public static final int [] STORE = {62,81,19};

	
}
