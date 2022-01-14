package com.musahundur.isimsehiroyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class NormalGameActivity extends AppCompatActivity {

    String[] cities = {"Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "İçel (Mersin)", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"};
    Random random,random2;
    int randomCityNumber,randomCharNumber;
    String randomCity,randomChar;
    TextView textCityTitle;
    TextView textCityLine;
    EditText editTextGuess;
    String lineHeight="";
    ArrayList<Character> cityChars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);

        textCityTitle = findViewById(R.id.textCityTitle);
        textCityLine = findViewById(R.id.textCityLine);
        editTextGuess = findViewById(R.id.editTextGuess);

        random2 = new Random();
        random = new Random();
        randomCityNumber = random.nextInt(cities.length);
        randomCity = cities[randomCityNumber];

        textCityTitle.setText(randomCity.length() +" Harfli İlimiz");
        for (int i = 0; i<randomCity.length(); i++){
            if (i<randomCity.length()-1){
                lineHeight = lineHeight + "_ ";
            }else{
                lineHeight = lineHeight + "_";
            }
        }
        textCityLine.setText(lineHeight);

        cityChars = new ArrayList<>();
        for (char c:randomCity.toCharArray()){
            cityChars.add(c);
        }
    }
    public void buttonGet(View view){
        if (cityChars.size()>0){
            randomCharNumber = random2.nextInt(cityChars.size());
            String[] textChars = textCityLine.getText().toString().split(" ");
            char[] randomCityChars = randomCity.toCharArray();

            for (int i = 0 ; i<randomCity.length();i++){
                if (textChars[i].equals("_") && randomCityChars[i] == cityChars.get(randomCharNumber)){
                    textChars[i] = String.valueOf(cityChars.get(randomCharNumber));
                }
            }

            cityChars.remove(randomCharNumber);
        }
    }
    public void buttonGuess(View view){

    }
}