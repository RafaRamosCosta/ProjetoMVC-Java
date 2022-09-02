package fiap.controller;
import java.sql.*;

import fiap.model.Carro;
import fiap.model.CarroDAO;
import fiap.model.Conexao;
public class CarroController {
	
	public String insereCarro(String placa, String cor, String descricao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro car = new Carro();
		car.setPlaca(placa);
		car.setCor(cor);
		car.setDescricao(descricao);
		resultado = cd.inserir(car);
		Conexao.fecharConexao(con);
		return resultado;
	}
	public String alteraCarro(String placa, String cor, String descricao) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro car = new Carro();
		car.setPlaca(placa);
		car.setCor(cor);
		car.setDescricao(descricao);
		resultado = cd.alterar(car);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String excluiCarro(String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		Carro car = new Carro();
		car.setPlaca(placa);
		resultado = cd.excluir(car);
		Conexao.fecharConexao(con);
		if(resultado != null) {
			return resultado;
		}else {
			return null;
		}
	}
	
	public String listaCarro() {
		String resultado = "";
		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);
		resultado = cd.listarTodos();
		Conexao.fecharConexao(con);
		return resultado;
	}
}
