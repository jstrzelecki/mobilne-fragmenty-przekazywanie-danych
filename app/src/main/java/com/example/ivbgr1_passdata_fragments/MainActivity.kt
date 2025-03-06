package com.example.ivbgr1_passdata_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ivbgr1_passdata_fragments.interfaces.DataPassInterface
import com.example.ivbgr1_passdata_fragments.ui.FragmentA
import com.example.ivbgr1_passdata_fragments.ui.FragmentB

class MainActivity : AppCompatActivity(),
    DataPassInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_a, FragmentA(), "FragmentA")
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_b, FragmentB(), "FragmentB")
            .commit()
    }

    override fun onDataPass(data: String) {
        val fragmentB = supportFragmentManager.findFragmentByTag("FragmentB") as? FragmentB
        if(fragmentB !==null){
            fragmentB.updateData(data)
        } else {
            val newFragmentB = FragmentB.newInstance(data)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_b, newFragmentB, "FragmentB")
                .addToBackStack(null)
                .commit()

        }

    }
}