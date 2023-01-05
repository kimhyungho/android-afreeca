package com.hardy.afreeca.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VD : ViewDataBinding>(
    @LayoutRes
    private val layoutResId: Int
) : AppCompatActivity() {

    lateinit var viewDataBinding: VD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding =
            DataBindingUtil.setContentView<VD>(this, layoutResId).also { viewDataBinding ->
                viewDataBinding.lifecycleOwner = this
                this.viewDataBinding = viewDataBinding
            }
    }
}