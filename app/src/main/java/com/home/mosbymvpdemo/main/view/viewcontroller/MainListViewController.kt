package com.home.mosbymvpdemo.main.view.viewcontroller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.hannesdorfmann.mosby3.conductor.viewstate.lce.MvpLceViewStateController
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.data.ParcelableListLceViewState
import com.home.mosbymvpdemo.R
import com.home.mosbymvpdemo.databinding.ActivityMainListViewBinding
import com.home.mosbymvpdemo.main.model.entity.MainListEntity
import com.home.mosbymvpdemo.main.presenter.MainListPresenter
import com.home.mosbymvpdemo.main.presenter.contract.MainListContract
import com.home.mosbymvpdemo.main.view.adapter.MainListAdapter

class MainListViewController :
    MvpLceViewStateController<ConstraintLayout, MutableList<MainListEntity>, MainListContract.View,
            MainListContract.Presenter>(), MainListContract.View {

    private lateinit var adapter: MainListAdapter
    private lateinit var binding: ActivityMainListViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        binding = ActivityMainListViewBinding.inflate(inflater, container, false)
        initRecyclerView(container.context)
        return binding.root
    }

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadData(pullToRefresh)
    }

    override fun createPresenter(): MainListContract.Presenter =
        MainListPresenter()

    override fun setData(data: MutableList<MainListEntity>) {
        adapter.updateNotes(data)
    }

    override fun getData(): MutableList<MainListEntity> {
        return adapter.getNotesList()
    }

    override fun showContent() {
        super.showContent()
    }

    override fun getErrorMessage(e: Throwable, pullToRefresh: Boolean) = "Error loading."

    override fun showError(e: Throwable?, pullToRefresh: Boolean) {
        super.showError(e, pullToRefresh)
    }

    override fun showLoading(pullToRefresh: Boolean) {
        super.showLoading(pullToRefresh)
    }

    override fun createViewState(): LceViewState<MutableList<MainListEntity>, MainListContract.View> {
        return ParcelableListLceViewState()
    }

    override fun onItemClicked(entity: MainListEntity) {
        val noteDetailView = MainListDetailViewController().apply {
            args.putParcelable(MainListDetailViewController.KEY_DATA, entity)
        }
        router.pushController(
            RouterTransaction.with(noteDetailView)
                .pushChangeHandler(FadeChangeHandler())
                .popChangeHandler(FadeChangeHandler())
        )
    }

    private fun initRecyclerView(context: Context) {
        binding.recyclerViewContent.layoutManager = LinearLayoutManager(context)
        adapter = MainListAdapter()
        adapter.onItemClick = { onItemClicked(it) }
        binding.recyclerViewContent.adapter = adapter
    }

    override fun getLoadingViewId(): Int {
        return R.id.progress_bar_loading
    }

    override fun getContentViewId(): Int {
        return R.id.recycler_view_content
    }

    override fun getErrorViewId(): Int {
        return R.id.text_view_error
    }
}