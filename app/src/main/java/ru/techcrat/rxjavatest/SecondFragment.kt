package ru.techcrat.rxjavatest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.techcrat.rxjavatest.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var viewBinding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =  FragmentSecondBinding.inflate(inflater, container, false).let {
        viewBinding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.buttonSecond?.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}
