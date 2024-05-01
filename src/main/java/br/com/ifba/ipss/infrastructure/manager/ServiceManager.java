package br.com.ifba.ipss.infrastructure.manager;

import br.com.ifba.ipss.feature.conexao.domain.repository.ConexaoRepositoryImpl;
import br.com.ifba.ipss.feature.conexao.domain.repository.IConexaoRepository;
import br.com.ifba.ipss.feature.conexao.domain.service.ConexaoServiceImpl;
import br.com.ifba.ipss.feature.conexao.domain.service.IConexaoService;
import br.com.ifba.ipss.feature.equipamento.domain.repository.EquipamentoRepositoryImpl;
import br.com.ifba.ipss.feature.equipamento.domain.repository.IEquipamentoRepository;
import br.com.ifba.ipss.feature.equipamento.domain.service.EquipamentoServiceImpl;
import br.com.ifba.ipss.feature.equipamento.domain.service.IEquipamentoService;
import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.EspacoTrabalhoRepositoryImpl;
import br.com.ifba.ipss.feature.espacotrabalho.domain.repository.IEspacoTrabalhoRepository;
import br.com.ifba.ipss.feature.espacotrabalho.domain.service.EspacoTrabalhoServiceImpl;
import br.com.ifba.ipss.feature.espacotrabalho.domain.service.IEspacoTrabalhoService;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.ITubulacaoRepository;
import br.com.ifba.ipss.feature.tubulacao.domain.repository.TubulacaoRepositoryImpl;
import br.com.ifba.ipss.feature.tubulacao.domain.service.ITubulacaoService;
import br.com.ifba.ipss.feature.tubulacao.domain.service.TubulacaoServiceImpl;
import br.com.ifba.ipss.feature.valvula.domain.repository.IValvulaRepository;
import br.com.ifba.ipss.feature.valvula.domain.repository.ValvulaRepositoryImpl;
import br.com.ifba.ipss.feature.valvula.domain.service.IValvulaService;
import br.com.ifba.ipss.feature.valvula.domain.service.ValvulaServiceImpl;
import br.com.ifba.ipss.infrastructure.interfaces.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class ServiceManager {
    
    public static final Map<Class<?>, ServiceImpl> serviceMap;
    
    static {
        
        serviceMap = new HashMap<>() {{
        
            put(
                    IEspacoTrabalhoService.class, 
                    new EspacoTrabalhoServiceImpl(
                            (EspacoTrabalhoRepositoryImpl)
                                    RepositoryManager.find(IEspacoTrabalhoRepository.class)
                    )
            );
            
            put(
                    ITubulacaoService.class,
                    new TubulacaoServiceImpl(
                            (TubulacaoRepositoryImpl)
                                RepositoryManager.find(ITubulacaoRepository.class)
                    )
            );
            
            put(
                    IConexaoService.class,
                    new ConexaoServiceImpl(
                            (ConexaoRepositoryImpl)
                                RepositoryManager.find(IConexaoRepository.class)
                    )
            );
            
            put(
                    IEquipamentoService.class,
                    new EquipamentoServiceImpl(
                            (EquipamentoRepositoryImpl)
                                RepositoryManager.find(IEquipamentoRepository.class)
                    )
            );
            
            put(
                    IValvulaService.class,
                    new ValvulaServiceImpl(
                            (ValvulaRepositoryImpl)
                                RepositoryManager.find(IValvulaRepository.class)
                    )
            );
            
            
        }};
        

        
    }
    
    public static <T>T find(final Class<T> i){
        
        if(serviceMap.containsKey(i)){
            
            return (T) serviceMap.get(i);
            
        }
        
        return null;
    }
    
}
