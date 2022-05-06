package com.bycoders.desafiodev.api.cnabparser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
class CNAB {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	Type type;
	@Getter
	LocalDate date;
	@Getter
	Double value;
	@Getter
	String cpf;
	@Getter
	String card;
	@Getter
	LocalTime hour;
	@Getter
	String owner;
	@Getter
	String store;
	
	public static CNAB from(String line) {
		return CNAB
		.builder()
		.type(Type.by(readField(Fields.TYPE[0], Fields.TYPE[1], line)))
		.date(toDate(Fields.DATE, line))
		.value(toDouble(Fields.VALUE, line)/100)
		.cpf(readField(Fields.CPF[0], Fields.CPF[1], line))
		.card(readField(Fields.CARD[0], Fields.CARD[1], line))
		.hour(toHour(Fields.HOUR, line))
		.owner(readField(Fields.OWNER[0], Fields.OWNER[1], line))
		.store(readField(Fields.STORE[0], line.length(), line))
		.build();
	}
	
	
	private static LocalDate toDate(Object[] dateField, String line) {
		int start = ((Integer)dateField[0]).intValue();
		int end = ((Integer)dateField[1]).intValue();
		String pattern = ((String)dateField[3]);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(readField(start, end, line), formatter);
	}
	
	private static Double toDouble(int [] valueField, String line) {
		return Double.valueOf(readField(valueField[0], valueField[1], line));
	}
	
	private static LocalTime toHour(Object[] hourField, String line) {
		int start = ((Integer)hourField[0]).intValue();
		int end = ((Integer)hourField[1]).intValue();
		String pattern = ((String)hourField[3]);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalTime.parse(readField(start, end, line), formatter);
	}


	private static String readField(int start, int end, String reg) {
		return reg.substring(start, end);
	}
}
