package store.ring.papyruscodingtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Transformations.map

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_maps.*
import store.ring.papyruscodingtest.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        //calling our frame layout to set pull up animated behaviour
        BottomSheetBehavior.from(pulUpPage).apply {
            peekHeight = 340
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                BottomSheetBehavior.from(pulUpPage).apply {
                    peekHeight = 800
                    this.state = BottomSheetBehavior.STATE_EXPANDED

                    if (this.state.equals(BottomSheetBehavior.STATE_EXPANDED)){
                        var intent = Intent(this@MapsActivity, HistoryPage::class.java)
                        startActivity(intent)
                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val Papyrus = LatLng(6.617553885761351, 3.3728195397469345)
        mMap.addMarker(MarkerOptions().position(Papyrus))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Papyrus))
    }
}