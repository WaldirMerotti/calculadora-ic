package br.com.itau.testesCalculadora;

import br.com.itau.calculos.Fluxos;
import br.com.itau.calculos.TIR;
import br.com.itau.emprestimos.Quotas;
import br.com.itau.emprestimos.Emprestimo;
import br.com.itau.emprestimos.TipoTaxa;

public class Main {

	public static void main(String[] args) {

//		 Fluxos fluxos = new Fluxos();
//		 fluxos.adicionarFluxos(3000, 3000, 2000, 4000, 4000, 7000);
//		 TIR.calcularTIR(fluxos, 18000);
//
//		Quotas c = Emprestimo.calcularCuotaNivelada(27000, 0.01, 12, TipoTasa.MENSUAL);
//		c.print();
//
//		 c = Emprestimo.calcularSaldoInsoluto(18000, 0.22, 24, TipoTasa.MENSUAL, 1);
//		 c.print();
//		 Fluxos f = c.getFlujos();
//		 f.restarAlFlujo(1, 450);
		
		int nroParcelas = 30;
		double valorParcela = 12.40;

		Fluxos f2 = new Fluxos();
		for (int i = 1; i <= nroParcelas; i++) {
			f2.adicionarFluxo(valorParcela);
		}

		System.out.println("TIR: " + TIR.calcularTIR(f2, 100));
//
//		 double tir = TIR.calcularTIR(f, 180000 - 450);
//		 System.out.println("TIR: " + tir);
//		 System.out.println("CAT: " + ( Math.pow(1+tir, 12) - 1 ));
//
//		 System.out.println(TIR.calcularTIR(fluxos, Double.parseDouble(args[0])));

	}

}
