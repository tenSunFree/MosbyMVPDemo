package com.home.mosbymvpdemo.main.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.home.mosbymvpdemo.main.model.repository.MainRepository
import com.home.mosbymvpdemo.main.presenter.contract.MainListContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainListPresenter : MvpBasePresenter<MainListContract.View>(), MainListContract.Presenter {

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun loadData(pullToRefresh: Boolean) {
        disposables.add(
            MainRepository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ifViewAttached { view ->
                        view.setData(it)
                        view.showContent()
                    }
                }, { error ->
                    ifViewAttached { view -> view.showError(error, pullToRefresh) }
                })
        )
    }

    override fun destroy() {
        super.destroy()
        disposables.clear()
    }
}