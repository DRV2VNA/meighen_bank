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

    public String createCard() throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"type\":\"DIGITAL_WALLET\",\"memo\":\"New Card\",\"spend_limit\":0,\"spend_limit_duration\":\"TRANSACTION\",\"state\":\"OPEN\"}");
        Request request = new Request.Builder()
                .url("https://sandbox.lithic.com/v1/cards")
                .post(body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "api-key ac56aaa2-a502-49ce-9188-6ebfbde0160d")
                .build();

        Response response = client.newCall(request).execute();
        //response.close();
        return response.body().string();
    }
}
