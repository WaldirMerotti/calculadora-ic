package br.com.itau.calculos;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Fluxos {

	// fluxos para nós são as parcelas
	protected ArrayList<Double> fluxos = new ArrayList<Double>();

	public Fluxos() {
	}

	/**
	 * Adiciona o fluxo no final.
	 *
	 * @param fluxo é o valor do fluxo.
	 */
	public void adicionarFluxo(double fluxo) {
		fluxos.add(fluxo);
	}

	/**
	 * Adiciona os fluxos no final.
	 *
	 * @param flows é a lista de fluxos.
	 */
	public void adicionarFluxos(double... fluxos) {
		for (double f : fluxos) {
			adicionarFluxo(f);
		}
	}

	/**
	 * Adiciona os fluxos no final.
	 *
	 * @param fluxos é a lista de fluxos.
	 * @see VPL.reasons.VPN #adicionarFluxos (double ...)
	 */
	public void adicionarFluxos(ArrayList<Double> fluxos) {
		for (Double f : fluxos) {
			adicionarFluxo(f);
		}
	}

	/**
	 * Retorna o valor do fluxo para um período específico. <BR>
	 * <B> <I> Nota: os períodos começam em 1. </I> </B>
	 *
	 * @param periodo é o período do fluxo.
	 * @return o valor do fluxo.
	 */
	public double getFluxo(int periodo) {
		if (periodo < 1 || periodo > fluxos.size()) {
			throw new IllegalArgumentException("Período fora do intervalo");
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
	 * Define o valor do fluxo para um período específico. <BR>
	 * <B> <I> Nota: os períodos começam em 1. </I> </B>
	 *
	 * @param periodo é o período do fluxo.
	 * @param fluxo   é o valor do fluxo.
	 */
	public void setFluxo(int periodo, double fluxo) {
		if (periodo < 1 || periodo > fluxos.size()) {
			throw new IllegalArgumentException("Período fora do intervalo");
		}
		fluxos.set(periodo - 1, fluxo);
	}

	/**
	 * Fluxos estáveis.
	 *
	 * @param fluxos é a lista de fluxos.
	 */
	public void setFlujos(double... fluxos) {
		this.fluxos.clear();
		adicionarFluxos(fluxos);
	}

	/**
	 * Fluxos estáveis.
	 *
	 * @param fluxos é a lista de fluxos.
	 */
	public void setFlujos(ArrayList<Double> fluxos) {
		this.fluxos.clear();
		adicionarFluxos(fluxos);
	}

	/**
	* Soma o valor do montante ao fluxo do período. <B> <I> Nota: os períodos
	* começam em 1. </I> </B>
	*
	* @param periodo é o período do fluxo.
	* @param quantidade é o valor a ser adicionado.
	*/
	public void somarAoFluxo(int periodo, double montante) {
		if (periodo < 1 || periodo > fluxos.size()) {
			throw new IllegalArgumentException("Período fora do intervalo");
		}
		fluxos.set(periodo - 1, fluxos.get(periodo - 1) + montante);
	}

	/**
	* Subtrai o valor do montante do fluxo do período. <B> <I> Nota: os períodos
	* comece em 1. </I> </B>
	*
	* @param periodo é o período do fluxo.
	* @param quantidade é o valor a ser subtraído.
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
