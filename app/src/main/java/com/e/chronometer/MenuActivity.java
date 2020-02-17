package com.e.chronometer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private RadioGroup settingsRG, colorsRG, themesRG;
    private String settings = "start/pause", colors = "gray";
    private LinearLayout menuLT;
    private TextView settingsTV, themesTV;
    private ThemesSettings menuLtTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        settingsRG = findViewById(R.id.actionRadios);
        menuLT = findViewById(R.id.menuLayout);

        colorsRG = findViewById(R.id.colorsRadios);
        themesRG = findViewById(R.id.themesRadios);
        colorsRG.clearCheck();
        themesRG.clearCheck();
        colorsRG.setOnCheckedChangeListener(listenerColorsRG);
        themesRG.setOnCheckedChangeListener(listenerThemesRG);
        settingsTV = findViewById(R.id.settingsTV);
        themesTV = findViewById(R.id.themesTV);

        menuLtTheme = new ThemesSettings();
    }

    public void acceptTheme(View v) {
        if(settingsRG.getCheckedRadioButtonId() != -1){
            settings = getRBName(settingsRG);

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("settings", settings);
            intent.putExtra("theme", colors);
            startActivity(intent);
        }
    }

    private RadioGroup.OnCheckedChangeListener listenerColorsRG = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                themesRG.setOnCheckedChangeListener(null);
                themesRG.clearCheck();
                themesRG.setOnCheckedChangeListener(listenerThemesRG);
                colors = getRBName(colorsRG);
                if (colors.equals("green")) {
                    menuLtTheme.setLayoutTheme(colors, menuLT, settingsTV, themesTV);
                }
                if (colors.equals("blue")) {
                    menuLtTheme.setLayoutTheme(colors, menuLT, settingsTV, themesTV);
                }
                if (colors.equals("gray")) {
                    menuLtTheme.setLayoutTheme(colors, menuLT, settingsTV, themesTV);
                }
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener listenerThemesRG = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                colorsRG.setOnCheckedChangeListener(null);
                colorsRG.clearCheck();
                colorsRG.setOnCheckedChangeListener(listenerColorsRG);
                colors = getRBName(themesRG);
                if (colors.equals("theme 1")) {
                    menuLtTheme.setLayoutTheme(colors, menuLT, settingsTV, themesTV);
                }
                if (colors.equals("theme 2")) {
                    menuLtTheme.setLayoutTheme(colors, menuLT, settingsTV, themesTV);
                }
                if (colors.equals("theme 3")) {
                    menuLtTheme.setLayoutTheme(colors, menuLT, settingsTV, themesTV);
                }
            }
        }
    };

    public String getRBName(RadioGroup group) {
        int id = group.getCheckedRadioButtonId();
        View radioButton = group.findViewById(id);
        int radioId = group.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) group.getChildAt(radioId);
        return (String) btn.getText();
    }

}
