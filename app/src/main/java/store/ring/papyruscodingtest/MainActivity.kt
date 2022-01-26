package store.ring.papyruscodingtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declear default password since we're not using database connections
        var mUsername = "user123"
        var mPassword = "123456"

        //setOnClickListener for login button
        login.setOnClickListener{

            //get text from the input fields
            val user = username.text.toString().trim()
            val pass = password.text.toString().trim()

            if (user.equals(mUsername) || pass.equals(mPassword)){
                //if credentials are correct, move to map activity
                var intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }else{
                //if credentials is wrong,, display a toast
                Toast.makeText(baseContext, "User not found", Toast.LENGTH_LONG).show()
            }
        }
    }
}