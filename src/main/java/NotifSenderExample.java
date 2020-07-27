import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotifSenderExample
{
    public static void main(String[] args) throws IOException, JSONException
    {
        //Format de date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        //Éléments notifications
        JSONObject notif = new JSONObject();
        notif.put("title", "Nouvelle note - Cours Base de données");
        notif.put("content", "Vous avez une nouvelle noteéàèàç");
        notif.put("service", "GRADE");

        String cip = "lemj0601";

        try {
            System.out.println(Unirest.post("http://notifius.jplemay.com/users/lemj0601/notifications").header("Content-Type","application/json")
                                      .body(notif.toString())
                                      .asString());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

//        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType,notif.toString());
//        Request request = new Request.Builder()
//                .url(String.format("http://notifius.jplemay.com/users/%s/notifications",cip))
//                .method("POST", body)
//                .build();
//        Response response = client.newCall(request).execute();

        //System.out.println(response.toString());
    }
}
