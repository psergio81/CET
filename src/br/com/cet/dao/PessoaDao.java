package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.util.UtString;
import br.com.cet.vo.PessoaVo;

public class PessoaDao extends BaseDao {
	
	private static final int QUANTIDADE_ZEROS_CODIGO = 8;

	public int getProximoCodigo(String codigoEmpresa){
		
		return getProximoCodigo(codigoEmpresa, "pessoa", "cd_pessoa");
		
	}
	
	public PessoaVo getPessoaPeloCodigo(PessoaVo pessoaVo){
		return getPessoa(pessoaVo,1);
	}

	private PessoaVo getPessoa(PessoaVo pessoaVo, int criterio) {

		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {
	    	
	    	connection = getConnection();  
	  	  
		    qry.append(	"SELECT rowid, cd_pessoa, nm_pessoa, tipo_pessoa, cd_documento FROM pessoa " );
		    qry.append(	"where cd_pessoa = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    ps.setInt(i++, Integer.parseInt(pessoaVo.getCodigoPessoa()));
		    
		    rs = ps.executeQuery();  
		    
		    pessoaVo = null;
	    	
		    if (rs.next()) {  
		    	pessoaVo = new PessoaVo();
		    	
		    	pessoaVo.setRowid(rs.getString("rowid"));
		    	pessoaVo.setCodigoPessoa(UtString.formataNumeroZeroEsquerda(QUANTIDADE_ZEROS_CODIGO, rs.getInt("cd_pessoa")));
		    	pessoaVo.setNome(rs.getString("nm_pessoa"));
		    	pessoaVo.setTipoPessoa(rs.getString("tipo_pessoa"));
		    	pessoaVo.setCodigoDocumento(rs.getString("cd_documento"));
		    	
		    }
		    
		}catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
		return pessoaVo;
	}
	
	public List<PessoaVo> getListaPessoas(PessoaVo pessoaVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<PessoaVo> pessoasList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_pessoa, nm_pessoa, tipo_pessoa, cd_documento FROM pessoa ");
		    qry.append(" WHERE cd_empresa = ? ");
		
		    if(filtrar){
		    	qry.append(" and nm_pessoa like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setString(i++, pessoaVo.getCodigoEmpresa());
		    
		    if(filtrar){
		    	ps.setString(i++, pessoaVo.getNome());
		    }
		    
		    rs = ps.executeQuery();  
		  
		    pessoasList = new ArrayList<PessoaVo>();
		    
		    while (rs.next()) {  
		    	pessoaVo = new PessoaVo();
		    	pessoaVo.setRowid(rs.getString("rowid"));
		    	pessoaVo.setCodigoPessoa(String.valueOf(rs.getInt("cd_pessoa")));
		    	pessoaVo.setNome(rs.getString("nm_pessoa"));
		    	pessoaVo.setTipoPessoa(String.valueOf(rs.getInt("tipo_pessoa")));
		    	pessoaVo.setCodigoDocumento(rs.getString("cd_documento"));
		    	pessoasList.add(pessoaVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return pessoasList;
	}
	
	public void insertPessoas(PessoaVo pessoaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO pessoa ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_pessoa, ");
		    qry.append(" cd_empresa, ");
		    qry.append(" nm_pessoa, ");
		    qry.append(" tipo_pessoa, ");
		    qry.append(" cd_documento )");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, Integer.parseInt(pessoaVo.getCodigoPessoa()));
		    ps.setInt(i++, Integer.parseInt(pessoaVo.getCodigoEmpresa()));
		    ps.setString(i++, pessoaVo.getNome());
		    ps.setInt(i++, UtConverte.stringToInteiro(pessoaVo.getTipoPessoa()));
		    ps.setString(i++, pessoaVo.getCodigoDocumento());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}
	
	public void updatePessoas(PessoaVo pessoaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE pessoa set ");
			qry.append(" nm_pessoa = ?, ");
			qry.append(" tipo_pessoa = ?, ");
			qry.append(" cd_documento = ? ");
			qry.append(" WHERE rowid = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, pessoaVo.getNome());
			ps.setInt(i++, UtConverte.stringToInteiro(pessoaVo.getTipoPessoa()));
			ps.setString(i++, pessoaVo.getCodigoDocumento());
			ps.setString(i++, pessoaVo.getRowid());
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deletePessoa(PessoaVo pessoaVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM pessoa WHERE cd_pessoa = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(pessoaVo.getCodigoPessoa()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
	public int getQuantidadePessoas(PessoaVo pessoaVo){
		List<PessoaVo> listaPessoas = this.getListaPessoas(pessoaVo, false);
		
		return listaPessoas.size();
	}
}
