package com.onurdemir.composekisilerapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUDCevap(@SerializedName("succes")
                     @Expose
                     var succes: Int,
                     @SerializedName("message")
                     @Expose
                     var message: String) {

}