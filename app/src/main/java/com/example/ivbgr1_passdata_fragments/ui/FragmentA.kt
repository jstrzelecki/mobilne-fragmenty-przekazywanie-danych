package com.example.ivbgr1_passdata_fragments.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.ivbgr1_passdata_fragments.R
import com.example.ivbgr1_passdata_fragments.interfaces.DataPassInterface
import org.w3c.dom.Text

class FragmentA : Fragment() {

    private lateinit var listener: DataPassInterface
    private lateinit var textView: TextView

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is DataPassInterface){
            listener = context
        } else {
            throw RuntimeException("$context must implement DataPassInterface")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.send_frag_a_button)
        textView = view.findViewById(R.id.msg_frag_a_textview)

        btn.setOnClickListener {
            val msg: String = view.findViewById<EditText>(R.id.frag_a_edittext).text.toString()
            listener.onDataPass(msg, "frag_a")
        }
    }

    fun updateData(data: String){
        textView.text = data
    }

    companion object {  }
}