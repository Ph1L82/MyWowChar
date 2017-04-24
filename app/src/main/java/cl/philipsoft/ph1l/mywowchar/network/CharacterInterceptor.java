package cl.philipsoft.ph1l.mywowchar.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by phil_ on 23-04-2017.
 */

public class CharacterInterceptor {

    protected static final String BASE_URL = "https://us.api.battle.net/wow/";

    public static final String API_KEY = "gfnfh2y3gf6erht6pzttjwvay9ybjhjh";
    public static final String DEFAULT_LOCALE = "es_MX";
    public static final String DEFAULT_REALM = "ragnaros";
    public static final String DEFAULT_CHARACTER = "reivajal";

    public Characters getChar(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        OkHttpClient client = httpClient.build();

        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        Characters character = interceptor.create(Characters.class);
        return character;
    }
}
