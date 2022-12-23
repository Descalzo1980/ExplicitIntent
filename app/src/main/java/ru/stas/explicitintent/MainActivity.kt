package ru.stas.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.stas.explicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val request_code = 5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button1.setOnClickListener {
            sendText()
        }
        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == request_code) && (resultCode == RESULT_OK)){
            data?.let {
                if(it.hasExtra("returnData")){
                    val returnString = it?.extras?.getString("returnData")
                    binding.textView1.text = returnString
                }
            }
        }
    }

    private fun sendText(){
        val i = Intent(this,SecondActivity::class.java)
        val myString = binding.editText1.text.toString()
        i.putExtra("qString",myString)
        startActivityForResult(i,request_code)
    }
}