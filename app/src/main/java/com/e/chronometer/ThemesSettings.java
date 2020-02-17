package com.e.chronometer;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ThemesSettings {

    public void setLayoutTheme(String theme, LinearLayout menuLT, TextView settingsTV, TextView themesTV){
        if (theme.equals("green")) {
            menuLT.setBackgroundColor(Color.rgb(204, 255, 204));
            settingsTV.setBackgroundColor(Color.rgb(179, 255, 179));
            themesTV.setBackgroundColor(Color.rgb(179, 255, 179));
        }
        if (theme.equals("blue")) {
            menuLT.setBackgroundColor(Color.rgb(179, 179, 255));
            settingsTV.setBackgroundColor(Color.rgb(102, 102, 255));
            themesTV.setBackgroundColor(Color.rgb(102, 102, 255));
        }
        if (theme.equals("gray")) {
            menuLT.setBackgroundColor(Color.rgb(204, 204, 204));
            settingsTV.setBackgroundColor(Color.rgb(140, 140, 140));
            themesTV.setBackgroundColor(Color.rgb(140, 140, 140));
        }

        if (theme.equals("theme 1")) {
            menuLT.setBackgroundResource(R.drawable.sea_green);
            settingsTV.setBackgroundColor(Color.rgb(179, 255, 179));
            themesTV.setBackgroundColor(Color.rgb(179, 255, 179));
        }
        if (theme.equals("theme 2")) {
            menuLT.setBackgroundResource(R.drawable.kimo_gray);
            settingsTV.setBackgroundColor(Color.rgb(140, 140, 140));
            themesTV.setBackgroundColor(Color.rgb(140, 140, 140));
        }
        if (theme.equals("theme 3")) {
            menuLT.setBackgroundResource(R.drawable.samuel_blue);
            settingsTV.setBackgroundColor(Color.rgb(102, 102, 255));
            themesTV.setBackgroundColor(Color.rgb(102, 102, 255));
        }
    }

    public void setMainTheme(String theme, LinearLayout menuLT){
        if (theme.equals("green")) {
            menuLT.setBackgroundColor(Color.rgb(204, 255, 204));
        }
        if (theme.equals("blue")) {
            menuLT.setBackgroundColor(Color.rgb(179, 179, 255));
        }
        if (theme.equals("gray")) {
            menuLT.setBackgroundColor(Color.rgb(204, 204, 204));
        }

        if (theme.equals("theme 1")) {
            menuLT.setBackgroundResource(R.drawable.sea_green);
        }
        if (theme.equals("theme 2")) {
            menuLT.setBackgroundResource(R.drawable.kimo_gray);
        }
        if (theme.equals("theme 3")) {
            menuLT.setBackgroundResource(R.drawable.samuel_blue);
        }
    }
}
