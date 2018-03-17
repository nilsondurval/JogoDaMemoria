package br.com.nilsondurval.jogodamemoria.modelo;

import java.util.List;

public class Jogo {

    private List<Carta> cartas;
    private Carta carta1;
    private Carta carta2;

    private int somAtual;

    private EstadoJogo estadoAtual;

    public Jogo(List<Carta> cartas) {
        this.cartas = cartas;
        reiniciar();
    }

    public void reiniciar() {
        carta1 = null;
        carta2 = null;
        estadoAtual = EstadoJogo.EMJOGO;
        somAtual = -1;
        virarTodasCartasParaBaixo();
        Sorteio.embaralhar(cartas);
    }

    public void realizarJogada1(int indice) {
        if (carta1 == null) {
            carta1 = cartas.get(indice);
            carta1.virarParaCima();
        }
    }

    public void realizarJogada2(int indice) {
        if (carta1 != null && carta2 == null) {
            carta2 = cartas.get(indice);
            carta2.virarParaCima();
        }
    }

    public void verificarJogadas() {
        if (carta2 == null) {
            somAtual = -1;
            estadoAtual = EstadoJogo.EMJOGO;
        }

        if (carta1 != null && carta1.eCoringa()) {
            estadoAtual = EstadoJogo.PERDEU;
            somAtual = 2;
        }

        if (carta2 != null && carta2.eCoringa()) {
            estadoAtual = EstadoJogo.PERDEU;
            somAtual = 2;
        }

        if ((carta1 != null && carta2 != null) && (!carta1.eCoringa() && !carta2.eCoringa())) {
            if (carta1.getId() != carta2.getId() && carta1.getDrawable() == carta2.getDrawable()) {
                carta1.setStatusCarta(StatusCarta.FEZPAR);
                carta2.setStatusCarta(StatusCarta.FEZPAR);
                estadoAtual = EstadoJogo.EMJOGO;
                somAtual = 1;
            } else {
                carta1.virarParaBaixo();
                carta2.virarParaBaixo();
                estadoAtual = EstadoJogo.EMJOGO;
                somAtual = 0;
            }

            carta1 = null;
            carta2 = null;
        }

        if (venceu()) {
            estadoAtual = EstadoJogo.VENCEU;
        }
    }

    public boolean venceu() {
        int contPares = 0;
        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getStatusCarta() == StatusCarta.FEZPAR) {
                contPares++;
            }
        }

        if (contPares == 10)
            return true;
        else
            return false;
    }

    public boolean verificaCartaViradaParaCima() {
        for (Carta carta : cartas) {
            if (carta.getStatusCarta().equals(StatusCarta.VIRADAPARACIMA)) {
                return true;
            }
        }

        return false;
    }

    public void virarTodasCartasParaBaixo() {
        for (Carta carta : cartas) {
            carta.virarParaBaixo();
        }
    }

    public void virarTodasCartasParaCima() {
        for (Carta carta : cartas) {
            carta.virarParaCima();
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public int getSomAtual() {
        return somAtual;
    }

    public EstadoJogo getEstadoAtual() {
        return estadoAtual;
    }
}
