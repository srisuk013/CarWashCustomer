package com.srisuk.carwashcustomer.presentation.chat

import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionBuilder
import com.microsoft.signalr.HubConnectionState
import com.microsoft.signalr.TransportEnum
import com.srisuk.carwashcustomer.R
import com.srisuk.carwashcustomer.base.BaseActivity
import com.srisuk.carwashcustomer.model.request.ChatRequest
import com.srisuk.carwashcustomer.util.extension.hideSoftKeyboard
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_chat.root_layout
import org.koin.androidx.viewmodel.ext.android.viewModel
//
//class ChatActivity : BaseActivity() {
//    val viewModel by viewModel<ChatViewModel>()
//
//    lateinit var hubConnection: HubConnection
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_chat)
//        hubConnection = HubConnectionBuilder
//            .create("https://sncarwash.azurewebsites.net/chathub")
//            .withTransport(TransportEnum.LONG_POLLING)
//            .build()
//        if (hubConnection.connectionState == HubConnectionState.DISCONNECTED)
//            hubConnection.start()
//
//        viewModel.response.observe {
//            if (it.success) {
//                val message = edt_message.text.toString().trim()
//                val toJson = Gson().toJson(ChatRequest("not",message))
//                hubConnection.send("ChatViewFromServer", toJson)
//            }else{
//                Toast.makeText(baseContext, "ไม่สำเร็จ", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        viewModel.error.observeError()
//        hubConnection.on("ReceiveNewPosition", { message ->
//
//            runOnUiThread {
//
//                val fromJson = Gson().fromJson(message,ChatRequest::class.java)
//                tvMessage.text = tvMessage.text.toString() + "\n${fromJson.name} : ${fromJson.message}"
//            }
//
//        }, String::class.java)
//
//        bt_send.setOnClickListener {
//            val message = edt_message.text.toString().trim()
//            viewModel.chat(ChatRequest("not",message))
//
//            if (hubConnection.connectionState == HubConnectionState.DISCONNECTED) {
//                Toast.makeText(baseContext, "DISCONNECTED", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(baseContext, "CONNECTED", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//        root_layout.setOnClickListener { hideSoftKeyboard() }
//    }
//    companion object {
//        private const val TAG = "MainActivity"
//    }
//}