package br.com.nilsondurval.jogodamemoria.modelo;

public class Carta {

    private int id;
    private int drawable;
    private String descricao;
    private StatusCarta statusCarta;

    public boolean eCoringa() {
        if (descricao.equals("coringa.png")) {
            return true;
        }
        return false;
    }

    public void virarParaBaixo() {
        this.setStatusCarta(StatusCarta.VIRADAPARABAIXO);
    }

    public void virarParaCima() {
        this.setStatusCarta(StatusCarta.VIRADAPARACIMA);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusCarta getStatusCarta() {
        return statusCarta;
    }

    public void setStatusCarta(StatusCarta statusCarta) {
        this.statusCarta = statusCarta;
    }
}
