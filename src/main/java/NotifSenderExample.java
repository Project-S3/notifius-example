import com.squareup.okhttp.*;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NotifSenderExample
{
    public static void main(String[] args) throws IOException, JSONException
    {
        //Éléments notifications
        JSONObject notif = new JSONObject();
        notif.put("title", "Nouvelle note - Cours Base de données");
        notif.put("content", "Vous avez une nouvelle noteéàèàç");
        notif.put("service", "GRADE");

        String cip = "lemj0601";

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,new String(notif.toString().getBytes(System.getProperty("file.encoding")), StandardCharsets.UTF_8));
        Request request = new Request.Builder()
                .url(String.format("http://notifius.jplemay.com/users/%s/notifications",cip))
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.toString());
    }
}
