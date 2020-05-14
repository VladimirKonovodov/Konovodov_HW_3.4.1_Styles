package com.example.konovodov_hw_341_styles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static Button button;

    public static Locale locale;

    private Spinner mLanguagesSpinner;
    private Spinner mColorsSpinner;

    public static int currentThemeRes = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (currentThemeRes != -1) {
            setTheme(currentThemeRes);
        }
        setContentView(R.layout.activity_main);

        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initColorsChange(mColorsSpinner.getSelectedItem().toString());
                initLanguagesChange(mLanguagesSpinner.getSelectedItem().toString());
            }
        });
    }

    private void initSpinnerLanguages() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguagesSpinner.setAdapter(adapterLanguages);

        mLanguagesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //String[] languages = getResources().getStringArray(R.array.languages);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initSpinnerColors() {
        ArrayAdapter<CharSequence> adapterColors = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        adapterColors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mColorsSpinner.setAdapter(adapterColors);

        mColorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // String[] countries = getResources().getStringArray(R.array.colors);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initLanguagesChange(String lang) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (lang) {
            case "Русский": {
                locale = new Locale("ru");
                break;
            }
            case "English": {
                locale = new Locale("en");
                break;
            }
            default:
                break;

        }
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        setTitle(R.string.app_name);
        recreate();
    }

    private void initColorsChange(String color) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (color) {

            case "Черный": {
                currentThemeRes = R.style.ThemeBlack;
                break;
            }
            case "Зеленый": {
                currentThemeRes = R.style.ThemeGreen;
                break;
            }
            case "Синий": {
                currentThemeRes = R.style.ThemeBlue;
                break;
            }
            case "Black": {
                currentThemeRes = R.style.ThemeBlack;
                break;
            }
            case "Green": {
                currentThemeRes = R.style.ThemeGreen;
                break;
            }
            case "Blue": {
                currentThemeRes = R.style.ThemeBlue;
                break;
            }
            default:
                break;

        }

        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

        recreate();


    }

    public void init() {
        button = (Button) findViewById(R.id.button);

        mColorsSpinner = findViewById(R.id.colorsSpinner);
        mLanguagesSpinner = findViewById(R.id.languagesSpinner);

        initSpinnerLanguages();
        initSpinnerColors();

    }
}
