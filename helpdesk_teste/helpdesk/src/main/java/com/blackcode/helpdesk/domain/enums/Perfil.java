package com.blackcode.helpdesk.domain.enums;

public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN"),
    CLIENTE(1, "ROLE_CLIENTE"),
    TECNICO(2, "ROLE_TECNICO");
	
	private Integer codido;
    private String descricao;

    private Perfil(Integer codido, String descricao) {
        this.codido = codido;
        this.descricao = descricao;
    }

    public Integer getCodido() {
        return codido;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCodido())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil inválido: " + cod);
    }

}
