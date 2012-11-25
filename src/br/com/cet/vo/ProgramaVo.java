package br.com.cet.vo;

public class ProgramaVo extends EstruturaVo{
	
	private String codigoPrograma;
	private String descricao;
	private String descricaoMenu;
	private String descricaoAction;

	public ProgramaVo(){}
	
	public ProgramaVo(String codigoPrograma){
		this.codigoPrograma = codigoPrograma;
	}
	
	public String getCodigoPrograma() {
		return codigoPrograma;
	}
	
	public void setCodigoPrograma(String codigoPrograma) {
		this.codigoPrograma = codigoPrograma;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoMenu() {
		return descricaoMenu;
	}

	public void setDescricaoMenu(String descricaoMenu) {
		this.descricaoMenu = descricaoMenu;
	}

	public String getDescricaoAction() {
		return descricaoAction;
	}

	public void setDescricaoAction(String descricaoAction) {
		this.descricaoAction = descricaoAction;
	}
		
}
