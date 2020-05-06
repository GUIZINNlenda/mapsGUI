/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.kotlindemos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.ktx.MapsExperimentalFeature
import com.google.maps.android.ktx.awaitMap

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
class BasicMapDemoActivity :
        AppCompatActivity() {

    val SYDNEY = LatLng(-33.862, 151.21)
    val ZOOM_LEVEL = 13f

    @MapsExperimentalFeature
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_map_demo)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment

        lifecycle.coroutineScope.launchWhenCreated {
            check(mapFragment != null)
            val googleMap = mapFragment.awaitMap() // Execution pauses here until we get the callback from the Maps SDK with a googleMap.
            // This is where we can add markers or lines, add listeners or move the camera.
            // In this case, we just move the camera to Sydney and add a marker in Sydney.
            with(googleMap) {
                moveCamera(CameraUpdateFactory.newLatLngZoom(SYDNEY, ZOOM_LEVEL))
                addMarker(MarkerOptions().position(SYDNEY))
            }
        }
    }
}
