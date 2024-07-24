// Copyright 2024 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.maps.example;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.AdvancedMarkerOptions.CollisionBehavior;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

class AdvancedMarkersCollisionActivity extends AppCompatActivity {

    private GoogleMap map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // [START maps_android_marker_collision]
        Marker marker = map.addMarker(
                new AdvancedMarkerOptions()
                        .position(new LatLng(10.0, 10.0))
                        .zIndex(10f) // Optional.
                        .collisionBehavior(CollisionBehavior.OPTIONAL_AND_HIDES_LOWER_PRIORITY)
        );
        // [END maps_android_marker_collision]
    }
}
