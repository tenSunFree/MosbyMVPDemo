package com.home.mosbymvpdemo.main.presenter.contract

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import com.home.mosbymvpdemo.main.model.entity.MainListEntity

interface MainListContract {

    interface View : MvpLceView<MutableList<MainListEntity>> {
        fun onItemClicked(entity: MainListEntity)
    }

    interface Presenter : MvpPresenter<View> {
        fun loadData(pullToRefresh: Boolean)
    }
}