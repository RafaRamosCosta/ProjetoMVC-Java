package fiap.view;

import javax.swing.JOptionPane;

import fiap.controller.ClienteController;

public class ClienteView {

	public static void main(String[] args) {
		String resp = "s", nomeCliente, placa;
		int opcao, idCliente;
		ClienteController cliContr = new ClienteController();
		while (resp.equalsIgnoreCase("s")) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha:\n(1) Inserir\n(2) Alterar\n(3)Excluir"));
				idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente: "));
				switch (opcao) {
				case 1:
					nomeCliente = JOptionPane.showInputDialog("Nome do cliente: ");
					placa = JOptionPane.showInputDialog("Placa do carro: ");
					System.out.println(cliContr.insereCliente(idCliente, nomeCliente, placa));
					JOptionPane.showMessageDialog(null, cliContr.listaCliente());
					break;
				case 2:
					nomeCliente = JOptionPane.showInputDialog("Nome do cliente: ");
					placa = JOptionPane.showInputDialog("Placa do carro: ");
					System.out.println(cliContr.alteraCliente(idCliente, nomeCliente, placa));
					JOptionPane.showMessageDialog(null, cliContr.listaCliente());
					break;
				case 3:
					System.out.println(cliContr.excluiCliente(idCliente));
					JOptionPane.showMessageDialog(null, cliContr.listaCliente());
					break;
				default:
					throw new Exception("Opção inválida!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			resp = JOptionPane.showInputDialog("Deseja continuar?(s/n)");
		}
		System.out.println("fim de programa...");
	}

}
