package com.example.ivbgr1_passdata_fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ivbgr1_passdata_fragments.R

class FragmentB : Fragment() {

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