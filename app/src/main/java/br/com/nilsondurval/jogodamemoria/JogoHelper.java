package br.com.nilsondurval.jogodamemoria;


import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class JogoHelper {

    private ImageView carta0;
    private ImageView carta1;
    private ImageView carta2;
    private ImageView carta3;
    private ImageView carta4;
    private ImageView carta5;
    private ImageView carta6;
    private ImageView carta7;
    private ImageView carta8;
    private ImageView carta9;
    private ImageView carta10;
    private ImageView carta11;

    public JogoHelper(JogoActivity jogoActivity) {
        carta0 = jogoActivity.findViewById(R.id.carta0);
        carta1 = jogoActivity.findViewById(R.id.carta1);
        carta2 = jogoActivity.findViewById(R.id.carta2);
        carta3 = jogoActivity.findViewById(R.id.carta3);
        carta4 = jogoActivity.findViewById(R.id.carta4);
        carta5 = jogoActivity.findViewById(R.id.carta5);
        carta6 = jogoActivity.findViewById(R.id.carta6);
        carta7 = jogoActivity.findViewById(R.id.carta7);
        carta8 = jogoActivity.findViewById(R.id.carta8);
        carta9 = jogoActivity.findViewById(R.id.carta9);
        carta10 = jogoActivity.findViewById(R.id.carta10);
        carta11 = jogoActivity.findViewById(R.id.carta11);
    }

    public List<ImageView> getCartasView() {
        List<ImageView> cartas = new ArrayList<>();

        cartas.add(carta0);
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        cartas.add(carta6);
        cartas.add(carta7);
        cartas.add(carta8);
        cartas.add(carta9);
        cartas.add(carta10);
        cartas.add(carta11);

        return cartas;
    }

    public int transformaIdEmIndice(ImageView carta) {
        if (carta.getId() == R.id.carta0) {
            return 0;
        } else if (carta.getId() == R.id.carta1) {
            return 1;
        } else if (carta.getId() == R.id.carta2) {
            return 2;
        } else if (carta.getId() == R.id.carta3) {
            return 3;
        } else if (carta.getId() == R.id.carta4) {
            return 4;
        } else if (carta.getId() == R.id.carta5) {
            return 5;
        } else if (carta.getId() == R.id.carta6) {
            return 6;
        } else if (carta.getId() == R.id.carta7) {
            return 7;
        } else if (carta.getId() == R.id.carta8) {
            return 8;
        } else if (carta.getId() == R.id.carta9) {
            return 9;
        } else if (carta.getId() == R.id.carta10) {
            return 10;
        } else if (carta.getId() == R.id.carta11) {
            return 11;
        }

        return -1;
    }
}
