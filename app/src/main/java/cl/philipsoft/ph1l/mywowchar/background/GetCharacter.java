package cl.philipsoft.ph1l.mywowchar.background;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import cl.philipsoft.ph1l.mywowchar.models.Character;
import cl.philipsoft.ph1l.mywowchar.network.CharacterInterceptor;
import cl.philipsoft.ph1l.mywowchar.network.Characters;
import cl.philipsoft.ph1l.mywowchar.views.CharacterCallback;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by phil_ on 23-04-2017.
 */

public class GetCharacter extends AsyncTask<String, Integer, Character> {

    private final Characters characters = new CharacterInterceptor().getChar();
    private int code = 666;
    public CharacterCallback callback = null;

    @Override
    protected Character doInBackground(String... params) {
        Log.d("GETCHARACTER", " params[0]:" + params[0] + " params[1]:" + params[1] + " params[2]:" + params[2] + " params[3]:" + params[3]);
        Call<Character> call = characters.get(params[0], params[1], params[2], params[3]);

        try {
            Response<Character> response = call.execute();
            code = response.code();
            if (200 == code && response.isSuccessful()) {
                Character character = response.body();
                return character;
            } else {
                code = 777;

            }
        } catch (IOException e) {
            e.printStackTrace();
            code = e.hashCode();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Character character) {
        Log.d("RESULT", String.valueOf(character));
        callback.characterLoaded(character);
    }
}
