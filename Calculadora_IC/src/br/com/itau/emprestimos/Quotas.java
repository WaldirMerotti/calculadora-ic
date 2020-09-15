package br.com.itau.emprestimos;

import br.com.itau.calculos.Fluxos;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Quotas {


    public static final int VALOR_QUOTA = 0;
    public static final int PAGO_CAPITAL = 1;
    public static final int PAGO_JUROS = 2;
    public static final int SALDO = 3;
    private ArrayList<double[]> quotas = new ArrayList<double[]>();

    public Quotas() {
    }

    /**
     * Retorna o tamanho da lista de cotas.
     *
     * @return o tamanho da lista.
     */
    public int size() {
        return quotas.size();
    }

    /**
     * Indica se a lista de quotas está vazia ou não.
     *
     * @return true se a lista esta vazia, se nao, false.
     */
    public boolean isEmpty() {
        return quotas.isEmpty();
    }

    /**
     * Adiciona uma quota
     * @param taxa é o valor da taxa. (considere quota = taxa)
     * @param pagoCapital é o valor do pagamento de capital.
     * @param pagoInteres é o valor do pagamento de juros.
     * @param saldo é o valor do saldo devedor.
     */
    public void addQuotaInfo(double quota, double pagoCapital, double pagoJuros, double saldo) {
        quotas.add(new double[]{quota, pagoCapital, pagoJuros, saldo});
    }

    /**
    * Modifica a cota para um período específico.
    * @param período eh o número do período.
    * @param quota eh é o valor da quota.
    * @param pagoCapital é o valor do pagamento de capital.
    * @param pagoJuros é o valor do pagamento de juros.
    * @param balance é o valor do saldo em dívida.
    */
    public void setQuotaInfo(int periodo, double quota, double pagoCapital, double pagoJuros, double saldo) {
        if (periodo < 1 || periodo > quotas.size()) {
            throw new IllegalArgumentException("Período fora do intervalo");
        }
        quotas.set(periodo - 1, new double[]{quota, pagoCapital, pagoJuros, saldo});
    }

    /**
    * Retorna a taxa de um período específico.
    * @param período o número do período.
    * @return um acordo com as informações de cota.
    */
    public double[] getQuotaInfo(int periodo) {
        if (periodo < 1 || periodo > quotas.size()) {
            throw new IllegalArgumentException("Período fora do intervalo");
        }
        return quotas.get(periodo - 1);
    }
    
    
    private double get(int periodo, int what) {
        if (periodo < 1 || periodo > quotas.size()) {
            throw new IllegalArgumentException("Período fora do intervalo");
        }
        return quotas.get(periodo - 1)[what];
    }

    /**
    * Retorna o valor da taxa.
    * @param período o número do período.
    * @Retorna
    */
    public double getValorQuota(int periodo) {
        return get(periodo, VALOR_QUOTA);
    }

    /**
    * Retorna o valor do pagamento de capital.
    * @param período o número do período.
    * @Retorna
    */
    public double getPagoCapital(int periodo) {
        return get(periodo, PAGO_CAPITAL);
    }

    /**
    * Retorna o valor do pagamento de juros.
    * @param período o número do período.
    * @Retorna
    */
    public double getPagoJuros(int periodo) {
        return get(periodo, PAGO_JUROS);
    }

    /**
     *
     * @param periodo
     * @return
     */
    public double getSaldo(int periodo) {
        return get(periodo, SALDO);
    }

    private void set(int periodo, int what, double valor) {
        if (periodo < 1 || periodo > quotas.size()) {
            throw new IllegalArgumentException("Período fora do intervalo");
        }
        quotas.get(periodo - 1)[what] = valor;
    }

    /**
     *
     * @param periodo
     * @param valorCuota
     */
    public void setValorQuota(int periodo, double valorQuota) {
        set(periodo, VALOR_QUOTA, valorQuota);
    }

    /**
     *
     * @param periodo
     * @param pagoCapital
     */
    public void setPagoCapital(int periodo, double pagoCapital) {
        set(periodo, PAGO_CAPITAL, pagoCapital);
    }

    /**
     *
     * @param periodo
     * @param pagoJuros
     */
    public void setPagoInteres(int periodo, double pagoJuros) {
        set(periodo, PAGO_JUROS, pagoJuros);
    }

    /**
     *
     * @param periodo
     * @param saldo
     */
    public void setSaldo(int periodo, double saldo) {
        set(periodo, SALDO, saldo);
    }

    /**
     *
     * @return
     */
    public Fluxos getFluxos() {
        Fluxos retVal = new Fluxos();

        for (double[] c : quotas) {
            retVal.adicionarFluxo(c[VALOR_QUOTA]);
        }

        return retVal;
    }

    private String getSeparador(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == 7 || (i - 7) % (23) == 0 || i == 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    /**
     *
     */
    public void print() {
        String sep = getSeparador(100);
        DecimalFormat df = new DecimalFormat("#,##0.00 '|'");
        DecimalFormat dfi = new DecimalFormat("#0 '|'");
        double sumCuota = 0.0;
        double sumCapital = 0.0;
        double sumInteres = 0.0;

        System.out.println(sep);
        System.out.print("|");
        System.out.printf("%1$7s %2$22s %3$22s %4$22s %5$22s\n", "No. |", "Cuota |", "Capital |", "Interes |", "Saldo |");
        System.out.println(sep);


        for (int i = 0; i < quotas.size(); i++) {
            double c[] = quotas.get(i);
            sumCuota += c[VALOR_QUOTA];
            sumCapital += c[PAGO_CAPITAL];
            sumInteres += c[PAGO_JUROS];
            System.out.print("|");
            System.out.printf("%1$7s %2$22s %3$22s %4$22s %5$22s\n", dfi.format(i + 1),
                    df.format(((int) (c[VALOR_QUOTA] * 100)) / 100.0),
                    df.format(((int) (c[PAGO_CAPITAL] * 100)) / 100.0),
                    df.format(((int) (c[PAGO_JUROS] * 100)) / 100.0),
                    df.format(((int) (c[SALDO] * 100)) / 100.0));
        }
        System.out.println(sep);
        System.out.printf("%1$8s %2$22s %3$22s %4$22s %5$22s\n", "|Total |",
                df.format(sumCuota),
                df.format(sumCapital),
                df.format(sumInteres),
                "");

        System.out.println(getSeparador(77) + "\n");
    }
}
