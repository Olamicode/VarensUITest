package com.olamachia.varensuitest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import olamachia.varensuitest.R
import olamachia.varensuitest.databinding.FragmentExchangeBinding


class ExchangeFragment : Fragment(R.layout.fragment_exchange) {
    private var _binding: FragmentExchangeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentExchangeBinding.bind(view)

        ConvertBottomSheetDialogFragment.newInstance()
            .show(parentFragmentManager.beginTransaction(),
                ConvertBottomSheetDialogFragment.CONVERT_BOTTOM_SHEET_DIALOG_TAG)

        binding.apply {
            arrowLeftImageView.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}