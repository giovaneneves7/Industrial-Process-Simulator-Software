package br.com.ifba.ipss.helper;

import br.com.ifba.ipss.util.Escoamento;

/**
 *
 * @author Giovane Neves
 * @since V0.0.1
 */
public class FormulaHelper {

    private static final double G    = 9.8f;
    private static final double PI   = 3.14f;
    private static final int TRINTA_E_DOIS = 32;
    public static final String PES   = "in";
    public static final String METRO = "m";
    
    public static double EQUACAO_DE_REYNOLD(double vel, double di, double vd){
        
        double re = vel * di / vd;
        
        return re;
        
    }
    
    public static double EQUACAO_DE_POISEULLE(double l, double vel, double vc, double d){
        
        double j = TRINTA_E_DOIS * l * vel * vc / G * (d*d);
        
        return j;
        
    }
    public static double EQUACAO_DE_DARCY_WEISBACH(double l, double d, double vel, double f){
        
        double j = f * l / d * vel * vel / 2 * G;
        
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
    
