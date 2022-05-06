package com.bycoders.desafiodev.api.cnabparser;

public enum Type {
	
	DEBITO(1, "Débito", "Entrada", "+"), 
	BOLETO(2, "Boleto", "Saída", "-"), 
	FINANCIAMENTO(3, "Financiamento", "Saída", "-"), 
	CREDITO(4, "Crédito", "Entrada", "+"),  
	RECEBIMENTO_EMPRESTIMO(5, "Recebimento Empréstimo", "Entrada", "+"),  
	VENDAS(6, "Vendas", "Entrada", "+"), 
	RECEBIMENTO_TED(7, "Recebimento TED", "Entrada", "+"),  
	RECEBIMENTO_DOC(8, "Recebimento DOC", "Entrada", "+"),  
	ALUGUEL(9, "Aluguel", "Saída", "-") ;
	
	 Integer cod;
	 String description;
	 String source;
	 String sign;
	
	private Type(Integer cod, String description, String source, String sign) {
		this.cod = cod;
		this.description = description;
		this.source = source;
		this.sign = sign;
	}
	
	public static Type by(String cod) throws IllegalArgumentException {
		switch (cod) {
		case "1":
			return DEBITO;
		case "2":
			return BOLETO;
		case "3":
			return FINANCIAMENTO;
		case "4":
			return CREDITO;
		case "5":
			return RECEBIMENTO_EMPRESTIMO;
		case "6":
			return VENDAS;
		case "7":
			return RECEBIMENTO_TED;
		case "8":
			return RECEBIMENTO_DOC;
		case "9":
			return ALUGUEL;
		default:
			throw new IllegalArgumentException("Type not found"); 
		}		
	}
}
