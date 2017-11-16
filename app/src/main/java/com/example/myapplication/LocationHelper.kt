package com.example.myapplication

import android.arch.lifecycle.LiveData
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

/**
 * Created by user on 11/15/17.
 */

class LocationHelper(context: Context) : LiveData<Location>(), LocationListener {

  private val locationManager: LocationManager
      = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

  override fun onLocationChanged(p0: Location?) {
    value = p0
  }

  override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
    println("TAG_ onStatusChanged")
  }

  override fun onProviderEnabled(p0: String?) {
    println("TAG_ onProviderEnabled")
  }

  override fun onProviderDisabled(p0: String?) {
    println("TAG_ onProviderDisabled")
  }

  override fun onInactive() {
    super.onInactive()

    locationManager.removeUpdates(this)
  }

  override fun onActive() {
    super.onActive()

    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
        0, 0f, this)
  }
}

