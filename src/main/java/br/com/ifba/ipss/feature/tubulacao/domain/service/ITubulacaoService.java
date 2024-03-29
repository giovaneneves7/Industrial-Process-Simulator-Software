package br.com.ifba.ipss.feature.tubulacao.domain.service;

import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import java.util.List;

/**
 *
 * @author Giovane Neves
 */
public interface ITubulacaoService {
    
    List<Tubulacao> pegarTubulacoes();
    String pegarDiametroInterno(String nomeTubulacao);
    String pegarComprimento(String nomeTubulacao);
}
