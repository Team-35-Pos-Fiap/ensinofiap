package br.com.ensinofiap.exceptions;

public class CursoNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CursoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}