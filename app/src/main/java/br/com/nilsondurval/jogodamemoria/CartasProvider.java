package br.com.nilsondurval.jogodamemoria;

import java.util.ArrayList;
import java.util.List;

import br.com.nilsondurval.jogodamemoria.modelo.Carta;

public class CartasProvider {

    private static List<Carta> cartas;

    static {
        cartas = new ArrayList<>();
        Carta carta = new Carta();

        carta.setId(1);
        carta.setDescricao("img1.png");
        carta.setDrawable(R.drawable.img1);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(2);
        carta.setDescricao("img1.png");
        carta.setDrawable(R.drawable.img1);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(3);
        carta.setDescricao("img2.png");
        carta.setDrawable(R.drawable.img2);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(4);
        carta.setDescricao("img2.png");
        carta.setDrawable(R.drawable.img2);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(5);
        carta.setDescricao("img3.png");
        carta.setDrawable(R.drawable.img3);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(6);
        carta.setDescricao("img3.png");
        carta.setDrawable(R.drawable.img3);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(7);
        carta.setDescricao("img4.png");
        carta.setDrawable(R.drawable.img4);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(8);
        carta.setDescricao("img4.png");
        carta.setDrawable(R.drawable.img4);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(9);
        carta.setDescricao("img5.png");
        carta.setDrawable(R.drawable.img5);

        cartas.add(carta);
        carta = new Carta();


        carta.setId(10);
        carta.setDescricao("img5.png");
        carta.setDrawable(R.drawable.img5);

        cartas.add(carta);
        carta = new Carta();

        carta.setId(11);
        carta.setDescricao("coringa.png");
        carta.setDrawable(R.drawable.coringa);

        carta.setId(12);
        cartas.add(carta);
        carta = new Carta();

        carta.setDescricao("coringa.png");
        carta.setDrawable(R.drawable.coringa);

        cartas.add(carta);
    }

    public static List<Carta> getCartas() {
        return cartas;
    }
}
