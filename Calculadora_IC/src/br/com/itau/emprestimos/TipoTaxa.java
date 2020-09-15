/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itau.emprestimos;

public enum TipoTaxa {
    
    SEMANAL(52),
    QUINZENAL(24),
    MENSAL(12),
    BIMESTRAL(6),
    TRIMESTRAL(4),
    QUADRIMESTRAL(3),
    SEMESTRAL(2),
    ANUAL(1);
    
    private int valor;
    
    TipoTaxa(int val){
        this.valor = val;
    }
    
    public int valor(){
        return this.valor;
    }
}
