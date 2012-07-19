package br.com.cet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cet.util.UtConverte;
import br.com.cet.vo.EmpresaVo;

public class EmpresaDao extends BaseDao {
	
	
	public int getProximoCodigo(){
		
		return getProximoCodigo("empresa", "cd_empresa");
		
	}
	
	
	public EmpresaVo getEmpresaPeloCodigo(EmpresaVo empresaVo){
		return getEmpresa(empresaVo, 1);
	}
	
	private EmpresaVo getEmpresa(EmpresaVo empresaVo, int criterio){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(	"SELECT rowid, cd_empresa, nm_empresa, nm_fantasia_empresa, cep, endereco, numero, complemento, ");
		    qry.append(	"bairro, cidade, estado, telefone, fax, website, email FROM empresa " );
		    qry.append(	"where cd_empresa = ? " );
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setInt(i++, Integer.parseInt(empresaVo.getCodigoEmpresa()));
		    
		    rs = ps.executeQuery();  
		    
		    empresaVo = null;
		    
		    if (rs.next()) {  
		    	empresaVo = new EmpresaVo();
		    	
		    	empresaVo.setRowid(rs.getString("rowid"));
		    	empresaVo.setCodigoEmpresa(rs.getString("cd_empresa"));
		    	empresaVo.setRazaoSocial(rs.getString("nm_empresa"));
		    	empresaVo.setNomeFantasia(rs.getString("nm_fantasia_empresa"));
		    	empresaVo.setCep(rs.getString("cep"));
		    	empresaVo.setEndereco(rs.getString("endereco"));
		    	empresaVo.setNumero(String.valueOf(rs.getInt("numero")));
		    	empresaVo.setComplemento(rs.getString("complemento"));
		    	empresaVo.setBairro(rs.getString("bairro"));
		    	empresaVo.setCidade(rs.getString("cidade"));
		    	empresaVo.setEstado(rs.getString("estado"));
		    	empresaVo.setTelefone(rs.getString("telefone"));
		    	empresaVo.setFax(rs.getString("fax"));
		    	empresaVo.setWebSite(rs.getString("website"));
		    	empresaVo.setEmail(rs.getString("email"));
		    	
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return empresaVo;
	}
	
	
	public List<EmpresaVo> getListaEmpresas(EmpresaVo empresaVo, boolean filtrar){
		
		Connection connection = null;
		ResultSet rs = null;  
	    PreparedStatement ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    List<EmpresaVo> empresasList = null;
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append("SELECT rowid, cd_empresa, nm_empresa FROM empresa ");
		
		    if(filtrar){
		    	qry.append(" WHERE nm_empresa like '%' ? '%' ");
		    }
		
		    
		    ps = connection.prepareStatement(qry.toString());
		    
		    if(filtrar){
		    	ps.setString(i++, empresaVo.getRazaoSocial());
		    }
		    
		    rs = ps.executeQuery();  
		  
		    empresasList = new ArrayList<EmpresaVo>();
		    
		    while (rs.next()) {  
		    	empresaVo = new EmpresaVo();
		    	empresaVo.setRowid(rs.getString("rowid"));
		    	empresaVo.setCodigoEmpresa(rs.getString("cd_empresa"));
		        empresaVo.setRazaoSocial(rs.getString("nm_empresa"));
		    	empresasList.add(empresaVo);
		    }  
		    
	    }catch (Exception e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps, rs);
	    } 
	    
