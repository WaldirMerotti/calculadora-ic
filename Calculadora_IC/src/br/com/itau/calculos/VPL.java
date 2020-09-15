package br.com.itau.calculos;

public class VPL {

	private VPL() {

	}

	/**
	 * Calcule o valor presente dos fluxos com uma taxa espec�fica. <BR>
	 * Use um modelo matem�tico para o c�lculo dado pela f�rmula: <BR>
	 * <img src = "../../ resources / vp.png" />
	 *
	 * @param fluxos � a lista de fluxos.
	 * @param taxa   � o valor da taxa.
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
	 * Calcula o valor presente l�quido dos fluxos com uma taxa espec�fica. <BR>
	 * Equivale a calcular o valor presente menos o investimento inicial. <BR>
	 * Use um modelo matem�tico para o c�lculo dado pela f�rmula: <BR>
	 * <img src = "../../ resources / vpn.png" />
	 *
	 * @param fluxos    lista de fluxos.
	 * @param taxa      � o valor da taxa.
	 * @param inversion � o investimento inicial.
	 * @return o valor presente l�quido.
	 */
	public static double calcularValorPresenteLiquido(Fluxos fluxos, double taxa, double inversion) {
		return calcularValorPresente(fluxos, taxa) - inversion;
	}

	/**
	 * Calcula a primeira derivada do valor presente l�quido com uma taxa
	 * espec�fico. <BR>
	 * Use um modelo matem�tico para o c�lculo dado pela f�rmula: <BR>
	 * <img src = "../../ resources / vpnprima.png" />
	 *
	 * @param fluxos lista de fluxos.
	 * @param taxa   � o valor da taxa.
	 * @return o valor presente l�quido
	 */
	public static double calcularPimeiraDerivadaVPL(Fluxos fluxos, double taxa) {
		double retVal = 0.0;
		for (int i = 1; i <= fluxos.size(); i++) {
			retVal -= (fluxos.getFluxo(i) * i) / Math.pow(1.0 + taxa, (i + 1));
		}
		return retVal;
	}

}
