package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val citySpinner = findViewById<Spinner>(R.id.city_spinner)

        val cities = arrayOf(
            "Kota Bandung",
            "Kota Cimahi",
            "Kabupaten Bandung"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cities
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        citySpinner.adapter = adapter
    }

    fun onRadioButtonClicked(view: View) {
        // Is the button now checked?
        val checked = (view as RadioButton).isChecked

        when (view.getId()) {
            R.id.sameday -> if (checked)
                displayToast(
                    getString(R.string.same_day_messenger_service)
                )

            R.id.nextday -> if (checked)
                displayToast(
                    getString(R.string.next_day_ground_delivery)
                )

            R.id.pickup -> if (checked)
                displayToast(
                    getString(R.string.pick_up)
                )

            else -> {}
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}