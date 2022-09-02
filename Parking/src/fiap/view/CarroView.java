package fiap.view;

import javax.swing.JOptionPane;
import fiap.controller.CarroController;

public class CarroView {

	public static void main(String[] args) {
		String resp = "s", placa, cor, descricao;
		int opcao;
		CarroController carContr = new CarroController();
		while (resp.equalsIgnoreCase("s")) {
			try {
				opcao = Integer
						.parseInt(JOptionPane.showInputDialog("Escolha:\n(1) Inserir\n(2) Alterar\n(3) Excluir"));
				placa = JOptionPane.showInputDialog("Placa do Carro: ");
				switch (opcao) {
				case 1:
					cor = JOptionPane.showInputDialog("Cor do Carro: ");
					descricao = JOptionPane.showInputDialog("Descrição do Carro: ");
					System.out.println(carContr.insereCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, carContr.listaCarro());
					break;
				case 2:
					cor = JOptionPane.showInputDialog("Cor do Carro: ");
					descricao = JOptionPane.showInputDialog("Descrição do Carro: ");
					System.out.println(carContr.alteraCarro(placa, cor, descricao));
					JOptionPane.showMessageDialog(null, carContr.listaCarro());
					break;
				case 3:
					System.out.println(carContr.excluiCarro(placa));
					JOptionPane.showMessageDialog(null, carContr.listaCarro());
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
