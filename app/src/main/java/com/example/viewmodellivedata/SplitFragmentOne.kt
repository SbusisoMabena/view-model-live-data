package com.example.viewmodellivedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodellivedata.data.viewmodels.TotalsViewModel

class SplitFragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_split_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareViewModel()
    }

    private fun prepareViewModel() {
        val totalsViewModel = ViewModelProvider(requireActivity()).get(TotalsViewModel::class.java)

        totalsViewModel.getTotal().observe(viewLifecycleOwner) {
            updateText(it)
        }
        view?.findViewById<Button>(R.id.fragment_split_one_button)?.setOnClickListener {
            totalsViewModel.increaseTotal()
        }
    }

    private fun updateText(total: Int) {
        view?.findViewById<TextView>(R.id.fragment_split_one_text_view)?.text =
            getString(R.string.total, total)
    }
}