package com.onurdemir.composekisilerapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.onurdemir.composekisilerapp.repository.KisilerDaoRepository

class KisiDetaySayfaViewModel : ViewModel() {
    var krepo = KisilerDaoRepository()

    fun guncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String) {
        krepo.kisiGuncelle(kisi_id, kisi_ad, kisi_tel)
    }
}