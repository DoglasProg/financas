package br.com.financas.controller.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.financas.controller.validator.annotation.CpfCnpj;

/**
 * Classe com validação para CPF/CNPJ
 * 
 * @author doglas
 *
 */
public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String>{
	
	private static final int[] PESO_CPF  = new int[] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] PESO_CNPJ = new int[] { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
	
    public static final int TAMANHO_CPF = 11;
    public static final int TAMANHO_CNPJ = 14;
	
	private static final int CPF_SUBSTRING = 9;
	private static final int CNPJ_SUBSTRING = 12;

	@Override
	public void initialize(CpfCnpj cpfCnpj) {
	}

	@Override
	public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {

		boolean isValid = false;

		if (valor != null) {

			Pattern numerosRepTest = Pattern
					.compile("(?!(\\d)\\1{" + (valor.length() - 1) + "})\\d{" + valor.length() + "}");

			isValid = numerosRepTest.matcher(valor).matches() && (isCpf(valor) || isCnpj(valor));

		}

		return isValid;

	}

	private static boolean isCnpj(String cnpj) {

		return cnpj.length() == TAMANHO_CNPJ && verificarDigitos(cnpj, PESO_CNPJ, CNPJ_SUBSTRING);
	}

	private static boolean isCpf(String cpf) {

		return cpf.length() == TAMANHO_CPF && verificarDigitos(cpf, PESO_CPF, CPF_SUBSTRING);

	}

	private static boolean verificarDigitos(String valor, int[] peso, int substring) {

		Integer digito1 = calcularDigito(valor.substring(0, substring), peso);
		Integer digito2 = calcularDigito(valor.substring(0, substring) + digito1, peso);
		return valor.equals(valor.substring(0, substring) + digito1.toString() + digito2.toString());

	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		int digito;
		
		for (int indice = str.length() - 1; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

}
