package com.home.mosbymvpdemo.main.view.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.home.mosbymvpdemo.R
import com.home.mosbymvpdemo.databinding.ActivityMainBinding
import com.home.mosbymvpdemo.main.view.viewcontroller.MainListViewController

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fullTransparent()
        initializeView()
        initializeRouter(savedInstanceState)
    }

    private fun initializeView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun initializeRouter(savedInstanceState: Bundle?) {
        router = Conductor.attachRouter(this, binding.frameLayoutContainer, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(MainListViewController()))
        }
    }

    /**
     * 系統欄全透明
     */
    @SuppressLint("ObsoleteSdkInt")
    private fun fullTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) super.onBackPressed()
    }
}