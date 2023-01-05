package com.hardy.afreeca

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.hardy.afreeca.base.BaseActivity
import com.hardy.afreeca.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.container) as? NavHostFragment)?.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController?.setGraph(R.navigation.nav_main)
    }
}