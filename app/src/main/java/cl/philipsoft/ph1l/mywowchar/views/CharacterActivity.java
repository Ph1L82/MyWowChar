package cl.philipsoft.ph1l.mywowchar.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cl.philipsoft.ph1l.mywowchar.R;
import cl.philipsoft.ph1l.mywowchar.models.Character;

public class CharacterActivity extends AppCompatActivity {
    private static final int ALLIANCE = 0;
    private static final int HORDE = 1;
    TextView levelTv, realmTv, killsTv, achievementsTv;
    ImageView factionShield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Character myChar = (Character) intent.getSerializableExtra("character");

        setTitle(myChar.getName());
        factionShield = (ImageView) findViewById(R.id.factionShield);
        switch (myChar.getFaction()) {
            case ALLIANCE:
                factionShield.setImageResource(R.mipmap.ic_wow_alliance_48dp);
                factionShield.setBackgroundColor(getResources().getColor(R.color.allianceBackground));
                setTitleColor(getResources().getColor(R.color.allianceFront));
                break;
            case HORDE:
                factionShield.setImageResource(R.mipmap.ic_wow_horde_48dp);
                factionShield.setBackgroundColor(getResources().getColor(R.color.hordeBackground));
                setTitleColor(getResources().getColor(R.color.hordeFront));
                break;
        }


        levelTv = (TextView) findViewById(R.id.levelTv);
        realmTv = (TextView) findViewById(R.id.realmTv);
        killsTv = (TextView) findViewById(R.id.killsTv);
        achievementsTv = (TextView) findViewById(R.id.achievementsTv);

        levelTv.setText("Level: " + myChar.getLevel());
        realmTv.setText("Realm: " + myChar.getRealm());
        killsTv.setText("Honorable Kills: " + myChar.getTotalHonorableKills());
        achievementsTv.setText("Achievements: " + myChar.getAchievementPoints());


    }
}