	    return empresasList;
	}
	
	
	public void insertEmpresas(EmpresaVo empresaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" INSERT INTO empresa ");
		    qry.append(" ( rowid, ");
		    qry.append(" cd_empresa, ");
		    qry.append(" nm_empresa, ");
		    qry.append(" nm_fantasia_empresa, ");
		    qry.append(" cep, ");
		    qry.append(" endereco, ");
		    qry.append(" numero, ");
		    qry.append(" complemento, ");
		    qry.append(" bairro, ");
		    qry.append(" cidade, ");
		    qry.append(" estado, ");
		    qry.append(" telefone, ");
		    qry.append(" fax, ");
		    qry.append(" website, ");
		    qry.append(" email ) ");
		    qry.append(getValues(qry));
		    
		    ps = connection.prepareStatement(qry.toString());  
		    
		    ps.setString(i++, getNovaSimulacaoRowid());
		    ps.setInt(i++, UtConverte.stringToInteiro(empresaVo.getCodigoEmpresa()));
		    ps.setString(i++, empresaVo.getRazaoSocial());
		    ps.setString(i++, empresaVo.getNomeFantasia());
		    ps.setString(i++, empresaVo.getCep());
		    ps.setString(i++, empresaVo.getEndereco());
		    ps.setInt(i++, UtConverte.stringToInteiro(empresaVo.getNumero()));
		    ps.setString(i++, empresaVo.getComplemento());
		    ps.setString(i++, empresaVo.getBairro());
		    ps.setString(i++, empresaVo.getCidade());
		    ps.setString(i++, empresaVo.getEstado());
		    ps.setString(i++, empresaVo.getTelefone());
		    ps.setString(i++, empresaVo.getFax());
		    ps.setString(i++, empresaVo.getWebSite());
		    ps.setString(i++, empresaVo.getEmail());
		    
		    ps.executeUpdate();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    } 
	}

	public void updateEmpresas(EmpresaVo empresaVo) throws Exception{
		
		Connection connection = null;
		PreparedStatement  ps = null;  
		StringBuilder qry = new StringBuilder(); 
		int i = 1;
		
		try {  
			
			connection = getConnection();  
			
			qry.append(" UPDATE empresa set ");
			qry.append(" nm_empresa = ?, ");
			qry.append(" nm_fantasia_empresa = ?, ");
		    qry.append(" cep = ?, ");
		    qry.append(" endereco = ?, ");
		    qry.append(" numero = ?, ");
		    qry.append(" complemento = ?, ");
		    qry.append(" bairro = ?, ");
		    qry.append(" cidade = ?, ");
		    qry.append(" estado = ?, ");
		    qry.append(" telefone = ?, ");
		    qry.append(" fax = ?, ");
		    qry.append(" website = ?, ");
		    qry.append(" email = ? ");
			qry.append(" WHERE cd_empresa = ? ");
			
			ps = connection.prepareStatement(qry.toString());  
			ps.setString(i++, empresaVo.getRazaoSocial());
			ps.setString(i++, empresaVo.getNomeFantasia());
		    ps.setString(i++, empresaVo.getCep());
		    ps.setString(i++, empresaVo.getEndereco());
		    ps.setInt(i++, Integer.parseInt(empresaVo.getNumero()));
		    ps.setString(i++, empresaVo.getComplemento());
		    ps.setString(i++, empresaVo.getBairro());
		    ps.setString(i++, empresaVo.getCidade());
		    ps.setString(i++, empresaVo.getEstado());
		    ps.setString(i++, empresaVo.getTelefone());
		    ps.setString(i++, empresaVo.getFax());
		    ps.setString(i++, empresaVo.getWebSite());
		    ps.setString(i++, empresaVo.getEmail());
			ps.setInt(i++, Integer.parseInt(empresaVo.getCodigoEmpresa()));
			
			ps.execute();
			
		}catch (SQLException e) {  
			e.printStackTrace();
		}finally {
			releaseResouces(connection, ps); 
		} 
	}
	
	public void deleteEmpresa(EmpresaVo empresaVo) {

		Connection connection = null;
		PreparedStatement  ps = null;  
	    StringBuilder qry = new StringBuilder(); 
	    int i = 1;
	    
	    try {  
	    	
	    	connection = getConnection();  
	  
		    qry.append(" DELETE FROM empresa WHERE cd_empresa = ? ");
		    
		    ps = connection.prepareStatement(qry.toString());
		    ps.setInt(i++, UtConverte.stringToInteiro(empresaVo.getCodigoEmpresa()));
		    
			ps.execute();
		    
	    }catch (SQLException e) {  
	        e.printStackTrace();
	    }finally {
	    	releaseResouces(connection, ps); 
	    }
	}
	
}
