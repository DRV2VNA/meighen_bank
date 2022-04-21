package io.meighen_bank_operationer.service.banking;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;
import io.meighen_bank_operationer.entity.Card;
import io.meighen_bank_operationer.entity.LithicCardDetails;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

public class LithicBanking implements BankingService {
    @Value("${lithic.api-key}")
    private String apiKey;

    public String createCard() throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"type\":\"DIGITAL_WALLET\",\"memo\":\"New Card\",\"spend_limit\":0,\"spend_limit_duration\":\"TRANSACTION\",\"state\":\"OPEN\"}");
        Request request = new Request.Builder()
                .url("https://sandbox.lithic.com/v1/cards")
                .post(body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "api-key " + apiKey)
                .build();

        Response response = client.newCall(request).execute();
        //response.close();
        return response.body().string();
    }

    public void changeCardState(Card card, String state) throws IOException {
        if (!(state.equals("CLOSED") || state.equals("OPEN") || state.equals("PAUSED"))) {return;}
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"state\":\"" + state + "\"}");
        Request request = new Request.Builder()
                .url("https://sandbox.lithic.com/v1/cards/"+card.getLithicCardDetails().getToken())
                .patch(body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "api-key " + apiKey)
                .build();

        Response response = client.newCall(request).execute();
    }

    public String getCardsDetail(String cardToken) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox.lithic.com/v1/cards/"+cardToken)
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "api-key 42f1d153-1bf2-4179-8869-3479ab823c25")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
