package it.fbonfadelli.navigation.component.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val ARG_PARAM_EXTRACTION = "extraction"

class ExtractionDetailFragment : Fragment() {
    private lateinit var extraction: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            extraction = it.getString(ARG_PARAM_EXTRACTION, "NOOOOOO!!!!")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_extraction_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView?>(R.id.detail_text_view)?.apply { this.text = extraction }
    }

    companion object {
        @JvmStatic
        fun newInstance(extraction: String) =
            ExtractionDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_EXTRACTION, extraction)
                }
            }
    }
}