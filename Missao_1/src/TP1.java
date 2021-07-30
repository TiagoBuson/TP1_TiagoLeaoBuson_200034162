public class TP1 {
	static funcoes funcoes = new funcoes();
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int menu = 0;
		funcoes.dadosProdutos();
		funcoes.DadosClientes();
		//função while para mostrar o menu enquanto o usuario não Fecha o programa.
		while(menu != 7) {
			System.out.println("MENU:");
			System.out.println("1. Cadastro de novo cliente.");
			System.out.println("2. Busca por cliente.");
			System.out.println("3. Cadastro de novo produto.");
			System.out.println("4. Busca por produto.");
			System.out.println("5. Cadastro de venda.");
			System.out.println("6. Mostrar produtos em estoque.");
			System.out.println("7. Sair.");
			menu = funcoes.lerInt();
			//Usei um switch para escolha do Menu.
			switch (menu) {
				case 1:
					limpaTela();
					funcoes.cadastroCliente();
					break;
				case 2:
					limpaTela();
					funcoes.pesquisaCliente();
					break;
				case 3:
					limpaTela();
					funcoes.cadastroProduto();
					break;
				case 4:
					limpaTela();
					funcoes.pesquisaProduto();
					break;
				case 5:
					limpaTela();
					funcoes.CadastroVendas();
					break;
				case 6:
					limpaTela();
					funcoes.mostraTabelaProdutos();
					break;
				case 7:
					limpaTela();
					System.out.println("Tchau amigo! Obrigado por usar o meu programa!");
					break;
				default:
					limpaTela();
					System.out.println("Opção de Menu invalida! Tente novamente.\n");
			}
		}
	}
	//funcao de limpar a tela.
	public static void limpaTela() {
		for(int limp=1; limp<=25;limp++)
			System.out.println();
	}

}
