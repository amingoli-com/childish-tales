package a.childish_tales.util;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;


public class ColorUtil {

    public static void setGradient(View view, String START , String END){
        if (!START.startsWith("#")){
            START = "#"+START;
        }
        if (!END.startsWith("#")){
            END = "#"+END;
        }
        GradientDrawable gradient = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {
                        Color.parseColor(START),
                        Color.parseColor(END)
                });
        view.setBackgroundDrawable(gradient);
    }

    public static void setGradient(View view, String START , String END, Boolean setLeftToRight){
        if (!START.startsWith("#")){
            START = "#"+START;
        }
        if (!END.startsWith("#")){
            END = "#"+END;
        }
        if (setLeftToRight){
            GradientDrawable gradient = new GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    new int[] {
                            Color.parseColor(START),
                            Color.parseColor(END)
                    });
            view.setBackgroundDrawable(gradient);
        }else {
         setGradient(view,START,END);
        }
    }
}
