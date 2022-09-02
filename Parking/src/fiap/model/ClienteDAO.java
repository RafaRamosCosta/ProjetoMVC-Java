package fiap.model;

import java.sql.*;

public class ClienteDAO implements IDAO {
	private Connection con;
	private Cliente cli;

	public ClienteDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Object obj) {
		cli = (Cliente) obj;
		String sql = "insert into cliente(idCliente, nomeCliente, placa) values(?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cli.getIdCliente());
			ps.setString(2, cli.getNomeCliente());
			ps.setString(3, cli.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso!";
			} else {
				return "Erro ao inserir!";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Object obj) {
		cli = (Cliente) obj;
		String sql = "update cliente set nomeCliente = ? where idCliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cli.getNomeCliente());
			ps.setInt(2, cli.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso!";
			} else {
				return "Erro ao alterar!";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String excluir(Object obj) {
		cli = (Cliente) obj;
		String sql = "delete from cliente where idCliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cli.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Excluído com sucesso!";
			} else {
				return "Erro ao excluír!";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String listarTodos() {
		String listaCliente = "Lista de Clientes:\n\n";
		String sql = "select * from cliente";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCliente += "ID do Cliente: " + rs.getInt(1) + "\n";
					listaCliente += "Nome do Cliente: " + rs.getString(2) + "\n";
					listaCliente += "Placa do Carro: " + rs.getString(3) + "\n\n";
				}
				return listaCliente;
			} else {
				return "Lista vazia";
			}

		} catch (Exception e) {
			return e.getMessage();
		}

	}
}
