package br.com.ifba.ipss.feature.tubulacao.domain.service;

import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.ITubulacaoRepository;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.TubulacaoRepositoryImpl;
import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class TubulacaoServiceImpl implements ITubulacaoService{

    private final ITubulacaoRepository tubulacaoRepository = new TubulacaoRepositoryImpl();
    
    @Override
    public List<Tubulacao> pegarTubulacoes() {

        return tubulacaoRepository.pegarTubulacoes();

    }
    
}
