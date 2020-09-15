package br.com.itau.emprestimos;

public class Emprestimo {

    private Emprestimo() {
    }

    /**
     * Calcula as quotas de um emprestimo utilizando o metodo de saldo nao pago.
     * @param montante eh o valor do emprestimo.
     * @param taxa eh a taxa nominal.
     * @param prazos eh o numero de periodos no qual se vai pagar um emprestimo.
     * @param tipo eh o tipo de taxa, por exemplo:
     * Semanal, Quinzenal, Mensal, etc).
     * @param periodoInicial eh o periodo no qual sera realizado o primeiro pagamento.
     * @return uma lista de Quotas.
     */
    public static Quotas calcularSaldoNaoPago(double montante, double taxa, int prazos, TipoTaxa tipo, int periodoInicial) {
        Quotas retVal = new Quotas();

        double saldo = montante;
        final double pagoCapital = montante / prazos;
        double pi;

        for (int i = 1; i <= (periodoInicial - 1); i++) {
            retVal.addQuotaInfo(0, 0, 0, saldo); 
        }

        for (int i = 1; i <= prazos; i++) {
            pi = saldo * tpc(taxa, tipo);
            saldo -= pagoCapital;
            retVal.addQuotaInfo(pagoCapital + pi, pagoCapital, pi, saldo);
        }

        return retVal;
    }

    /**
     * Calcula as quotas de um emprestimo utilizando o metodo de saldo nao pago.
     * @param montante eh o valor do emprestimo.
     * @param taxa eh a taxa nominal.
     * @param prazos eh o numero de periodos no qual se vai pagar um emprestimo.
     * @param tipo eh o tipo de taxa, por exemplo:
     * Semanal, Quinzenal, Mensal, etc).
     */
    public static Quotas calcularSaldoNaoPago(double montante, double taxa, int prazos, TipoTaxa tipo) {
        return calcularSaldoNaoPago(montante, taxa, prazos, tipo, 1);
    }

    /**
     * Calcula as quotas de um emprestimo usando o metodo de cota de nível.
     * @param montante eh o valor do emprestimo.
     * @param taxa eh a taxa nominal.
     * @param prazos eh o numero de periodos no qual se vai pagar um emprestimo.
     * @param tipo eh o tipo de taxa, por exemplo:
     * Semanal, Quinzenal, Mensal, etc).
     * @param periodoInicial eh o periodo no qual sera realizado o primeiro pagamento.
     * @return uma lista de Quotas.
     */
    
    public static Quotas calcularQuotaNivelada(double montante, double taxa, int prazos, TipoTaxa tipo, int periodoInicial) {
        Quotas retVal = new Quotas();

        double quota = getQuotaNivelada(montante, taxa, prazos, tipo);
        double saldo = montante;

        for (int i = 1; i <= (periodoInicial - 1); i++) {
            retVal.addQuotaInfo(0, 0, 0, saldo);
        }

        for (int i = 1; i <= prazos; i++) {
            double pi = saldo * tpc(taxa, tipo);
            saldo -= (quota - pi);
            retVal.addQuotaInfo(quota, quota - pi, pi, saldo);
        }

        return retVal;
    }

    /**
     * Calcula as quotas de um emprestimo usando o metodo de cota de nível.
     * @param montante eh o valor do emprestimo.
     * @param taxa eh a taxa nominal.
     * @param prazos eh o numero de periodos no qual se vai pagar um emprestimo.
     * @param tipo eh o tipo de taxa, por exemplo:
     * Semanal, Quinzenal, Mensal, etc).
     * @return uma lista de Quotas.
     */
    public static Quotas calcularQuotaNivelada(double montante, double taxa, int prazos, TipoTaxa tipo) {
        return calcularQuotaNivelada(montante, taxa, prazos, tipo, 1);
    }

    /**
     * Obtém o valor da cota de emprestimo utilizando utilizando o método de cota de nivel.
     *
     * @param montante eh o valor do emprestimo.
     * @param taxa eh a taxa nominal.
     * @param prazos eh o numero de periodos no qual se vai pagar um emprestimo.
     * @param tipo eh o tipo de taxa, por exemplo:
     * Semanal, Quinzenal, Mensal, etc).
     * @return
     */
    public static double getQuotaNivelada(double montante, double taxa, int prazos, TipoTaxa tipo) {
        return montante * tpc(taxa, tipo) / (1 - Math.pow(1 + tpc(taxa, tipo), -prazos));
    }

    /**
     * Devolve o valor do tipo da taxa, de acordo com a formula: Taxa / Tipo.
     * <BR>Nota: este valor eh utilizado para calcular o valor de juros sobre o capital.
     *
     * @param taxa eh a taxa nominal.
     * @param taxa é a taxa ou porcentagem de juros.
     * @return eh o valor percentual.
     */
    public static double tpc(double taxa, TipoTaxa tipo) {
        return taxa / tipo.valor();
    }
}
