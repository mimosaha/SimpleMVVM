package database.example.com.simplerecyclermvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [31-Jul-2018 at 3:42 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: SimpleRecyclerMvvm.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [31-Jul-2018 at 3:42 PM].
 * * --> <Second Editor> on [31-Jul-2018 at 3:42 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [31-Jul-2018 at 3:42 PM].
 * * --> <Second Reviewer> on [31-Jul-2018 at 3:42 PM].
 * * ============================================================================
 **/
public class UserModel implements Serializable {

    @SerializedName("name")
    public Name name;

    @SerializedName("cell")
    public String cell;

}
