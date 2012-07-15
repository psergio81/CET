package br.com.cet.dao;



public class Atualiza extends BaseAtualiza {


	private static final String NOME_BANCO = "ensaio";
	
	public static void main(String[] args) {
		
		Atualiza atualiza = new Atualiza();
		
		atualiza.a0001(true);
		
		
	}

	
	/**
	 * Criar tabela empresa e campos
	 */
	private void a0001(boolean rodar){

		if(!rodar){
			return;
		}
		
		String nomeTabela = "empresa";

		criarTabela(NOME_BANCO, nomeTabela);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "cd_empresa", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_empresa", 100, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "nm_fantasia_empresa", 50, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "cep", 10, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "endereco", 100, false);
		criarCampo(TipoCampo.INTEIRO, NOME_BANCO, nomeTabela, "numero", 0, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "complemento", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "bairro", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "cidade", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "estado", 30, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "telefone", 20, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "fax", 20, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "website", 40, false);
		criarCampo(TipoCampo.VARCHAR, NOME_BANCO, nomeTabela, "email", 40, false);

	}
}
