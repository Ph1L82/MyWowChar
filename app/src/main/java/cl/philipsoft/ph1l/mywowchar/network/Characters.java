package cl.philipsoft.ph1l.mywowchar.network;

import cl.philipsoft.ph1l.mywowchar.models.Character;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by phil_ on 23-04-2017.
 */

public interface Characters {

    @GET("character/{realm}/{character}")
    Call<Character> get(
            @Path("realm") String realm,
            @Path("character") String character,
            @Query("locale") String locale,
            @Query("apikey") String APIKEY
    );
}
