package com.example.homework5quiz

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_reset.setOnClickListener {
            rb_opt1.setChecked(false)
            rb_opt2.setChecked(false)
            rb_opt3.setChecked(false)
            cb_opt1.setChecked(false)
            cb_opt2.setChecked(false)
            cb_opt3.setChecked(false)
        }

        btn_submit.setOnClickListener {
            var score=0;
            val df: DateFormat = SimpleDateFormat("EEE, d MMM yyyy, HH:mm")
            val date: String = df.format(Calendar.getInstance().getTime())
            if (rb_opt2.isChecked){
                score=score+50;
            }
            if(cb_opt1.isChecked && cb_opt2.isChecked && !cb_opt3.isChecked){
                score=score+50;
            }


            val builder = AlertDialog.Builder(this)

            builder.setTitle("Quiz Results")
            builder.setMessage("“Congratulations! You submitted on $date, Your achieved $score%")
            //builder.setIcon(R.drawable.alerticon)

            builder.setPositiveButton("OK"){dialogInterface, which ->

                dialogInterface.dismiss() // dismiss the dialog

            }


            val dialog: AlertDialog = builder.create()

            dialog.show()

        }

    }
}