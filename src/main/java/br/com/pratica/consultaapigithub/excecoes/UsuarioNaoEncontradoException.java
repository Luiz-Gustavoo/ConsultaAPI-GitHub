package br.com.pratica.consultaapigithub.excecoes;

public class UsuarioNaoEncontradoException extends RuntimeException {

    private String mensagem;

    @Override
    public String getMessage() {
        return this.mensagem;
    }

    public UsuarioNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }
}
