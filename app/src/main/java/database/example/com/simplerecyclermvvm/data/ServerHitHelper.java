package database.example.com.simplerecyclermvvm.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [31-Jul-2018 at 1:47 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: SimpleRecyclerMvvm.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [31-Jul-2018 at 1:47 PM].
 * * --> <Second Editor> on [31-Jul-2018 at 1:47 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [31-Jul-2018 at 1:47 PM].
 * * --> <Second Reviewer> on [31-Jul-2018 at 1:47 PM].
 * * ============================================================================
 **/
public class ServerHitHelper {

    private static ServerHitHelper serverHitMechanism;

    public static ServerHitHelper getInstance() {

        if (serverHitMechanism == null)
            serverHitMechanism = new ServerHitHelper();

        return serverHitMechanism;
    }

    /**
     * Create a server service by base url
     * @return the created server service
     */
    public ServerHitService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ServerHitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ServerHitService.class);
    }
}
