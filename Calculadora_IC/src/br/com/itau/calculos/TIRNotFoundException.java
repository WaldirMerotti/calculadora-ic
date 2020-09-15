package br.com.itau.calculos;

public class TIRNotFoundException extends RuntimeException {

    public TIRNotFoundException(String text) {
        super(text);
    }

    public TIRNotFoundException() {
        super("Tir no encontrada");
    }
}
