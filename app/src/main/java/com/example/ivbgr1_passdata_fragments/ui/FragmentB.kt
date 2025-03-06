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

class FragmentB : Fragment() {

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


    fun updateData(data: String){
        view?.findViewById<TextView>(R.id.message_in_frag_b_textview)?.text = data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<Button>(R.id.send_frag_b_button)
        val editText: EditText = view.findViewById(R.id.frag_b_edittext)
        textView = view.findViewById(R.id.message_in_frag_b_textview)
    }



    companion object {

        fun newInstance(data: String): FragmentB{
            val fragment = FragmentB()

            val args = Bundle()
            args.putString("data_key", data)
            fragment.arguments =args
            return fragment
        }

    }
}