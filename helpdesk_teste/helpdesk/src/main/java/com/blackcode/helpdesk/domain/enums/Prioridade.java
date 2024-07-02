package com.blackcode.helpdesk.domain.enums;

public enum Prioridade {
	
	BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");
	
	private final int codigo;
    private final String descricao;

    private Prioridade(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Prioridade prioridade : Prioridade.values()) {
            if (codigo.equals(prioridade.getCodigo())) {
                return prioridade;
            }
        }

        throw new IllegalArgumentException("Prioridade inválida: " + codigo);
    }

}
