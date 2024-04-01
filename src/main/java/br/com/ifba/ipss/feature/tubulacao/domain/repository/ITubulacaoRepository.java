package br.com.ifba.ipss.feature.tubulacao.domain.repository;

import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.infrastructure.exception.generic.IGenericRepository;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public interface ITubulacaoRepository extends IGenericRepository<Tubulacao>{
        
    List<Tubulacao> pegarTubulacoes();
    String pegarDiametroInterno(String nomeTubulacao);
    double pegarComprimento(String nomeTubulacao);
    
}
