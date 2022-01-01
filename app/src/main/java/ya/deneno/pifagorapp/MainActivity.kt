package ya.deneno.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import ya.deneno.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var bc: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bc.root)
    }

    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            val tempText = getString(R.string.result_info) + " " + getPifagorResult()
            bc.textViewResult.text = tempText}
    }

    private fun isFieldEmpty(): Boolean {
        bc.apply {
            if (editTextA.text.isNullOrEmpty()) editTextA.error = "Поле должно быть заполнено"
            if (editTextB.text.isNullOrEmpty()) editTextB.error = "Поле должно быть заполнено"
            return editTextA.text.isNullOrEmpty() || editTextB.text.isNullOrEmpty()
        }
    }

    private fun getPifagorResult(): String {
        bc.apply {
            val a = editTextA.text.toString().toDouble()
            val b = editTextB.text.toString().toDouble()
            return "%.2f".format(sqrt((a*a+b*b)))
        }
    }
}