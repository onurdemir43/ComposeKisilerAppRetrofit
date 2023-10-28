package com.onurdemir.composekisilerapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.onurdemir.composekisilerapp.entity.ApiUtils
import com.onurdemir.composekisilerapp.entity.CRUDCevap
import com.onurdemir.composekisilerapp.entity.Kisiler
import com.onurdemir.composekisilerapp.entity.KisilerCevap
import com.onurdemir.composekisilerapp.retrofit.KisilerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerDaoRepository {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    var kisilerDaoInterface : KisilerDaoInterface

    init {
        kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()
        kisilerListesi = MutableLiveData()
    }

    fun kisilerGetir():MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

    fun tumKisileriAl() {
        kisilerDaoInterface.tumKisiler().enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val liste = response.body()?.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {}
        })
    }
    fun kisiAra(aramaKelimesi:String) {
        kisilerDaoInterface.kisiAra(aramaKelimesi).enqueue(object : Callback<KisilerCevap>{
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val liste = response.body()?.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {}
        })
    }

    fun kisiKayit(kisi_ad:String, kisi_tel:String) {
        kisilerDaoInterface.kisiEkle(kisi_ad, kisi_tel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {}
            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun kisiGuncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String) {
        kisilerDaoInterface.kisiGuncelle(kisi_id, kisi_ad, kisi_tel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {}
            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }

    fun kisiSil(kisi_id:Int) {
        kisilerDaoInterface.kisiSil(kisi_id).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                tumKisileriAl()
            }
            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })
    }
}
