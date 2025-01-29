package br.com.pratica.consultaapigithub;

public class ResultadoRequisicao {
    String mensagemResultado;
    boolean resultado;
    String jsonResultado;

    public String getMensagemResultado() {
        return mensagemResultado;
    }

    public boolean isResultado() {
        return resultado;
    }

    public String getJsonResultado() {
        return jsonResultado;
    }

    public ResultadoRequisicao(String mensagemResultado, boolean resultado, String jsonResultado) {
        this.mensagemResultado = mensagemResultado;
        this.resultado = resultado;
        this.jsonResultado =jsonResultado;
    }

    @Override
    public String toString() {
        return mensagemResultado + "\n" +
                resultado + "\n" +
                jsonResultado;
    }
}
