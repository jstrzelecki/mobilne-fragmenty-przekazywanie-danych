package com.example.ivbgr1_passdata_fragments.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.ivbgr1_passdata_fragments.R
import com.example.ivbgr1_passdata_fragments.interfaces.FragmentAListener

class FragmentA : Fragment() {

    private lateinit var listener: FragmentAListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is FragmentAListener){
            listener = context
        } else {
            throw RuntimeException("$context must implement FragmentAListener")
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

        val btn = view.findViewById<Button>(R.id.send_to_frag_b_button)
        btn.setOnClickListener {
            listener.onDataPass("Wiadomość z Fragmentu A. Bartek: 'przyszłem'")
        }
    }

    companion object {  }
}