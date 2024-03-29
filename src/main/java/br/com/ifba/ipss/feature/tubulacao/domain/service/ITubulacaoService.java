package br.com.ifba.ipss.feature.tubulacao.domain.service;

import br.com.ifba.ipss.common.infrastructure.interfaces.IEquipamentoService;
import br.com.ifba.ipss.feature.tubulacao.domain.model.Tubulacao;
import java.util.List;

/**
 *
 * @author Giovane Neves
 */
public interface ITubulacaoService extends IEquipamentoService{
    
    List<Tubulacao> pegarEquipamentos();
    
    String pegarDiametroInterno(String nomeTubulacao);
    
    String pegarComprimento(String nomeTubulacao);
}
