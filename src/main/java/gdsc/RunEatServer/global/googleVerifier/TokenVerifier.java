package gdsc.RunEatServer.global.googleVerifier;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;


@Slf4j
@Configuration
public class TokenVerifier {

    private final NetHttpTransport transport = new NetHttpTransport();
    private final JsonFactory jsonFactory = new GsonFactory();


    public String tokenVerify(String idTokenString) throws GeneralSecurityException, IOException {



        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList("213617031580-3bjijd93fo1fh4jekjo088s6qbb6p6rt.apps.googleusercontent.com"))
                .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);


        if (idToken != null) {

            GoogleIdToken.Payload payload = idToken.getPayload();

            String email = payload.getEmail();

            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");

            return email;
        }
        else {
            return null;
        }
    }

}
