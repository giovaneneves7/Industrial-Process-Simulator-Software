package br.com.ifba.ipss.feature.tubulacao.domain.service;

import static br.com.ifba.ipss.util.Dicionario.tr;

import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.ITubulacaoRepository;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.TubulacaoRepositoryImpl;
import br.com.ifba.ipss.helper.FormulaHelper;

import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class TubulacaoServiceImpl implements ITubulacaoService{

    private final ITubulacaoRepository tubulacaoRepository = new TubulacaoRepositoryImpl();
    
    @Override
    public List<Tubulacao> pegarEquipamentos() {

        return tubulacaoRepository.pegarListaEquipamentos("tubulacoes"); 
        
    }

    @Override
    public String pegarDiametroInterno(String nomeTubulacao) {
        
        return tr("di").concat("=").concat(tubulacaoRepository.pegarDiametroInterno(nomeTubulacao).concat(FormulaHelper.PES));
        
    }

    @Override
    public String pegarComprimento(String nomeTubulacao) {
        
        return tr("l").concat("=").concat(String.valueOf(tubulacaoRepository.pegarComprimento(nomeTubulacao)).concat(FormulaHelper.METRO));
        
    }
    
    
    
}
