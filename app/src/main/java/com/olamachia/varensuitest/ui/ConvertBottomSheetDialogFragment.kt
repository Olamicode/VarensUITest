package com.olamachia.varensuitest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.olamachia.varensuitest.ui.adapter.CurrenciesAdapter
import com.olamachia.varensuitest.utils.DataModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import olamachia.varensuitest.databinding.FragmentDialogSheetBottomConvertBinding

class ConvertBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentDialogSheetBottomConvertBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val CONVERT_BOTTOM_SHEET_DIALOG_TAG = "ConvertBottomSheetDialogFragmentTag"
        fun newInstance(): ConvertBottomSheetDialogFragment {
            return ConvertBottomSheetDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogSheetBottomConvertBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currencies = DataModelProvider.provideCurrencies()
        val currenciesAdapter = CurrenciesAdapter(currencies) {
            Toast.makeText(requireContext(), "${it.name} is clicked",
                Toast.LENGTH_SHORT).show()
        }

        binding.apply {
            currencyRecyclerView.apply {
                adapter = currenciesAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            closeImageView.setOnClickListener {
                findNavController().popBackStack()
                dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}