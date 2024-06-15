package br.com.ifba.ipss.theme;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giovane Neves
 */
public class ThemeManager {
    
    public static Map<String, Color> light = new HashMap<>();
    
    static{
        
        light.put("primary", Light.PRIMARIA);
        light.put("secondary", Light.SECUNDARIA);
        light.put("dark", Light.ESCURO);
        light.put("background", Light.FUNDO);
        light.put("background_hover", Light.FUNDO_SELECIONADO);
        light.put("text", Light.TEXTO);
        
    } 
    
    
    public static Color getColor(String color){
        
        return light.containsKey(color) ? light.get(color) : Color.GRAY;
        
    }
}
