package br.com.joao.lojavirtual3.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.joao.lojavirtual3.dao.ProdutoDAO;
import br.com.joao.lojavirtual3.exception.NegocioException;
import br.com.joao.lojavirtual3.model.Produto;
import br.com.joao.lojavirtual3.util.service.ServiceAbstract;

public class ProdutoService  extends ServiceAbstract implements Serializable {

	private static final long serialVersionUID = -8316801243607929061L;

	private ProdutoDAO produtoDAO = new ProdutoDAO();

	public Produto inicializarObjeto() {
		Produto produto = new Produto();
		return produto;
	}
	
	public Produto buscarProdutoPorId(long produtoId) {
		return produtoDAO.buscarPorId(Produto.class, produtoId);
	}

	public void salvarPassandoProduto(Produto produto) throws Exception {
		try {
			getProdutoDAO().merge(produto);
 		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void deletarPassandoProduto(Produto produto) throws Exception {
		try {
			getProdutoDAO().delete(produto);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public List<Produto> listaDeTodasProdutos() throws Exception {
		try {
			return getProdutoDAO().selecioneTodos(Produto.class);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public int contarDiferencaEntreAsDatas(Date dataInicial, Date dataFinal) throws NegocioException {
		super.vibializaDataInicial(dataInicial);
		super.vibializaDataFinal(dataInicial, dataFinal);
		
		return 0;
	}
}
