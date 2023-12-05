package com.fob.services.impl;

import com.fob.entities.Cabecalho;
import com.fob.entities.Emitente;
import com.fob.entities.NFe;
import com.fob.entities.Produto;
import com.fob.services.exceptions.NFeNotFoundException;
import com.fob.services.interfaces.NFeService;
import jakarta.enterprise.context.ApplicationScoped;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.util.Objects.isNull;

@ApplicationScoped
public class NFeRSServiceImpl implements NFeService {

    @Override
    public NFe consult(String chave){

        try{
            String url = "https://www.sefaz.rs.gov.br/ASP/AAE_ROOT/NFE/SAT-WEB-NFE-COM_2.asp?HML=false&chaveNFe=" + chave;

            Document doc = Jsoup.connect(url).get();

            Element naoEncontrada = doc.selectFirst("td:contains(NF-e não encontrada!)");
            if(!isNull(naoEncontrada)) {
                throw new NFeNotFoundException("NF-e não encontrada!");
            }

            Element dataNfe = doc.getElementById("NFe");
            Element dataEmitente = doc.getElementById("Emitente");
            Elements cobranca = doc.select("#Cobranca [class^=toggle] td:eq(1) span");

            //Cabeçalho
            String meioDePagamento = cobranca.text().split("- ")[1];
            String cpfCliente = dataNfe.selectFirst("label:contains(CPF) + span").text();
            String modelo = dataNfe.selectFirst("label:contains(Modelo) + span").text();
            String serie = dataNfe.selectFirst("label:contains(Série) + span").text();
            String numero = dataNfe.selectFirst("label:contains(Número) + span").text();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ssXXX");
            Date dataEmissao = sdf.parse(dataNfe.selectFirst("label:contains(Data de Emissão) + span").text());
            String hasDataSaidaEntrada = dataNfe.selectFirst("label:contains(Data Saída/Entrada) + span").text();
            Date dataSaidaEntrada = !hasDataSaidaEntrada.isEmpty() ? sdf.parse(hasDataSaidaEntrada) : null;

            Double total = Double.parseDouble(dataNfe.selectFirst("label:contains(Valor) + span").text().replace(",", "."));

            Cabecalho cabecalho = new Cabecalho(modelo, serie, numero, dataEmissao, dataSaidaEntrada, total, cpfCliente, meioDePagamento);

            //Emitente
            String nomeEmitente = dataEmitente.selectFirst("label:contains(Nome Fantasia) + span").text();
            String razaoSocial = dataEmitente.selectFirst("label:contains(Razão Social) + span").text();
            String cnpj = dataEmitente.selectFirst("label:contains(CNPJ) + span").text();
            String rua = String.valueOf(Jsoup.parse(dataEmitente.selectFirst("label:contains(Endereço) + span").text()).text()).split(",")[0];
            String bairro = dataEmitente.selectFirst("label:contains(Bairro) + span").text();
            String numeroEmitente = String.valueOf(Jsoup.parse(dataEmitente.selectFirst("label:contains(Endereço) + span").text()).text()).split(",")[1];
            String cep = dataEmitente.selectFirst("label:contains(CEP) + span").text();
            String cidade = dataEmitente.selectFirst("label:contains(Município) + span").text().split(" - ")[1];
            String ibge = dataEmitente.selectFirst("label:contains(Município) + span").text().split(" - ")[0];
            String telefone = dataEmitente.selectFirst("label:contains(Telefone) + span").text();
            String estado = dataEmitente.selectFirst("label:contains(UF) + span").text();

            Emitente emitente = new Emitente(nomeEmitente, razaoSocial, cnpj, rua, bairro, numeroEmitente, cep, cidade, ibge, telefone, estado);

            //Produtos
            Elements produtosE = doc.select("#Prod table[class^=togg]");
            ArrayList<Produto> produtos = new ArrayList<>();

            for (int i = 0; i < produtosE.size(); i += 2) {
                Element dadosProduto = produtosE.get(i);
                Element dadosProdutoFiscal = produtosE.get(i + 1);

                String codigo = dadosProdutoFiscal.selectFirst("table > tbody > tr >  td [colspan=4] > span").text();
                String NCM = dadosProdutoFiscal.selectFirst("table > tbody > tr > td [colspan=2] > span").text();
                String eanComercial = dadosProdutoFiscal.selectFirst("table > tbody> tr > td [colspan=4] > label:contains(EAN) + span").text();

                String id = dadosProduto.selectFirst(".fixo-prod-serv-numero").text();
                String descricao = dadosProduto.selectFirst(".fixo-prod-serv-descricao").text();
                Double quantidade = Double.parseDouble(dadosProduto.selectFirst(".fixo-prod-serv-qtd").text().replace(",", "."));
                String unidade = dadosProduto.selectFirst(".fixo-prod-serv-uc").text();
                Double preco = Double.parseDouble(dadosProduto.selectFirst(".fixo-prod-serv-vb").text().replace(",", "."));


                Produto p = new Produto(id, codigo, descricao, unidade, quantidade, preco, NCM, eanComercial);
                produtos.add(p);
            }

            return new NFe(cabecalho, emitente, produtos);

        }catch (Exception e){
            System.out.println(e.toString());
        }

        return null;

    }   
}
