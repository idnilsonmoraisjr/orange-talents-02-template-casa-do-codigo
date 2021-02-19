package br.com.zup.casadocodigo.config.validacao;

public class FieldErrorOutputDto {

	private String field;
	private String message;
	
	public FieldErrorOutputDto(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
}
