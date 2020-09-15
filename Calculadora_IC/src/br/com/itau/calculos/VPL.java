package br.com.itau.calculos;

public class VPL {

	private VPL() {

	}

	/**
	 * Calcule o valor presente dos fluxos com uma taxa específica. <BR>
	 * Use um modelo matemático para o cálculo dado pela fórmula: <BR>
	 * <img src = "../../ resources / vp.png" />
	 *
	 * @param fluxos é a lista de fluxos.
	 * @param taxa   é o valor da taxa.
	 * @retorne o valor presente.
	 */
	public static double calcularValorPresente(Fluxos fluxos, double taxa) {
		double retVal = 0.0;

		for (int i = 1; i <= fluxos.size(); i++) {
			retVal += fluxos.getFluxo(i) / Math.pow(1.0 + taxa, i);
		}

		return retVal;
	}

	/**
	 * Calcula o valor presente líquido dos fluxos com uma taxa específica. <BR>
	 * Equivale a calcular o valor presente menos o investimento inicial. <BR>
	 * Use um modelo matemático para o cálculo dado pela fórmula: <BR>
	 * <img src = "../../ resources / vpn.png" />
	 *
	 * @param fluxos    lista de fluxos.
	 * @param taxa      é o valor da taxa.
	 * @param inversion é o investimento inicial.
	 * @return o valor presente líquido.
	 */
	public static double calcularValorPresenteLiquido(Fluxos fluxos, double taxa, double inversion) {
		return calcularValorPresente(fluxos, taxa) - inversion;
	}

	/**
	 * Calcula a primeira derivada do valor presente líquido com uma taxa
	 * específico. <BR>
	 * Use um modelo matemático para o cálculo dado pela fórmula: <BR>
	 * <img src = "../../ resources / vpnprima.png" />
	 *
	 * @param fluxos lista de fluxos.
	 * @param taxa   é o valor da taxa.
	 * @return o valor presente líquido
	 */
	public static double calcularPimeiraDerivadaVPL(Fluxos fluxos, double taxa) {
		double retVal = 0.0;
		for (int i = 1; i <= fluxos.size(); i++) {
			retVal -= (fluxos.getFluxo(i) * i) / Math.pow(1.0 + taxa, (i + 1));
		}
		return retVal;
	}

}
