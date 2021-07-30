import java.util.Scanner;
import java.util.Vector;

public class funcoes {

	public static Vector<Clientes> todosClientes = new Vector<Clientes>();
	public static Vector<Produtos> todosProdutos = new Vector<Produtos>();
	private static final Scanner ler = new Scanner(System.in);
	//funcao para ler input de numeros inteiros.
	public static int lerInt() {
		int inteiro;
		while (true) {
			try {
				inteiro = ler.nextInt();
				ler.nextLine();
				return inteiro;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("Numero invalido! Tente novamente.");
				ler.nextLine();
			}
		}
	}
	//funcao para ler input de numeros decimais
	private static Double lerDouble() {
		Double dble;
		while (true) {
			try {
				dble = ler.nextDouble();
				ler.nextLine();
				return dble;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("Numero invalido! Tente novamente.");
				ler.nextLine();
			}
		}
	}
	//Cadastra um novo cliente.
	public void cadastroCliente() {
		System.out.println("Quantos clientes deseja cadastrar?");
		int clientesACadastrar = lerInt();
		String nome, endereco, telefone;
		if(clientesACadastrar == 0) return;
			
		for(int i = 0; i < clientesACadastrar; i++) {
			Clientes cliente = new Clientes();
			System.out.printf("Cliente %d:\n", i + 1);
			
			System.out.printf("NOME: \n");
			nome = ler.nextLine();
			cliente.setNome(nome);
			
			System.out.printf("ENDEREÇO: \n");
			endereco = ler.nextLine();
			cliente.setEnd(endereco);
			
			System.out.printf("TELEFONE: \n");
			telefone = ler.nextLine();
			cliente.setTel(telefone);
			todosClientes.add(cliente);
		}
	}
	//mostra as informaçoes de todos os clientes.
	public void mostraTabelaClientes() {
		
		for(int i=0;i<todosClientes.size();i++) {
			Clientes pessoa = (Clientes) todosClientes.get(i);
			System.out.println(pessoa.getNome() + "\t" + pessoa.getEnd() + "\t" + pessoa.getTel());
		}
	}
	//mostra o nome e a quantidade de todos os produtos.
	public void mostraTabelaProdutos() {
		
		for(int i=0;i<todosProdutos.size();i++) {
			Produtos prod = (Produtos) todosProdutos.get(i);
			System.out.printf("%d." + prod.getNomeProd() + "(Quantidade:" + prod.getEstoque() + ")\n", i + 1);
		}
		System.out.println("Aperte 'ENTER' para voltar ao Menu.");
		ler.nextLine();
	}
	//funcao para cadastrar os produtos.
	public void cadastroProduto() {
		System.out.println("Quantos produtos deseja cadastrar?");
		int produtosACadastrar = lerInt();
		String nomeProd, descricao;
		double valor, lucro;
		int estoque;
		if(produtosACadastrar == 0) return;
			
		for(int i = 0; i < produtosACadastrar; i++) {
			Produtos produto = new Produtos();
			System.out.printf("Produto %d:\n", i + 1);
			
			System.out.printf("NOME: \n");
			nomeProd = ler.nextLine();
			produto.setNomeProd(nomeProd);
			
			System.out.printf("DESCRIÇÃO: \n");
			descricao = ler.nextLine();
			produto.setDesc(descricao);
			
			System.out.printf("VALOR DE COMPRA: \n");
			valor = lerDouble();
			produto.setValor(valor);
			
			System.out.printf("PORCENTAGEM DE LUCRO: \n");
			lucro = lerDouble();
			produto.setLucro(lucro);
			
			System.out.printf("QUANTIDADE EM ESTOQUE: \n");
			estoque = lerInt();
			produto.setEstoque(estoque);
			
			todosProdutos.add(produto);
		}
	}
	//funcao para fazer a busca de clientes.
	public void pesquisaCliente() {
		String pesquisa, sn, novoNome, novoEnd, novoTel;
		int y=0, index = -1;
		System.out.println("Digite o nome do cliente que deseja pesquisar: ");
		boolean n;
		do {
			n=true;
			pesquisa = ler.nextLine();
			for(int i = 0;i < todosClientes.size();i++) {
				Clientes pessoa = (Clientes) todosClientes.get(i);
				if (pesquisa.equals(pessoa.getNome())) {
					n = false;
					y = i;
				}	
			}
			if(n==true) {
				System.out.println("Cliente não encontrado! Tente novamente.");
			}
		}while(n==true);
			Clientes pessoa = (Clientes) todosClientes.get(y);
			index = todosClientes.indexOf(pessoa);
			System.out.println("Nome: " + pessoa.getNome() + "\n" + "Endereço: " + pessoa.getEnd() + "\n" + "Telefone: " + pessoa.getTel());
			System.out.println("Deseja alterar os dados do cliente? (s/n)");
			sn = ler.nextLine();
			if(sn.equals("s")) {
				System.out.println("Digite o novo nome do cliente: ");
				novoNome = ler.nextLine();
				pessoa.setNome(novoNome);
				System.out.println("Digite o novo endereço do cliente: ");
				novoEnd = ler.nextLine();
				pessoa.setEnd(novoEnd);
				System.out.println("Digite o novo telefone do cliente: ");
				novoTel = ler.nextLine();
				pessoa.setTel(novoTel);
				todosClientes.set(index, pessoa);
				System.out.println("Cliente editado com sucesso! Pressione 'ENTER' para retornar ao Menu.");
				ler.nextLine();
			}else {
			return;
			}
		}
	//funcao para fazer a busca de produtos.
	public void pesquisaProduto() {
		String pesquisa, sn, novoNomeProd, novoDesc;
		int novoEstoque;
		double novoValor, novoLucro;
		int index = -1, y=0;
		System.out.println("Digite o nome do produto que deseja pesquisar: ");
		boolean n;
		do {
			n=true;
			pesquisa = ler.nextLine();
			for(int i = 0;i < todosProdutos.size();i++) {
				Produtos item = (Produtos) todosProdutos.get(i);
				if (pesquisa.equals(item.getNomeProd())) {
					n = false;
					y = i;
				}
			}
			if(n==true) {
				System.out.println("Produto não encontrado! Tente novamente.");
			}
		}while(n==true);
			Produtos item = (Produtos) todosProdutos.get(y);
			index = todosProdutos.indexOf(item);
			System.out.println("Nome: " + item.getNomeProd() + "\nDescrição: " + item.getDesc() + "\nValor: " + item.getValor() + "\nLucro: " + item.getLucro() + "\nEstoque: " + item.getEstoque());
			System.out.println("Deseja alterar os dados do produto? (s/n)");
			sn = ler.nextLine();
			if(sn.equals("s")) {
				System.out.println("Digite o novo nome do produto: ");
				novoNomeProd = ler.nextLine();
				item.setNomeProd(novoNomeProd);
				System.out.println("Digite a nova descrição do produto: ");
				novoDesc = ler.nextLine();
				item.setDesc(novoDesc);
				System.out.println("Digite o novo valor do produto: ");
				novoValor = lerDouble();
				item.setValor(novoValor);
				System.out.println("Digite a nova porcentagem de lucro do produto: ");
				novoLucro = lerDouble();
				item.setLucro(novoLucro);
				System.out.println("Digite o novo estoque do produto: ");
				novoEstoque = lerInt();
				item.setEstoque(novoEstoque);
				todosProdutos.set(index, item);
				System.out.println("Produto editado com sucesso! Pressione 'ENTER' para retornar ao Menu.");
				ler.nextLine();
			}
		}	
	//funcao para fazer as vendas
	public void CadastroVendas() {
		int escolhaC, escolhaP = -1, vendasP, estoqueAntigo, estoqueNovo;
		boolean n;
		System.out.println("Selecione o cliente (digite o numero): \n");
		for (int i = 0; i < todosClientes.size(); i++) {
			Clientes pessoa = (Clientes) todosClientes.get(i);
			System.out.printf("%d." + pessoa.getNome() + "\n", i + 1);
		}
		do {
			n=false;
			escolhaC = lerInt();
			if(escolhaC > todosClientes.size() + 1 || escolhaC < 1) {
				n=true;
				System.out.println("Numero invalido! Tente novamente.");
			}
		}while(n==true);
		
		do {
			System.out.println("Selecione o produto ou volte ao menu (digite o numero): \n");
			for (int i = 0; i < todosProdutos.size(); i++) {
				Produtos itens = (Produtos) todosProdutos.get(i);
				System.out.printf("%d." + itens.getNomeProd() + " - " + itens.getEstoque() + "\n", i + 1);
			}
			System.out.printf("%d.MENU\n", todosProdutos.size() + 1);
			do {
				n=false;
				escolhaP = lerInt();
				if(escolhaP > todosProdutos.size() + 2 || escolhaP < 1) {
					n=true;
					System.out.println("Numero invalido! Tente novamente.");
				}
			}while(n==true);
			if (escolhaP == (todosProdutos.size() + 1)) {
				return;
			} else {
				Produtos venda = (Produtos) todosProdutos.get(escolhaP - 1);
				System.out.println("Quantos produtos foram vendidos para o cliente? \n");
				estoqueAntigo = venda.getEstoque();
				do {
					n=true;
					vendasP = lerInt();
					if(vendasP > estoqueAntigo) {
						n=false;
						System.out.println("A quantidade inserida é maior do que o estoque atual! Tente novamente.");
					}
				}while (n==false);
				estoqueNovo = estoqueAntigo - vendasP;
				venda.setEstoque(estoqueNovo);
			}
		}while(escolhaP != todosProdutos.size() + 1);
	}
	//funcao para carregar os 10 dados dos clientes.
	public void carregarDadosClientes(String nome, String end, String tel) {
			Clientes dadoCliente = new Clientes();
			dadoCliente.setNome(nome);
			dadoCliente.setEnd(end);
			dadoCliente.setTel(tel);
			
			todosClientes.add(dadoCliente);
	}
	//funcao com os 10 dados dos clientes para serem carregados.
	public void DadosClientes() {
		carregarDadosClientes("Tiago","Casa do Tiago","991789307");
		carregarDadosClientes("Lucas","Casa do Lucas","993297886");
		carregarDadosClientes("Leticia","Casa da Leticia","991118701");
		carregarDadosClientes("Lucia","Casa da Lucia","997048284");
		carregarDadosClientes("Marcio","Casa do Marcio","992212204");
		carregarDadosClientes("Guilherme","Casa do Guilherme","996217878");
		carregarDadosClientes("Rafael","Casa do Rafael","994812227");
		carregarDadosClientes("Antonio","Casa do Antonio","993297886");
		carregarDadosClientes("Ester","Casa da Ester","997392511");
		carregarDadosClientes("Julia","Casa da Julia","990944270");
	}
	//funcao para carregar os 10 dados dos produtos.
	public void carregarDadosProdutos(String nomeProd, String desc, double valor, double lucro, int Estoque) {
		Produtos dadoProduto = new Produtos();
		dadoProduto.setNomeProd(nomeProd);
		dadoProduto.setDesc(desc);
		dadoProduto.setValor(valor);
		dadoProduto.setLucro(lucro);
		dadoProduto.setEstoque(Estoque);
		
		todosProdutos.add(dadoProduto);
	}
	//funcao com os 10 dados do produtos para serem carregados.
	public void dadosProdutos() {
		carregarDadosProdutos("Água","Bebida",2,20,10);
		carregarDadosProdutos("Suco de Laranja","Bebida",5,25,20);
		carregarDadosProdutos("Suco de Uva","Bebida",5,25,20);
		carregarDadosProdutos("Biscoito Recheado","Lanche",3,30,35);
		carregarDadosProdutos("Desodorante","Cosmético",10,30,25);
		carregarDadosProdutos("Batom","Cosmético",15,20,5);
		carregarDadosProdutos("Bola","Brinquedo",40,10,10);
		carregarDadosProdutos("Urso de Pelucia","Brinquedo",50,30,10);
		carregarDadosProdutos("Maçã","Alimento",5,15,10);
		carregarDadosProdutos("Banana","Alimento",5,15,15);
	}			
}
