package fr.guddy.chatbotgateway;

import fr.guddy.chatbotgateway.common.infra.Api;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsApi;
import fr.guddy.chatbotgateway.roombookings.infra.RoomBookingsProperties;
import fr.guddy.chatbotgateway.roombookings.infra.mails.StaticAuthorizedRecipients;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public final class Main {
    public static void main(final String[] args) {
        new Api(
                7070,
                new Retrofit.Builder()
                        .baseUrl(
                                new RoomBookingsProperties().baseUrl()
                        )
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build()
                        .create(RoomBookingsApi.class),
                new StaticAuthorizedRecipients()
        ).start();
    }

}
