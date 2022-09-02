package fiap.controller;

import java.sql.Connection;

import fiap.model.Cliente;
import fiap.model.ClienteDAO;
import fiap.model.Conexao;

public class ClienteController {
	public String insereCliente(int idCliente, String nomeCliente, String placa) {
		String result;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cliDAO = new ClienteDAO(con);
		Cliente cli = new Cliente();
		cli.setIdCliente(idCliente);
		cli.setNomeCliente(nomeCliente);
		cli.setPlaca(placa);
		result = cliDAO.inserir(cli);
		Conexao.fecharConexao(con);
		return result;
	}
	public String alteraCliente(int idCliente, String nomeCliente, String placa) {
		String result;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cliDAO = new ClienteDAO(con);
		Cliente cli = new Cliente();
		cli.setIdCliente(idCliente);
		cli.setNomeCliente(nomeCliente);
		cli.setPlaca(placa);
		result = cliDAO.alterar(cli);
		Conexao.fecharConexao(con);
		return result;
	}
	public String excluiCliente (int idCliente) {
		String result;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cliDAO = new ClienteDAO(con);
		Cliente cli = new Cliente();
		cli.setIdCliente(idCliente);
		result = cliDAO.excluir(cli);
		Conexao.fecharConexao(con);
		return result;
	}
	
	public String listaCliente() {
		String result = "";
		Connection con = Conexao.abrirConexao();
		ClienteDAO cliDAO = new ClienteDAO(con);
		result = cliDAO.listarTodos();
		Conexao.fecharConexao(con);
		return result;
	}
}
