package com.home.mosbymvpdemo.main.view.viewcontroller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bumptech.glide.Glide
import com.home.mosbymvpdemo.databinding.ActivityMainListDetailViewBinding
import com.home.mosbymvpdemo.main.model.entity.MainListEntity

class MainListDetailViewController : Controller() {

    companion object {
        const val KEY_DATA = "mainListDetailViewControllerData"
    }

    private lateinit var binding: ActivityMainListDetailViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        binding = ActivityMainListDetailViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        args.getParcelable<MainListEntity>(KEY_DATA).apply {
            Glide.with(binding.root.context).load(this!!.imageUrl)
                .into(binding.imageView)
            binding.textViewTitle.text = this.title
            binding.textViewContent.text = this.content
        }
    }
}