package br.com.nilsondurval.jogodamemoria.modelo;

import java.util.Collections;
import java.util.List;

public class Sorteio {

    public static void embaralhar(List<Carta> cartas) {
        Collections.shuffle(cartas);
    }
}
