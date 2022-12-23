package ru.stas.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.stas.explicitintent.databinding.ActivityMainBinding
import ru.stas.explicitintent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val qString = extras.getString("qString")
        binding.textView2.text = qString

        binding.button2.setOnClickListener {
            returnText()
        }

    }
    private fun returnText(){
        finish()
    }
    override fun finish() {
        val data = Intent()
        val returnString = binding.editText2.text.toString()
        data.putExtra("returnData",returnString)
        setResult(RESULT_OK,data)
        super.finish()
    }
}