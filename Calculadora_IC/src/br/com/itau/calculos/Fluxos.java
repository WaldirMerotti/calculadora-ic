package br.com.itau.calculos;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Fluxos {

	// fluxos para n�s s�o as parcelas
	protected ArrayList<Double> fluxos = new ArrayList<Double>();

	public Fluxos() {
	}

	/**
	 * Adiciona o fluxo no final.
	 *
	 * @param fluxo � o valor do fluxo.
	 */
	public void adicionarFluxo(double fluxo) {
		fluxos.add(fluxo);
	}

	/**
	 * Adiciona os fluxos no final.
	 *
	 * @param flows � a lista de fluxos.
	 */
	public void adicionarFluxos(double... fluxos) {
		for (double f : fluxos) {
			adicionarFluxo(f);
		}
	}

	/**
	 * Adiciona os fluxos no final.
	 *
	 * @param fluxos � a lista de fluxos.
	 * @see VPL.reasons.VPN #adicionarFluxos (double ...)
	 */
	public void adicionarFluxos(ArrayList<Double> fluxos) {
		for (Double f : fluxos) {
			adicionarFluxo(f);
		}
	}

	/**
	 * Retorna o valor do fluxo para um per�odo espec�fico. <BR>
	 * <B> <I> Nota: os per�odos come�am em 1. </I> </B>
	 *
	 * @param periodo � o per�odo do fluxo.
	 * @return o valor do fluxo.
	 */
	public double getFluxo(int periodo) {
		if (periodo < 1 || periodo > fluxos.size()) {
			throw new IllegalArgumentException("Per�odo fora do intervalo");
		}
		return fluxos.get(periodo - 1);
	}

	/**
	 * Retorna a lista de fluxos.
	 *
	 * @return um vetor com os fluxos.
	 */
	public double[] getFluxos() {
		double[] retVal = new double[fluxos.size()];
		for (int i = 0; i < retVal.length; i++) {
			retVal[i] = fluxos.get(i);
		}
		return retVal;
	}

	/**
	 * Retorna a lista de fluxos.
	 *
	 * @return uma lista de fluxos.
	 */
	public ArrayList<Double> getFluxosLista() {
		return fluxos;
	}

	/**
	 * Define o valor do fluxo para um per�odo espec�fico. <BR>
	 * <B> <I> Nota: os per�odos come�am em 1. </I> </B>
	 *
	 * @param periodo � o per�odo do fluxo.
	 * @param fluxo   � o valor do fluxo.
	 */
	public void setFluxo(int periodo, double fluxo) {
		if (periodo < 1 || periodo > fluxos.size()) {
			throw new IllegalArgumentException("Per�odo fora do intervalo");
		}
		fluxos.set(periodo - 1, fluxo);
	}

	/**
	 * Fluxos est�veis.
	 *
	 * @param fluxos � a lista de fluxos.
	 */
	public void setFlujos(double... fluxos) {
		this.fluxos.clear();
		adicionarFluxos(fluxos);
	}

	/**
	 * Fluxos est�veis.
	 *
	 * @param fluxos � a lista de fluxos.
	 */
	public void setFlujos(ArrayList<Double> fluxos) {
		this.fluxos.clear();
		adicionarFluxos(fluxos);
	}

	/**
	* Soma o valor do montante ao fluxo do per�odo. <B> <I> Nota: os per�odos
	* come�am em 1. </I> </B>
	*
	* @param periodo � o per�odo do fluxo.
	* @param quantidade � o valor a ser adicionado.
	*/
	public void somarAoFluxo(int periodo, double montante) {
		if (periodo < 1 || periodo > fluxos.size()) {
			throw new IllegalArgumentException("Per�odo fora do intervalo");
		}
		fluxos.set(periodo - 1, fluxos.get(periodo - 1) + montante);
	}

	/**
	* Subtrai o valor do montante do fluxo do per�odo. <B> <I> Nota: os per�odos
	* comece em 1. </I> </B>
	*
	* @param periodo � o per�odo do fluxo.
	* @param quantidade � o valor a ser subtra�do.
	*/
	public void subtrairAoFluxo(int periodo, double montante) {
		somarAoFluxo(periodo, -montante);
	}

	public void print(String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);

		for (int i = 0; i < fluxos.size(); i++) {
			System.out.printf("%1$3s %2$20s\n", i + 1, df.format(fluxos.get(i)));
		}
	}

	public int size() {
		return fluxos.size();
	}
}
