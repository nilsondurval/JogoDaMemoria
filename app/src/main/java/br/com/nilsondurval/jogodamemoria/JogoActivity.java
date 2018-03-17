package br.com.nilsondurval.jogodamemoria;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import br.com.nilsondurval.jogodamemoria.modelo.Carta;
import br.com.nilsondurval.jogodamemoria.modelo.EstadoJogo;
import br.com.nilsondurval.jogodamemoria.modelo.Jogo;
import br.com.nilsondurval.jogodamemoria.modelo.StatusCarta;

public class JogoActivity extends AppCompatActivity {

    private Jogo jogo;

    private JogoHelper helper;
    private List<ImageView> cartasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        List<Carta> cartas = CartasProvider.getCartas();

        helper = new JogoHelper(this);
        cartasView = helper.getCartasView();

        jogo = new Jogo(cartas);
        desenha();
    }

    public void virarCarta(View view) {
        if (jogo.getEstadoAtual() == EstadoJogo.EMJOGO) {
            int indice = helper.transformaIdEmIndice((ImageView) view);

            if (!jogo.verificaCartaViradaParaCima()) {
                jogo.realizarJogada1(indice);
                desenha();
                jogo.verificarJogadas();
                tocarSom();
                desenhaAtrasado();

            } else {
                jogo.realizarJogada2(indice);
                desenha();
                jogo.verificarJogadas();
                tocarSom();
                desenhaAtrasado();
            }
        }

        if (jogo.getEstadoAtual() == EstadoJogo.VENCEU) {
            jogo.virarTodasCartasParaCima();
            mostrarAlertaAtrasado("Você Vençeu!!", "Belo jogo. :)");
        }

        if (jogo.getEstadoAtual() == EstadoJogo.PERDEU) {
            jogo.virarTodasCartasParaCima();
            mostrarAlertaAtrasado("Você Perdeu!!", "Tente mais uma vez.");
        }
    }

    private void desenha() {
        for (int i = 0; i < jogo.getCartas().size(); i++) {
            if (jogo.getCartas().get(i).getStatusCarta().equals(StatusCarta.VIRADAPARACIMA) || jogo.getCartas().get(i).getStatusCarta().equals(StatusCarta.FEZPAR)) {
                cartasView.get(i).setImageResource(jogo.getCartas().get(i).getDrawable());
            } else {
                cartasView.get(i).setImageResource(R.drawable.carta_virada_para_baixo);
            }
        }
    }

    private void desenhaAtrasado() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                desenha();
            }
        }, 2000);
    }

    private void tocarSom() {
        MediaPlayer mp = new MediaPlayer();

        switch (jogo.getSomAtual()) {
            case 0:
                if (mp.isPlaying()) {
                    mp.stop();
                }
                mp = MediaPlayer.create(this, R.raw.som0);
                mp.start();
                break;
            case 1:
                if (mp.isPlaying()) {
                    mp.stop();
                }
                mp = MediaPlayer.create(this, R.raw.som1);
                mp.start();
                break;
            case 2:
                if (mp.isPlaying()) {
                    mp.stop();
                }
                mp = MediaPlayer.create(this, R.raw.som2);
                mp.start();
                break;
        }
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensagem)
                .setTitle(titulo);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void mostrarAlertaAtrasado(final String titulo, final String mensagem) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarAlerta(titulo, mensagem);
            }
        }, 1000);
    }

    public void reiniciar(View view) {
        jogo.reiniciar();
        desenha();
    }
}
