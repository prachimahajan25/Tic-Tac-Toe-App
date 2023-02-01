package com.example.tictactoetry

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainLayout : AppCompatActivity() {
    private var flag: Int = 0
    private var btn1:Button?=null
    private var btn2:Button?=null
    private var btn3:Button?=null
    private var btn4:Button?=null
    private var btn5:Button?=null
    private var btn6:Button?=null
    private var btn7:Button?=null
    private var btn8:Button?=null
    private var btn9:Button?=null
    private var btnplay:Button?=null
    private var btnexit:Button?=null
    private var resultname:TextView?=null
    private var recieved:String=""
    private var recieved2:String=""
    private var tv:TextView?=null
    private var dialog:Dialog?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        btn1=findViewById(R.id.button1)
        btn2=findViewById(R.id.button2)
        btn3=findViewById(R.id.button3)
        btn4=findViewById(R.id.button4)
        btn5=findViewById(R.id.button5)
        btn6=findViewById(R.id.button6)
        btn7=findViewById(R.id.button7)
        btn8=findViewById(R.id.button8)
        btn9=findViewById(R.id.button9)

        tv=findViewById(R.id.tvwinner)
        btn1?.setBackgroundColor(getResources().getColor(R.color.white))
        btn2?.setBackgroundColor(getResources().getColor(R.color.white))
        btn3?.setBackgroundColor(getResources().getColor(R.color.white))
        btn4?.setBackgroundColor(getResources().getColor(R.color.white))
        btn5?.setBackgroundColor(getResources().getColor(R.color.white))
        btn6?.setBackgroundColor(getResources().getColor(R.color.white))
        btn7?.setBackgroundColor(getResources().getColor(R.color.white))
        btn8?.setBackgroundColor(getResources().getColor(R.color.white))
        btn9?.setBackgroundColor(getResources().getColor(R.color.white))
        btnplay?.setBackgroundColor(getResources().getColor(R.color.white))
        btnexit?.setBackgroundColor(getResources().getColor(R.color.white))

        resultname=findViewById(R.id.result)
        var name1:TextView=findViewById(R.id.name1)
        var name2:TextView=findViewById(R.id.name2)

        val intent=intent
        recieved=intent.getStringExtra("player1").toString()
        recieved2= intent.getStringExtra("player2").toString()
        name1.text= recieved+" : O"
        name2.text=recieved2 +" : X"
        resultname?.text=recieved + " turn"




    }

    @SuppressLint("SetTextI18n")
    fun btn1(view: View) {
        if (flag == 0) {
            (view as Button).text = "O"
            flag = 1
            resultname?.text=recieved2+ " turn"
            view?.isEnabled=false
            check()
        } else if (flag == 1) {
            (view as Button).text = "X"
            flag = 2
            resultname?.text= recieved + " turn"
            view?.isEnabled=false
            check()
        } else if (flag == 2) {
            (view as Button).text = "O"
            flag = 1
            resultname?.text=recieved2 + " turn"
            view?.isEnabled=false
            check()
        }


    }
    fun enable()
    {
        btn1?.isEnabled=true
        btn2?.isEnabled=true
        btn3?.isEnabled=true
        btn4?.isEnabled=true
        btn5?.isEnabled=true
        btn6?.isEnabled=true
        btn7?.isEnabled=true
        btn8?.isEnabled=true
        btn9?.isEnabled=true



    }
    fun disable()
    {
        btn1?.isEnabled=false
        btn2?.isEnabled=false
        btn3?.isEnabled=false
        btn4?.isEnabled=false
        btn5?.isEnabled=false
        btn6?.isEnabled=false
        btn7?.isEnabled=false
        btn8?.isEnabled=false
        btn9?.isEnabled=false
    }
    fun win1(text:String)
    {

        dialog = Dialog(this)
        dialog?.setContentView(R.layout.custom_popup)
        val textView = dialog?.findViewById<TextView>(R.id.tvwinner)
        textView?.setText(text)
        btnplay=dialog?.findViewById(R.id.btnplayagain)
        btnexit=dialog?.findViewById(R.id.btnexit)
        btnplay?.setOnClickListener{
            val intent= Intent(applicationContext,MainActivity::class.java) //for running activities
            startActivity(intent)
            finish()
        }
        btnexit?.setOnClickListener{
            finish()
        }

        dialog?.show()




    }
    fun win2(text:String)
    {
        dialog = Dialog(this)
        dialog?.setContentView(R.layout.custom_popup)
        val textView = dialog?.findViewById<TextView>(R.id.tvwinner)
        textView?.setText(text)
        btnplay=dialog?.findViewById(R.id.btnplayagain)
        btnexit=dialog?.findViewById(R.id.btnexit)
        btnplay?.setOnClickListener{
            val intent= Intent(applicationContext,MainActivity::class.java) //for running activities
            startActivity(intent)
            finish()
        }
        btnexit?.setOnClickListener{
            finish()
        }


        dialog?.show()

    }
    @SuppressLint("SetTextI18n")
    fun check()
    {
        if(btn1?.text=="O"&&btn2?.text=="O"&&btn3?.text=="O")
        {
            resultname?.text=recieved + " wins"

            disable()
            win1(recieved)

        }
        else if(btn4?.text=="O"&&btn5?.text=="O"&&btn6?.text=="O")
        {
            resultname?.text=recieved + " wins"
            disable()
            win1(recieved)
        }
        else if(btn7?.text=="O"&&btn8?.text=="O"&&btn9?.text=="O")
        {
            resultname?.text=recieved + " wins"
            disable()
            win1(recieved)
        }
        else if(btn1?.text=="X"&&btn2?.text=="X"&&btn3?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }
        else if(btn4?.text=="X"&&btn5?.text=="X"&&btn6?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }
        else if(btn7?.text=="X"&&btn8?.text=="X"&&btn9?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }
        else if(btn1?.text=="O"&&btn4?.text=="O"&&btn7?.text=="O")
        {
            resultname?.text=recieved + " wins"
            disable()
            win1(recieved)
        }
        else if(btn2?.text=="O"&&btn5?.text=="O"&&btn8?.text=="O")
        {
            resultname?.text=recieved + " wins"
            disable()
            win1(recieved)
        }
        else if(btn3?.text=="O"&&btn6?.text=="O"&&btn9?.text=="O")
        {
            resultname?.text=recieved + " wins"
            disable()
            win1(recieved)
        }
        else if(btn1?.text=="X"&&btn4?.text=="X"&&btn7?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }


        else if(btn2?.text=="X"&&btn5?.text=="X"&&btn8?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }
        else if(btn3?.text=="X"&&btn6?.text=="X"&&btn9?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }
        else if(btn1?.text=="X"&&btn5?.text=="X"&&btn9?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }
        else if(btn3?.text=="X"&&btn5?.text=="X"&&btn7?.text=="X")
        {
            resultname?.text=recieved2 + " wins"
            disable()
            win2(recieved2)
        }
        else if(btn1?.text=="O"&&btn5?.text=="O"&&btn9?.text=="O")
        {
            resultname?.text=recieved + " wins"
            disable()
            win1(recieved)
        }
        else if(btn3?.text=="O"&&btn5?.text=="0"&&btn7?.text=="O")
        {
            resultname?.text=recieved + " wins"
            disable()
            win1(recieved)
        }
        else if (btn1?.text?.isEmpty()==false&&btn2?.text?.isEmpty()==false&&btn3?.text?.isEmpty()==false&&btn4?.text?.isEmpty()==false&&btn5?.text?.isEmpty()==false&&btn6?.text?.isEmpty()==false&&btn7?.text?.isEmpty()==false&&btn8?.text?.isEmpty()==false&&btn9?.text?.isEmpty()==false)
        {
            resultname?.text="Match Draw"

        }


    }

}