package com.accc.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.accc.domain.model.Parts;

public class PartsDTO {
	private String parts;
	private String amount;

	public PartsDTO() {
	}

	public PartsDTO(String parts, String amount) {
		this.parts = parts;
		this.amount = amount;
	}

	public static List<PartsDTO> buildFromEntities(List<Parts> parts) {
		return parts.stream().map(part -> {
			return new PartsDTO(part.getDescription(), part.getAmount().toString());
		}).collect(Collectors.toList());
	}

	public String getParts() {
		return parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PartsDTO [parts=" + parts + ", amount=" + amount + "]";
	}

}
