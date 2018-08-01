package database.example.com.simplerecyclermvvm.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [31-Jul-2018 at 6:21 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: SimpleRecyclerMvvm.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [31-Jul-2018 at 6:21 PM].
 * * --> <Second Editor> on [31-Jul-2018 at 6:21 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [31-Jul-2018 at 6:21 PM].
 * * --> <Second Reviewer> on [31-Jul-2018 at 6:21 PM].
 * * ============================================================================
 **/

public interface ServerHitService {

    String RANDOM_USER_URL = "http://api.randomuser.me/?results=10&nat=en";
    String BASE_URL = "http://api.randomuser.me/";

    /**
     * The purpose of this API is fetching user from server
     * @param url -> Fetching users url
     * @return a response as an observable format
     */
    @GET
    Observable<ServerResponse> fetchUsers(@Url String url);

}
