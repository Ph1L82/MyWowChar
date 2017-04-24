package cl.philipsoft.ph1l.mywowchar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import cl.philipsoft.ph1l.mywowchar.background.GetCharacter;
import cl.philipsoft.ph1l.mywowchar.models.Character;
import cl.philipsoft.ph1l.mywowchar.network.CharacterInterceptor;
import cl.philipsoft.ph1l.mywowchar.views.CharacterActivity;
import cl.philipsoft.ph1l.mywowchar.views.CharacterCallback;

public class MainActivity extends AppCompatActivity implements CharacterCallback {

    GetCharacter getCharacter = new GetCharacter();
    Spinner charactersSp;
    Button loadBtn = (Button) findViewById(R.id.loadBtn);
    String characterName = CharacterInterceptor.DEFAULT_CHARACTER;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View view = findViewById(R.id.splash);

        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        charactersSp = (Spinner) findViewById(R.id.charactersSp);
        getCharacter.callback = this;
        charactersSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                characterName = String.valueOf(charactersSp.getSelectedItem());
                Log.d("SELECTED_CHARACTER", String.valueOf(charactersSp.getSelectedItem()));
                loadBtn.setVisibility(View.VISIBLE);
                loadBtn.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, Resources.getSystem().getString(R.string.choose_character), Toast.LENGTH_SHORT).show();
            }
        });
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("GETCHARACTER_EXECUTE", CharacterInterceptor.DEFAULT_REALM + " " + characterName + " " + CharacterInterceptor.DEFAULT_LOCALE + " " + CharacterInterceptor.API_KEY);
                getCharacter.execute(CharacterInterceptor.DEFAULT_REALM, characterName, CharacterInterceptor.DEFAULT_LOCALE, CharacterInterceptor.API_KEY);
            }
        });
    }

    @Override
    public void characterLoaded(Character character) {
        if (character != null) {
            Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
            intent.putExtra("character", character);
            startActivity(intent);
        } else {
            Toast.makeText(this, "No se encontró el personaje", Toast.LENGTH_SHORT).show();
        }
    }
}
