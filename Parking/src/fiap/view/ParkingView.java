package fiap.view;

import javax.swing.JOptionPane;

import fiap.controller.CarroController;
import fiap.controller.ClienteController;

public class ParkingView {

	public static void main(String[] args) {
		String resp = "s", placa, cor, descricao, nomeCliente;
		int escolha, idCliente;
		ClienteController cliCon = new ClienteController();
		CarroController carCon = new CarroController();
		while(resp.equalsIgnoreCase("s")) {
			try {
				escolha = Integer.parseInt(JOptionPane.showInputDialog("(1) Carro | (2) Cliente"));
				if(escolha == 1) {
					escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n(1) Cadastrar Carro\n(2) Alterar Carro\n(3)Excluír Carro"));
					switch (escolha) {
					case 1:
						placa = JOptionPane.showInputDialog("Placa do carro: ");
						cor = JOptionPane.showInputDialog("Cor do carro: ");
						descricao = JOptionPane.showInputDialog("Descrição do carro: ");
						carCon.insereCarro(placa, cor, descricao);
						JOptionPane.showMessageDialog(null, carCon.listaCarro());
						break;
					case 2:
						placa = JOptionPane.showInputDialog("Placa do carro: ");
						cor = JOptionPane.showInputDialog("Cor do carro: ");
						descricao = JOptionPane.showInputDialog("Descrição do carro: ");
						carCon.alteraCarro(cor, descricao, placa);
						JOptionPane.showMessageDialog(null, carCon.listaCarro());
						break;
					case 3:
						placa = JOptionPane.showInputDialog("Placa do carro: ");
						carCon.excluiCarro(placa);
						JOptionPane.showMessageDialog(null, carCon.listaCarro());
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção inválida!");
					}
				} else if (escolha == 2) {
					escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n(1) Cadastrar Cliente\n(2) Alterar Cliente\n(3)Excluír Cliente"));
					switch (escolha) {
					case 1:
						idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente: "));
						nomeCliente = JOptionPane.showInputDialog("Nome do cliente: ");
						placa = JOptionPane.showInputDialog("Placa do carro do cliente: ");
						cliCon.insereCliente(idCliente, nomeCliente, placa);
						JOptionPane.showMessageDialog(null, cliCon.listaCliente());
						break;
					case 2:
						idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente: "));
						nomeCliente = JOptionPane.showInputDialog("Nome do cliente: ");
						placa = JOptionPane.showInputDialog("Placa do carro do cliente: ");
						cliCon.alteraCliente(idCliente, nomeCliente, placa);
						JOptionPane.showMessageDialog(null, cliCon.listaCliente());
						break;
					case 3:
						idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente: "));
						cliCon.excluiCliente(idCliente);
						JOptionPane.showMessageDialog(null, cliCon.listaCliente());
						break;
					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			resp = JOptionPane.showInputDialog("Deseja continuar?(s/n)");
		}
		System.out.println("Finalizando programa...");
	}

}
