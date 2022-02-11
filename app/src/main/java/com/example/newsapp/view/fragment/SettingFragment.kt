package com.example.newsapp.view.fragment

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.databinding.SettingFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment(R.layout.setting_fragment) {

    private lateinit var binding: SettingFragmentBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SettingFragmentBinding.bind(view)
        sharedPreferences = requireContext().getSharedPreferences("Setting", Context.MODE_PRIVATE)
        chekedSwich()


        val editor = sharedPreferences.edit()
        binding.btnThem.addOnButtonCheckedListener { group, checkedId, isChecked ->

            when (checkedId) {
                R.id.btn_dark -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putBoolean("NightMode", true)
                }
                R.id.btn_light -> {
                    editor.putBoolean("NightMode", false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
            editor.apply()

        }


    }


    fun chekedSwich() {
        val pref = sharedPreferences.getBoolean("NightMode", true)

        if (pref) {

            binding.btnDark.setTextColor(Color.WHITE)

        } else {
            binding.btnDark.setBackgroundColor(Color.BLACK)
            binding.btnLight.setBackgroundColor(Color.WHITE)
            binding.btnDark.setTextColor(Color.WHITE)
            binding.btnLight.setTextColor(Color.BLACK)
        }


    }

}