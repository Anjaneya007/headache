package com.example.locationchecker

import android.R
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.mappls.sdk.maps.Mappls
import com.mappls.sdk.maps.geometry.LatLng
import com.mappls.sdk.services.account.MapplsAccountManager


class LocationChecker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_checker)

        val name=intent.getStringExtra("name")
        var latitude= intent.getStringExtra("latitude")?.toDouble()
        var longitude=intent.getStringExtra("longitude")?.toDouble()

        val firstLatlng= latitude?.let {
            if (longitude != null) {
                LatLng(it,longitude)
            }
        }

//        action bar
        supportActionBar?.title =name

        val actionBar: ActionBar?
        actionBar = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#800080"))
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(colorDrawable)
        }

//        MapplsAccountManager.getInstance().restAPIKey = (R.string.key)
//        MapplsAccountManager.getInstance().mapSDKKey = getString(R.string.key)
//        MapplsAccountManager.getInstance().atlasClientId = getString(R.string.clint_id)
//        MapplsAccountManager.getInstance().atlasClientSecret = getString(R.string.clint_secret)
//        Mappls.getInstance(applicationContext)
////
//
//        val firstLatLng = LatLng(28.0, 77.0)
//        val secondLatLng = LatLng(28.67, 77.65)
//        var me=firstLatLng.distanceTo(secondLatLng)
//        Toast.makeText(this,""+me,Toast.LENGTH_SHORT).show()






    }
}