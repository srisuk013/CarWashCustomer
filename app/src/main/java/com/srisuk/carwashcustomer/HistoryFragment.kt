package com.srisuk.carwashcustomer
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.srisuk.carwashcustomer.base.BaseFragment
import com.srisuk.carwashcustomer.viewmodel.HistoryViewModel
import kotlinx.android.synthetic.main.fragment_history.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : BaseFragment(R.layout.fragment_history) {

    private val viewModel by viewModel<HistoryViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adt = HistoryAdapter()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adt
        }

        viewModel.response.observe { response->
            adt.setList(response.histories)
        }

        viewModel.error.observeError()

        viewModel.history(0,0)
    }

}