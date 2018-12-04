package fr.guddy.chatbotgateway.roombookings.infra;

import fr.guddy.chatbotgateway.roombookings.domain.Booking;
import fr.guddy.chatbotgateway.roombookings.domain.Room;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RoomBookingsApi {
    @POST("rooms")
    Call<ResponseBody> createRoom(@Body final Room room);

    @GET("rooms")
    Call<List<Room>> allRooms();

    @GET("rooms")
    Call<List<Room>> capableRooms(@Query("capacity") final int capacity);

    @GET("rooms")
    Call<List<Room>> availableRooms(
            @Query("capacity") final int capacity,
            @Query("timestamp_start") final long timestampStart,
            @Query("timestamp_end") final long timestampEnd
    );

    @POST("rooms/{name}/bookings")
    Call<Booking> createBooking(@Path("name") final String name, @Body final Booking booking);

    @GET("rooms/{name}/bookings")
    Call<List<Booking>> bookingsForRoomInSlot(
            @Path("name") final String roomName,
            @Query("timestamp_start") final long timestampStart,
            @Query("timestamp_end") final long timestampEnd
    );

    @GET("bookings")
    Call<List<Booking>> bookingReminders(@Query("user_id") final String userId);

    @DELETE("bookings/{id}")
    Call<Booking> deleteBooking(@Path("id") final long id);
}
