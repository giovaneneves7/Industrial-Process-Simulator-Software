package br.com.ifba.ipss.feature.tubulacao.domain.service;

import static br.com.ifba.ipss.util.Dicionario.tr;

import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.ITubulacaoRepository;
import br.com.ifba.ipss.helper.FormulaHelper;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

import java.util.List;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class TubulacaoServiceImpl implements ITubulacaoService, ServiceImpl{

    private final ITubulacaoRepository tubulacaoRepository;
    
    public TubulacaoServiceImpl(final ITubulacaoRepository tubulacaoRepository){
        
        this.tubulacaoRepository = tubulacaoRepository;
        
    }
    
    @Override
    public List<Tubulacao> pegarEquipamentos() {

        return tubulacaoRepository.pegarListaEquipamentos("tubulacoes"); 
        
    }

    @Override
    public String pegarDiametroInterno(final String nomeTubulacao) {
        
        return tr("di").concat("=").concat(tubulacaoRepository.pegarDiametroInterno(nomeTubulacao).concat(FormulaHelper.PES));
        
    }

    @Override
    public String pegarComprimento(final String nomeTubulacao) {
        
        return tr("l").concat("=").concat(String.valueOf(tubulacaoRepository.pegarComprimento(nomeTubulacao)).concat(FormulaHelper.METRO));
        
    }
    
    
    
}
