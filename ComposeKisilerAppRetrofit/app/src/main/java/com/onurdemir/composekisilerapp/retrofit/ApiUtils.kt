package com.onurdemir.composekisilerapp.entity

import com.onurdemir.composekisilerapp.retrofit.KisilerDaoInterface

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getKisilerDaoInterface(): KisilerDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }
}