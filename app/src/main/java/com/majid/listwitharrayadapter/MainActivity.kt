package com.majid.listwitharrayadapter

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.majid.listwitharrayadapter.databinding.ActivityMainBinding
import com.majid.listwitharrayadapter.databinding.CustomDialogBoxBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var arrayAdapter: ArrayAdapter<String>
    private var Array = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Array)
        binding.lvArray.adapter = arrayAdapter
        binding.fab.setOnClickListener {
            val dialog = Dialog(this)
            val dialogBinding = CustomDialogBoxBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
            dialogBinding.add.setOnClickListener {
                if (dialogBinding.etenter.text.toString().isEmpty()) {
                    dialogBinding.etenter.error = "Enter Name"
                } else {
                    Array.add(dialogBinding.etenter.text.toString())
                    dialog.dismiss()
                }
                arrayAdapter.notifyDataSetChanged()
            }
            dialogBinding.Remove.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}