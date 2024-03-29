package br.com.ifba.ipss.helper;

import br.com.ifba.ipss.util.Escoamento;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class FormulaHelper {
    
    private static final double PI = 3.14f;

    public static final String PES = "in";
    public static final String METRO = "m";
    
    public static double EQUACAO_DE_REYNOLD(double vel, double di, double rho, double vd){
        
        double re = rho * vel * di / vd;
        
        return re;
        
    }
    
    public static double EQUACAO_DE_POISEULLE(double l, double vel, double vc, double g, double d){
        
        double j = 32 * l * vel * vc / g * (d*d);
        
        return j;
        
    }
    public static double EQUACAO_DE_DARCY_WEISBACH(double f, double l, double d, double vel, double g){
        
        double j = f * l / d * vel * vel / 2 * g;
        
        return j;
    
    }
    

    
    public static String VERIFICAR_ESCOAMENTO(double re){
        
      return (re < 2000f) ?
            Escoamento.ESCOAMENTO_LAMINAR.getString() :
            (re > 2000f && re < 2400f) ?
            Escoamento.ESCOAMENTO_TRANSITORIO.getString() :
            Escoamento.ESCOAMENTO_TURBULENTO.getString();
    }  
}
    
